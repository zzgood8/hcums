package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.PermissionPo;
import com.zbx.hcums.system.entity.vo.PermissionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【A_permission(系统权限表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.PermissionPo
*/
@Mapper
public interface PermissionMapper {

    boolean exists(Long id);

    List<PermissionPo> selectAll();

    List<PermissionVo> selectAllByTree();

    void insert(PermissionPo record);

    void updateNameAndPathById(PermissionPo record);

    void deleteById(Long id);

}
