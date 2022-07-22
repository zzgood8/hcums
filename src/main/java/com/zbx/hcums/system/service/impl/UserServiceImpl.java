package com.zbx.hcums.system.service.impl;
import java.util.Date;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zbx.hcums.common.exception.BaseException;
import com.zbx.hcums.common.status.CommonStatusCode;
import com.zbx.hcums.system.dao.UserMapper;
import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.form.UserPostForm;
import com.zbx.hcums.system.entity.form.UserPutForm;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.entity.vo.UserVo;
import com.zbx.hcums.system.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserVo> getByParams(UserGetForm userGetForm) {
        return userMapper.selectByParams(userGetForm);
    }


    @Override
    public void insert(UserPostForm userPostForm) {
        UserPo userPo = userMapper.selectByUsername(userPostForm.getUsername());
        if (ObjectUtil.isNull(userPo)) {
            UserPo u = new UserPo();
            u.setName(userPostForm.getName());
            u.setUsername(userPostForm.getUsername());
            u.setAvatar(userPostForm.getAvatar());
            u.setPassword(SaSecureUtil.sha256(userPostForm.getPassword()));
            u.setIsEnable(true);
            u.setIsLock(false);
            u.setCreateTime(new Date());
            u.setCreateBy(StpUtil.getLoginIdAsString());
            userMapper.insert(u);
        } else {
            throw new BaseException(CommonStatusCode.USER_IS_EXISTS);
        }
    }

    @Override
    public void update(UserPutForm userPutForm) {
    }
}
