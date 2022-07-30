package com.zbx.hcums.common.status;

import lombok.ToString;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
public enum CommonStatusCode implements IStatusCode{

    SUCCESS(200, ""),
    ERROR(500, "服务器错误"),
    FAILED(400, "客户端错误"),
    USER_NOT_EXISTS(40001, "用户不存在"),
    USER_LOCKED(40002, "用户已被锁定"),
    PASSWORD_ERROR(40003, "登录密码错误"),
    PARAM_ERROR(40004, "参数错误"),
    USER_IS_EXISTS(40004, "用户已经存在"),
    ROLE_IS_EXISTS(40005,"角色已存在"),
    PERMISSION_IS_EXISTS(40005,"权限已存在"),
    CAPTCHA_IS_ERROR(40006, "验证码错误"),
    ACCOUNT_IS_BAN(40007, "用户已被禁止登录");

    private final int code;
    private final String msg;

    CommonStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
