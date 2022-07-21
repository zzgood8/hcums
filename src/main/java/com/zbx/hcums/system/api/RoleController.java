package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.RoleDelForm;
import com.zbx.hcums.system.entity.form.RoleGetForm;
import com.zbx.hcums.system.entity.form.RolePostForm;
import com.zbx.hcums.system.entity.form.RolePutForm;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/role")
public class RoleController {

    /**
     * 获取角色列表
     * @param roleGetForm
     * @return
     */
    @GetMapping
    public Result<?> get(RoleGetForm roleGetForm) {
        return Result.failed();
    }

    @PostMapping
    public Result<?> post(RolePostForm rolePostForm) {
        return Result.failed();
    }

    @PutMapping
    public Result<?> put(RolePutForm rolePutForm) {
        return Result.failed();
    }

    @DeleteMapping
    public Result<?> delete(RoleDelForm roleDelForm) {
        return Result.failed();
    }

}
