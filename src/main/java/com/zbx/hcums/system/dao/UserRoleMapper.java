package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserRolePo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【A_user_role(用户角色表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.UserRolePo
*/
@Mapper
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRolePo record);

    int insertSelective(UserRolePo record);

    UserRolePo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRolePo record);

    int updateByPrimaryKey(UserRolePo record);

}
