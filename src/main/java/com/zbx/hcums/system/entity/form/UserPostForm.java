package com.zbx.hcums.system.entity.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@Data
public class UserPostForm {

    @NotNull(message = "昵称不能为空")
    private String name;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "头像不能为空")
    private String avatar;

    @NotNull(message = "密码不能为空")
    private String password;

    private Boolean isEnable = true;
    private Boolean isLock = false;

}
