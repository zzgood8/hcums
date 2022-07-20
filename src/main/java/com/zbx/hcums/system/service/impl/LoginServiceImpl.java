package com.zbx.hcums.system.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.dao.UserMapper;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    UserMapper userMapper;

    LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(String username, String password) {
        UserPo user = userMapper.selectByUsername(username);
        // 验证用户名
        if (ObjectUtil.isNull(user)) {
            throw new BaseException(CommonStatusCode.USER_NOT_EXISTS);
        }
        // 验证是否可用
        if (BooleanUtil.isTrue(user.getIsLock())) {
            throw new BaseException(CommonStatusCode.USER_LOCKED);
        }
        // 验证密码
        String encodePass = SaSecureUtil.sha256(password);
        if (!StrUtil.equals(user.getPassword(),encodePass)) {
            throw new BaseException(CommonStatusCode.PASSWORD_ERROR);
        }
        // 执行登录,返回token
        StpUtil.login(user.getUsername());
        return StpUtil.getTokenInfo().getTokenValue();
    }

}
