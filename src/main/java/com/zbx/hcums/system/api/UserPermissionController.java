package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.UserPermissionForm;
import com.zbx.hcums.system.service.IUserPermissionService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/userPermission")
public class UserPermissionController {

    private final IUserPermissionService userPermissionService;

    UserPermissionController(IUserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    /**
     * 给用户添加一个权限
     */
    @PostMapping
    public Result<?> post(UserPermissionForm userPermissionForm) {
        userPermissionService.addOne(userPermissionForm.getUserId(), userPermissionForm.getPermissionId());
        return Result.success();
    }

    /**
     * 删除用户的一个权限
     */
    @DeleteMapping
    public Result<?> delete(UserPermissionForm userPermissionForm) {
        userPermissionService.removeOne(userPermissionForm.getUserId(), userPermissionForm.getPermissionId());
        return Result.success();
    }

}
