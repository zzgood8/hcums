package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.UserRoleForm;
import com.zbx.hcums.system.service.IUserRoleService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/userRole")
public class UserRoleController {

    private final IUserRoleService userRoleService;

    UserRoleController(IUserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public Result<?> post(UserRoleForm userRoleForm) {
        userRoleService.addOne(userRoleForm.getUserId(), userRoleForm.getRoleId());
        return Result.success();
    }

    @DeleteMapping
    public Result<?> delete(UserRoleForm userRoleForm) {
        userRoleService.removeOne(userRoleForm.getUserId(), userRoleForm.getRoleId());
        return Result.success();
    }
}
