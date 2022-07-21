package com.zbx.hcums.system.api;

import com.zbx.hcums.common.res.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@RestController
@RequestMapping("/system/userRole")
public class UserRoleController {

    @GetMapping
    public Result<?> get() {
        return Result.failed();
    }

    @PostMapping
    public Result<?> post() {
        return Result.failed();
    }

    @PutMapping
    public Result<?> put() {
        return Result.failed();
    }

    @DeleteMapping
    public Result<?> delete() {
        return Result.failed();
    }
}
