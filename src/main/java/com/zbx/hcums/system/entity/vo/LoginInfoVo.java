package com.zbx.hcums.system.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zbx
 * @date 2022/7/30
 * @describe
 **/
@Data
public class LoginInfoVo {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 登录时间
     */
    private Date lastLoginTime;

}
