package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.RulePo;

/**
* @author Administrator
* @description 针对表【system_rule(权限规则)】的数据库操作Mapper
* @createDate 2022-07-29 11:14:21
* @Entity com.zbx.hcums.sys.entity.po.RulePo
*/
public interface RuleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RulePo record);

    int insertSelective(RulePo record);

    RulePo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RulePo record);

    int updateByPrimaryKey(RulePo record);

}
