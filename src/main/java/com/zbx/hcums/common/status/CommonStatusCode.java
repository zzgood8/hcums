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
    PARAM_ERROR(40004, "参数错误");

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
