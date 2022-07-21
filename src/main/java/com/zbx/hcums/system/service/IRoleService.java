package com.zbx.hcums.system.service;

import com.zbx.hcums.system.entity.form.RolePostForm;
import com.zbx.hcums.system.entity.form.RolePutForm;
import com.zbx.hcums.system.entity.po.RolePo;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
public interface IRoleService {

    List<RolePo> getAllRoles();

    void insert(RolePostForm rolePostForm);

    void update(RolePutForm rolePutForm);

    void deleteById(Long id);

}
