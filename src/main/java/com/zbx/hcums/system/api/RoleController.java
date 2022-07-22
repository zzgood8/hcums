package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.RoleDelForm;
import com.zbx.hcums.system.entity.form.RoleGetForm;
import com.zbx.hcums.system.entity.form.RolePostForm;
import com.zbx.hcums.system.entity.form.RolePutForm;
import com.zbx.hcums.system.entity.po.RolePo;
import com.zbx.hcums.system.service.IRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/role")
public class RoleController {

    private final IRoleService roleService;

    RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 获取角色列表
     */
    @GetMapping
    public Result<List<RolePo>> get(RoleGetForm roleGetForm) {
        List<RolePo> allRoles = roleService.getAllRoles();
        return Result.success(allRoles);
    }

    @PostMapping
    public Result<?> post(RolePostForm rolePostForm) {
        roleService.insert(rolePostForm);
        return Result.success();
    }

    @PutMapping
    public Result<?> put(RolePutForm rolePutForm) {
        roleService.update(rolePutForm);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> delete(RoleDelForm roleDelForm) {
        roleService.deleteById(roleDelForm.getRoleId());
        return Result.success();
    }

}
