package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.RolePermissionForm;
import com.zbx.hcums.system.service.IRolePermissionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/rolePermission")
public class RolePermissionController {

    private final IRolePermissionService rolePermissionService;

    RolePermissionController(IRolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    public Result<?> post(@Validated @RequestBody RolePermissionForm params) {
        rolePermissionService.addOne(params.getRoleId(), params.getPermissionId());
        return Result.success();
    }

    @DeleteMapping
    public Result<?> delete(@Validated @RequestBody RolePermissionForm params) {
        rolePermissionService.removeOne(params.getRoleId(), params.getPermissionId());
        return Result.success();
    }

}
