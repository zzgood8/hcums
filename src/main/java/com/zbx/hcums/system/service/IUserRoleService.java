package com.zbx.hcums.system.service;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
public interface IUserRoleService {

    void addOne(Long userId, Long roleId);

    void removeOne(Long userId, Long roleId);

}
