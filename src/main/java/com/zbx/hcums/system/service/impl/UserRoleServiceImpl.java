package com.zbx.hcums.system.service.impl;
import java.util.Date;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.hcums.system.dao.UserRoleMapper;
import com.zbx.hcums.system.entity.po.UserRolePo;
import com.zbx.hcums.system.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Service
@Slf4j
public class UserRoleServiceImpl implements IUserRoleService {

    private final UserRoleMapper userRoleMapper;

    UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public void addOne(Long userId, Long roleId) {
        boolean exists = userRoleMapper.exists(userId, roleId);
        if (!exists) {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(userId);
            userRolePo.setRoleId(roleId);
            userRolePo.setCreateTime(new Date());
            userRolePo.setCreateBy(StpUtil.getLoginIdAsString());
            userRoleMapper.insert(userRolePo);
        } else {
            log.info("用户: {} 已有角色: {}", userId, roleId);
        }
    }

    @Override
    public void removeOne(Long userId, Long roleId) {
        boolean exists = userRoleMapper.exists(userId, roleId);
        if (exists) {
            userRoleMapper.deleteUserRole(userId, roleId);
        }
    }
}
