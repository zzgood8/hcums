package com.zbx.hcums.system.service;

import com.zbx.hcums.system.entity.form.LoginForm;

import java.io.OutputStream;

/**
 * @author zbx
 * @date 2022/7/29
 * @describe
 **/
public interface ILoginService {

    /**
     * 用户登录接口
     * @param loginForm 登录表单
     * @return token令牌
     */
    String login(LoginForm loginForm);

    /**
     * 用户登出
     */
    void logout();

    /**
     * 生成验证码
     * @param uuid 验证码key
     * @param out 输出流
     */
    void generateCaptcha(String uuid, OutputStream out);
}
