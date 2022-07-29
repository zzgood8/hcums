package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.GroupRulePo;

/**
* @author Administrator
* @description 针对表【system_group_rule(分组权限映射表)】的数据库操作Mapper
* @createDate 2022-07-29 11:14:21
* @Entity com.zbx.hcums.sys.entity.po.GroupRulePo
*/
public interface GroupRuleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GroupRulePo record);

    int insertSelective(GroupRulePo record);

    GroupRulePo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupRulePo record);

    int updateByPrimaryKey(GroupRulePo record);

}
