package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
@Data
public class LoginForm {

    @NotNull(message = "用户不能为空！")
    @Size(min = 3, max = 20, message = "用户长度为6-30")
    private String username;

    @NotNull(message = "密码不能为空！")
    @Size(min = 6, max = 30, message = "非法密码！")
    private String password;

}
