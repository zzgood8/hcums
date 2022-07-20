package com.zbx.hcums.common.exception;

import com.zbx.hcums.common.status.IStatusCode;
import lombok.Getter;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
@Getter
public class BaseException extends RuntimeException{

    IStatusCode statusCode;

    public BaseException(IStatusCode statusCode) {
        super(statusCode.getMsg());
        this.statusCode = statusCode;
    }
}
