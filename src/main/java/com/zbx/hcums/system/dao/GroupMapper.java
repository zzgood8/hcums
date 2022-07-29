package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.GroupPo;

/**
* @author Administrator
* @description 针对表【system_group(用户分组表)】的数据库操作Mapper
* @createDate 2022-07-29 11:14:21
* @Entity com.zbx.hcums.sys.entity.po.GroupPo
*/
public interface GroupMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GroupPo record);

    int insertSelective(GroupPo record);

    GroupPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupPo record);

    int updateByPrimaryKey(GroupPo record);

}
