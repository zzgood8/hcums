package com.zbx.hcums.system.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@Data
public class PermissionPostForm {

    @NotNull(message = "权限名称不能为空")
    private String name;

    @NotNull(message = "权限路径不能为空")
    private String path;

    private Boolean isMenu = false;

    private Long parentId = 0L;


}
