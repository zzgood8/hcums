package com.zbx.hcums.system.service;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
public interface IRolePermissionService {

    void addOne(Long roleId, Long permissionId);

    void removeOne(Long roleId, Long permissionId);

}
