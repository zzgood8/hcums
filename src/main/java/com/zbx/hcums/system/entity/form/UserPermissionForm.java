package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Data
public class UserPermissionForm {

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "权限ID不能为空")
    private Long PermissionId;

}
