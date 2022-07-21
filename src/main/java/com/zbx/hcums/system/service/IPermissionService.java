package com.zbx.hcums.system.service;

import com.zbx.hcums.system.entity.form.PermissionDelForm;
import com.zbx.hcums.system.entity.form.PermissionGetForm;
import com.zbx.hcums.system.entity.form.PermissionPostForm;
import com.zbx.hcums.system.entity.form.PermissionPutForm;
import com.zbx.hcums.system.entity.po.PermissionPo;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
public interface IPermissionService {

    /**
     * 通过参数去查询权限列表
     * @param permissionGetForm
     * @return
     */
    List<PermissionPo> getByParams(PermissionGetForm permissionGetForm);

    /**
     * 保存一个权限
     * @param permissionPostForm
     */
    void insert(PermissionPostForm permissionPostForm);

    /**
     * 修改权限
     * @param params
     */
    void updateByParams(PermissionPutForm params);

    /**
     * 删除权限
     * @param id
     */
    void deleteById(Long id);
}
