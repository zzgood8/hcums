package com.zbx.hcums.config.exception;

import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.common.status.CommonStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 基类异常处理
    @ExceptionHandler(BaseException.class)
    public Result<?> handlerException(BaseException e) {
        return Result.ofStatus(e.getStatusCode());
    }

    @ExceptionHandler(BindException.class)
    public Result<?> handlerException(BindException e) {
        List<FieldError> allErrors = e.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getDefaultMessage()).append(" ");
            log.info("参数校验错误: {} => {}", errorMessage.getField(), errorMessage.getDefaultMessage());
        }
        return Result.ofStatus(CommonStatusCode.PARAM_ERROR, sb.toString());
    }

    @ExceptionHandler(ValidationException.class)
    public Result<?> handlerException(ValidationException e) {
        log.info("参数校验错误: {}", e.getMessage());
        return Result.ofStatus(CommonStatusCode.PARAM_ERROR, e.getMessage());
    }

    @ExceptionHandler()
    public Result<?> handlerException(Exception e) {
        e.printStackTrace();
        return Result.ofStatus(CommonStatusCode.ERROR, e.getMessage());
    }
}
