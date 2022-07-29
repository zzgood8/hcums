package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserGroupPo;

/**
* @author Administrator
* @description 针对表【system_user_group(用户分组映射表)】的数据库操作Mapper
* @createDate 2022-07-29 11:14:21
* @Entity com.zbx.hcums.sys.entity.po.UserGroupPo
*/
public interface UserGroupMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserGroupPo record);

    int insertSelective(UserGroupPo record);

    UserGroupPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserGroupPo record);

    int updateByPrimaryKey(UserGroupPo record);

}
