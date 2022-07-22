package com.zbx.hcums.system.service.impl;
import java.util.Date;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.dao.UserPermissionMapper;
import com.zbx.hcums.system.entity.po.UserPermissionPo;
import com.zbx.hcums.system.service.IUserPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zbx
 * @date 2022/7/22
 * @describe
 **/
@Service
@Slf4j
public class UserPermissionServiceImpl implements IUserPermissionService {

    private final UserPermissionMapper userPermissionMapper;

    UserPermissionServiceImpl(UserPermissionMapper userPermissionMapper) {
        this.userPermissionMapper = userPermissionMapper;
    }

    @Override
    public void addOne(Long userId, Long permissionId) {
        boolean exists = userPermissionMapper.exists(userId, permissionId);
        if (!exists) {
            UserPermissionPo u = new UserPermissionPo();
            u.setUserId(userId);
            u.setPermissionId(permissionId);
            u.setCreateTime(new Date());
            u.setCreateBy(StpUtil.getLoginIdAsString());
            userPermissionMapper.insert(u);
        } else {
            log.info("用户: {} 已有权限: {}", userId, permissionId);
        }
    }

    @Override
    public void removeOne(Long userId, Long permissionId) {
        boolean exists = userPermissionMapper.exists(userId, permissionId);
        if (exists) {
            userPermissionMapper.delete(userId,permissionId);
        }
    }
}
