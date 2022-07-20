package com.zbx.hcums.system.service;

import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.entity.vo.UserVo;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
public interface IUserService {

    List<UserVo> getAllUsers();

    List<UserVo> getByParams(UserGetForm userGetForm);
}
