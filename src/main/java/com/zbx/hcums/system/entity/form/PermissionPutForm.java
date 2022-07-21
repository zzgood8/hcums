package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@Data
public class PermissionPutForm {

    @NotNull(message = "权限ID不能为空")
    private Long permissionId;

    private String name;

    private String path;

}
