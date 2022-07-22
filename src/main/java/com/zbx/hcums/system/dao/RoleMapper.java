package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.RolePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【A_role(系统角色表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.RolePo
*/
@Mapper
public interface RoleMapper {

    List<RolePo> selectAll();

    RolePo selectById(Long id);

    boolean exists(String roleName);

    void insert(RolePo record);

    void updateById(RolePo record);

    void deleteById(Long id);
}
