package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserRolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【A_user_role(用户角色表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.UserRolePo
*/
@Mapper
public interface UserRoleMapper {

    /**
     * 判断当前用户角色是否已存在
     * @param userId
     * @param roleId
     * @return
     */
    boolean exists(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 删除用户的一个角色
     * @param userId
     * @param roleId
     */
    void deleteUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 删除所有用户的某个角色
     * @param roleId
     */
    void deleteByRole(@Param("roleId") Long roleId);

    /**
     * 给用户添加一个角色
     * @param record
     */
    void insert(UserRolePo record);

}
