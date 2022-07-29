package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import lombok.Data;

/**
 * 验证码表
 * @TableName system_captcha
 */
@Data
public class CaptchaPo implements Serializable {
    /**
     * 验证码Key
     */
    private String key;

    /**
     * 验证码(加密后的,用于验证)
     */
    private String code;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    private static final long serialVersionUID = 1L;
}