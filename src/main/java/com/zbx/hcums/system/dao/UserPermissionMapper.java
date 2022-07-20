package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserPermissionPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【A_user_permission(用户权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.UserPermissionPo
*/
@Mapper
public interface UserPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserPermissionPo record);

    int insertSelective(UserPermissionPo record);

    UserPermissionPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPermissionPo record);

    int updateByPrimaryKey(UserPermissionPo record);

}
