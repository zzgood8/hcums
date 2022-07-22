package com.zbx.hcums.system.service.impl;
import java.util.Date;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.system.dao.RolePermissionMapper;
import com.zbx.hcums.system.entity.po.RolePermissionPo;
import com.zbx.hcums.system.service.IRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Service
@Slf4j
public class RolePermissionServiceImpl implements IRolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public void addOne(Long roleId, Long permissionId) {
        boolean exists = rolePermissionMapper.exists(roleId, permissionId);
        if (!exists) {
            RolePermissionPo rolePermissionPo = new RolePermissionPo();
            rolePermissionPo.setRoleId(roleId);
            rolePermissionPo.setPermissionId(permissionId);
            rolePermissionPo.setCreateTime(new Date());
            rolePermissionPo.setCreateBy(StpUtil.getLoginIdAsString());
            rolePermissionMapper.insert(rolePermissionPo);
        } else {
            log.info("角色: {} 已有权限: {}", roleId, permissionId);
        }
    }

    @Override
    public void removeOne(Long roleId, Long permissionId) {
        boolean exists = rolePermissionMapper.exists(roleId, permissionId);
        if (exists) {
            rolePermissionMapper.delete(roleId, permissionId);
        }
    }
}
