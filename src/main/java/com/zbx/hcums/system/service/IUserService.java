package com.zbx.hcums.system.service;

import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.form.UserPostForm;
import com.zbx.hcums.system.entity.form.UserPutForm;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.entity.vo.UserVo;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
public interface IUserService {

    List<UserVo> getByParams(UserGetForm userGetForm);

    void insert(UserPostForm userPostForm);

    void update(UserPutForm userPutForm);
}
