package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.PermissionPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【A_permission(系统权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.PermissionPo
*/
@Mapper
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PermissionPo record);

    int insertSelective(PermissionPo record);

    PermissionPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionPo record);

    int updateByPrimaryKey(PermissionPo record);

}
