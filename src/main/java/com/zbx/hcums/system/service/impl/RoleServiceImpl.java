package com.zbx.hcums.system.service.impl;
import java.util.Date;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.dao.RoleMapper;
import com.zbx.hcums.system.dao.RolePermissionMapper;
import com.zbx.hcums.system.dao.UserRoleMapper;
import com.zbx.hcums.system.entity.form.RolePostForm;
import com.zbx.hcums.system.entity.form.RolePutForm;
import com.zbx.hcums.system.entity.po.RolePo;
import com.zbx.hcums.system.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

    private final RoleMapper roleMapper;
    private final UserRoleMapper userRoleMapper;
    private final RolePermissionMapper rolePermissionMapper;

    RoleServiceImpl(RoleMapper roleMapper,
                    UserRoleMapper userRoleMapper,
                    RolePermissionMapper rolePermissionMapper) {
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<RolePo> getAllRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public void insert(RolePostForm rolePostForm) {
        boolean exists = roleMapper.exists(rolePostForm.getName());
        if (!exists) {
            RolePo rolePo = new RolePo();
            rolePo.setName(rolePostForm.getName());
            rolePo.setCreateTime(new Date());
            rolePo.setCreateBy(StpUtil.getLoginIdAsString());
            roleMapper.insert(rolePo);
        } else {
            throw new BaseException(CommonStatusCode.ROLE_IS_EXISTS);
        }
    }

    @Override
    public void update(RolePutForm rolePutForm) {
        boolean exists = roleMapper.exists(rolePutForm.getName());
        if (!exists) {
            RolePo rolePo = new RolePo();
            rolePo.setId(rolePutForm.getId());
            rolePo.setName(rolePutForm.getName());
            rolePo.setUpdateTime(new Date());
            rolePo.setUpdateBy(StpUtil.getLoginIdAsString());
            roleMapper.updateById(rolePo);
        } else {
            throw new BaseException(CommonStatusCode.ROLE_IS_EXISTS);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        roleMapper.deleteById(id);
        userRoleMapper.deleteByRole(id);
        rolePermissionMapper.deleteByRoleId(id);
    }
}
