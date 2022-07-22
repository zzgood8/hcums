package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.RolePermissionPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【A_role_permission(角色权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.RolePermissionPo
*/
@Mapper
public interface RolePermissionMapper {

    boolean exists(@Param("roleId") Long roleId, @Param("PermissionId") Long permissionId);

    void insert(RolePermissionPo record);

    void delete(@Param("roleId") Long roleId, @Param("PermissionId") Long permissionId);

    void deleteByPermissionId(Long permissionId);

    void deleteByRoleId(Long roleId);

}
