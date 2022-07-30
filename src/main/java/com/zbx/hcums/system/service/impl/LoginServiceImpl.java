package com.zbx.hcums.system.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.dao.CaptchaMapper;
import com.zbx.hcums.system.dao.UserMapper;
import com.zbx.hcums.system.entity.form.LoginForm;
import com.zbx.hcums.system.entity.po.CaptchaPo;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.Date;

/**
 * @author zbx
 * @date 2022/7/29
 * @describe
 **/
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    private final CaptchaMapper captchaMapper;

    private final UserMapper userMapper;

    public LoginServiceImpl(CaptchaMapper captchaMapper,
                     UserMapper userMapper) {
        this.captchaMapper = captchaMapper;
        this.userMapper = userMapper;
    }

    @Override
    public String login(LoginForm loginForm) {
        // 获取验证码
        CaptchaPo captchaPo = captchaMapper.selectByKey(loginForm.getCaptcha_id());
        // 删除一次性验证码
        if (ObjectUtil.isNotNull(captchaPo)) captchaMapper.deleteByKey(captchaPo.getKey());
        // 校验验证码
        if (ObjectUtil.isNull(captchaPo)
                || !StrUtil.equals(loginForm.getCaptcha(), captchaPo.getCode())
                || DateUtil.currentSeconds() >= captchaPo.getExpireTime()) {
            throw new BaseException(CommonStatusCode.CAPTCHA_IS_ERROR);
        }
        // 获取用户信息
        UserPo userPo = userMapper.selectByUsername(loginForm.getUsername());
        if (ObjectUtil.isNull(userPo)) {
            throw new BaseException(CommonStatusCode.USER_NOT_EXISTS);
        }
        // 校验是否锁定
        if (!userPo.getStatus()) {
            throw new BaseException(CommonStatusCode.USER_LOCKED);
        }
        // 验证是否封禁
        if (StpUtil.isDisable(userPo.getUsername())) {
            throw new BaseException(CommonStatusCode.ACCOUNT_IS_BAN);
        }
        // 多次失败提醒,超过3次,每次间隔5分钟
        if (userPo.getLoginFailure() > 3) {
            StpUtil.disable(userPo.getUsername(), 60 * 5); // 封禁五分钟
            log.warn("用户多次尝试登录失败,已尝试次数: {}", userPo.getLoginFailure());
        }
        // 校验密码
        String pass = SaSecureUtil.sha256(loginForm.getPassword());
        if (!StrUtil.equals(userPo.getPassword(), pass)) {
            userMapper.setLoginFailure(userPo.getId());
            throw new BaseException(CommonStatusCode.PASSWORD_ERROR);
        }
        // 登录成功
        StpUtil.login(userPo.getUsername());
        userMapper.setLoginFailure(userPo.getId()); // 清除失败次数
        userMapper.updateLastLogin(new Date(), loginForm.getLoginIp()); // 记录登录信息
        captchaMapper.deleteByExpireTime(DateUtil.currentSeconds()); // 清除过期验证码
        log.info("用户: {} 登录成功", userPo.getUsername());
        return StpUtil.getTokenInfo().getTokenValue();
    }

    @Override
    public void logout() {
        if (StpUtil.isLogin()) {
            log.info("用户: {} 登出", StpUtil.getLoginIdAsString());
            StpUtil.logout();
        }
    }

    @Override
    public void generateCaptcha(String uuid, OutputStream out) {
        // 查询key是否存在
        CaptchaPo captchaPo = captchaMapper.selectByKey(uuid);
        if (ObjectUtil.isNotNull(captchaPo)) {
            captchaMapper.deleteByKey(uuid);
        }
        // 生成验证码
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(176, 55);
        String code = gifCaptcha.getCode();
        CaptchaPo captcha = new CaptchaPo();
        captcha.setKey(uuid);
        captcha.setCode(code);
        captcha.setCreateTime(DateUtil.currentSeconds());
        captcha.setExpireTime(DateUtil.offsetMinute(new Date(), 5).getTime()/1000); // 过期时间5分钟
        // 存储验证码
        captchaMapper.insert(captcha);
        gifCaptcha.write(out);
    }

}
