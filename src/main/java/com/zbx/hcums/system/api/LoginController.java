package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import com.zbx.hcums.system.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author zbx
 * @date 2022/7/29
 * @describe
 **/
@RestController
@Validated
@Slf4j
public class LoginController {

    private final ILoginService loginService;

    LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    // 登录
    @PostMapping("/login")
    public Result<String> login() {
        return Result.success("login success");
    }

    // 登出
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success("logout success");
    }

    // 获取验证码
    @GetMapping("/login/captcha")
    public void generateCaptcha(@NotNull(message = "验证码id不能为空") String uuid,
                                HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            loginService.generateCaptcha(uuid, outputStream);
            outputStream.close();
        }catch (IOException e) {
            log.warn("发生异常：{}", e.getMessage());
        }
    }

    // 获取登录信息

}
