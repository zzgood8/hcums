package com.zbx.hcums.system.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zbx.hcums.system.dao.CaptchaMapper;
import com.zbx.hcums.system.entity.form.LoginForm;
import com.zbx.hcums.system.entity.po.CaptchaPo;
import com.zbx.hcums.system.service.ILoginService;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.Date;

/**
 * @author zbx
 * @date 2022/7/29
 * @describe
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    private final CaptchaMapper captchaMapper;

    LoginServiceImpl(CaptchaMapper captchaMapper) {
        this.captchaMapper = captchaMapper;
    }

    @Override
    public String login(LoginForm loginForm) {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public void generateCaptcha(String uuid, OutputStream out) {
        // 查询key是否存在
        CaptchaPo captchaPo = captchaMapper.selectByKey(uuid);
        if (ObjectUtil.isNotNull(captchaPo)) {
            captchaMapper.deleteByKey(uuid);
        }
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(176, 55);
        String code = gifCaptcha.getCode();
        CaptchaPo captcha = new CaptchaPo();
        captcha.setKey(uuid);
        captcha.setCode(code);
        captcha.setCreateTime(DateUtil.currentSeconds());
        captcha.setExpireTime(DateUtil.offsetMinute(new Date(), 5).getTime()/1000); // 过期时间5分钟
        captchaMapper.insert(captcha);
        gifCaptcha.write(out);
    }

}
