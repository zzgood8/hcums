package com.zbx.hcums.system.service.impl;

import com.zbx.hcums.system.dao.UserMapper;
import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.entity.vo.UserVo;
import com.zbx.hcums.system.service.IUserService;
import org.springframework.stereotype.Service;

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
    public List<UserVo> getAllUsers() {
        return  userMapper
    }

    @Override
    public List<UserVo> getByParams(UserGetForm userGetForm) {
        return userMapper.selectByParams(userGetForm);
    }
}
