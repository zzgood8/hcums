package com.zbx.hcums.system.service;

import com.zbx.hcums.common.exception.BaseException;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
public interface ILoginService {

    /**
     * 验证用户名密码实现登录
     * @param username 用户名
     * @param password 密码
     * @return token令牌
     * @throws BaseException 验证失败时,抛出异常
     */
    String login(String username, String password);
}