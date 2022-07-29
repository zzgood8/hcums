package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.UserPo;

/**
* @author Administrator
* @description 针对表【system_user(系统用户)】的数据库操作Mapper
* @createDate 2022-07-29 11:14:21
* @Entity com.zbx.hcums.sys.entity.po.UserPo
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

}
