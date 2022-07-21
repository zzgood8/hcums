package com.zbx.hcums.system.api;

import cn.hutool.core.util.StrUtil;
import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.entity.form.LoginForm;
import com.zbx.hcums.system.service.ILoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbx
 * @date 2022/7/18
 * @describe
 **/
@RestController
public class LoginController {

    ILoginService loginService;

    LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 用户登录接口
     * @param loginForm 登录表单
     * @return token令牌
     */
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody LoginForm loginForm) {
        String login = loginService.login(loginForm.getUsername(), loginForm.getPassword());
        return Result.success(login);
    }

}
