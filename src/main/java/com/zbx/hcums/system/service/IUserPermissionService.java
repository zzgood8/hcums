package com.zbx.hcums.system.service;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
public interface IUserPermissionService {

    void addOne(Long userId, Long PermissionId);

    void removeOne(Long userId, Long PermissionId);

    void removeByPermissionId(Long PermissionId);
}
