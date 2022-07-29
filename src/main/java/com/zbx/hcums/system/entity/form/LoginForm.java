package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zbx
 * @date 2022/7/29
 * @describe
 **/
@Data
public class LoginForm {

    @NotNull(message = "用户名不能为空")
    @Min(value = 3, message = "用户名长度不能小于3位")
    private String username;

    @NotNull(message = "密码不能为空")
    @Min(value = 6, message = "密码长度不能小于6位")
    private String password;

    @NotNull(message = "验证码id不能为空")
    private String captchaId;

    @Size(min = 4, max = 6, message = "验证码的长度必须在4-6之间")
    @NotNull(message = "验证码不能为空")
    private String captcha;

}
