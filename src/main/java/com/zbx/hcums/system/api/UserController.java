package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.form.UserPostForm;
import com.zbx.hcums.system.entity.vo.UserVo;
import com.zbx.hcums.system.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@RestController
@RequestMapping("system/user")
public class UserController {

    IUserService userService;

    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Result<?> get(UserGetForm userGetForm) {
        List<UserVo> allUsers = userService.getByParams(userGetForm);
        return Result.success(allUsers);
    }

    public Result<?> post(UserPostForm userPostForm) {
        return Result.failed();
    }

}
