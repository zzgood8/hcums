package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@Data
public class RolePostForm {

    @NotNull(message = "角色名称不能为空")
    private String name;
}
