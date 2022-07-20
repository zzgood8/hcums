package com.zbx.hcums.common.res;

import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.common.status.IStatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
@Data
@AllArgsConstructor
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return ofStatus(CommonStatusCode.SUCCESS, data);
    }

    public static <T> Result<T> failed() {
        return failed(null);
    }

    public static <T> Result<T> failed(T data) {
        return ofStatus(CommonStatusCode.FAILED, data);
    }

    public static <T> Result<T> error() {
        return error(null);
    }

    public static <T> Result<T> error(T data) {
        return ofStatus(CommonStatusCode.ERROR, data);
    }

    public static <T> Result<T> ofStatus(IStatusCode statusCode) {
        return ofStatus(statusCode,null);
    }

    public static <T> Result<T> ofStatus(IStatusCode statusCode, T data) {
        return new Result<>(statusCode.getCode(), statusCode.getMsg(), data);
    }

}
