package com.zbx.hcums.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.hcums.system.dao.PermissionMapper;
import com.zbx.hcums.system.dao.RolePermissionMapper;
import com.zbx.hcums.system.dao.UserPermissionMapper;
import com.zbx.hcums.system.entity.form.PermissionGetForm;
import com.zbx.hcums.system.entity.form.PermissionPostForm;
import com.zbx.hcums.system.entity.form.PermissionPutForm;
import com.zbx.hcums.system.entity.po.PermissionPo;
import com.zbx.hcums.system.service.IPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@Service
public class PermissionServiceImpl implements IPermissionService {

    private final PermissionMapper permissionMapper;
    private final UserPermissionMapper userPermissionMapper;
    private final RolePermissionMapper rolePermissionMapper;

    PermissionServiceImpl(PermissionMapper permissionMapper,
                          UserPermissionMapper userPermissionMapper,
                          RolePermissionMapper rolePermissionMapper) {
        this.permissionMapper = permissionMapper;
        this.userPermissionMapper = userPermissionMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<PermissionPo> getByParams(PermissionGetForm permissionGetForm) {
        return permissionMapper.selectAll();
    }

    @Override
    public void insert(PermissionPostForm permissionPostForm) {
        PermissionPo p = new PermissionPo();
        p.setName(permissionPostForm.getName());
        p.setPath(permissionPostForm.getPath());
        p.setIsMenu(permissionPostForm.getIsMenu());
        p.setParentId(permissionPostForm.getParentId());
        p.setCreateBy(StpUtil.getLoginIdAsString());
        p.setCreateTime(new Date());
        permissionMapper.insert(p);
    }

    @Override
    public void updateByParams(PermissionPutForm params) {
        PermissionPo p = new PermissionPo();
        p.setId(params.getPermissionId());
        p.setName(params.getName());
        p.setPath(params.getPath());
        p.setUpdateBy(StpUtil.getLoginIdAsString());
        p.setUpdateTime(new Date());
        permissionMapper.updateNameAndPathById(p);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        boolean exists = permissionMapper.exists(id);
        if (exists) {
            permissionMapper.deleteById(id);
            userPermissionMapper.deleteByPermissionId(id);
            rolePermissionMapper.deleteByPermissionId(id);
        }
    }
}
