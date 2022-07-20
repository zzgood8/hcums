package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.RolePermissionPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【A_role_permission(角色权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.RolePermissionPo
*/
@Mapper
public interface RolePermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionPo record);

    int insertSelective(RolePermissionPo record);

    RolePermissionPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionPo record);

    int updateByPrimaryKey(RolePermissionPo record);

}
