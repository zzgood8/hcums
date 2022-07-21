package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserPermissionPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【A_user_permission(用户权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.UserPermissionPo
*/
@Mapper
public interface UserPermissionMapper {

    boolean exists(@Param("userId")Long userId, @Param("permissionId")Long PermissionId);

    void delete(@Param("userId")Long userId, @Param("permissionId")Long PermissionId);

    void deleteByPermissionId(Long PermissionId);

    void insert(UserPermissionPo record);

}
