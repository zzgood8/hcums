package com.zbx.hcums.system.api;

import cn.hutool.core.util.StrUtil;
import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.entity.form.PermissionDelForm;
import com.zbx.hcums.system.entity.form.PermissionGetForm;
import com.zbx.hcums.system.entity.form.PermissionPostForm;
import com.zbx.hcums.system.entity.form.PermissionPutForm;
import com.zbx.hcums.system.entity.po.PermissionPo;
import com.zbx.hcums.system.service.IPermissionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/permission")
public class PermissionController {

    private final IPermissionService permissionService;

    PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 通过参数获取权限列表
     */
    @GetMapping
    public Result<List<PermissionPo>> get(PermissionGetForm permissionGetForm) {
        List<PermissionPo> list = permissionService.getByParams(permissionGetForm);
        return Result.success(list);
    }

    /**
     * 新增权限信息
     */
    @PostMapping
    public Result<?> post(PermissionPostForm permissionPostForm) {
        if (permissionPostForm.getParentId() == 0L && !permissionPostForm.getIsMenu()) {
            return Result.ofStatus(CommonStatusCode.PARAM_ERROR, "根权限必须是菜单");
        }
        permissionService.insert(permissionPostForm);
        return Result.success();
    }

    /**
     * 修改权限信息
     */
    @PutMapping
    public Result<?> put(PermissionPutForm permissionPutForm) {
        if (StrUtil.isEmpty(permissionPutForm.getName()) && StrUtil.isEmpty(permissionPutForm.getPath())) {
            return Result.ofStatus(CommonStatusCode.PARAM_ERROR, "路径和名称不能都为空");
        }
        permissionService.updateByParams(permissionPutForm);
        return Result.success();
    }

    /**
     * 删除一个权限
     */
    @DeleteMapping
    public Result<?> delete(@Validated PermissionDelForm permissionDelForm) {
        permissionService.deleteById(permissionDelForm.getPermissionId());
        return Result.success();
    }

}
