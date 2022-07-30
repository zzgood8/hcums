package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户
 * @TableName system_user
 */
@Data
public class UserPo implements Serializable {
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
     * 登录失败次数
     */
    private Integer loginFailure;

    /**
     * 登录时间
     */
    private Date lastLoginTime;

    /**
     * 登录IP
     */
    private String lastLoginIp;

    /**
     * 密码
     */
    private String password;

    /**
     * 签名
     */
    private String motto;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Date updateBy;

    /**
     * 状态:0=禁用,1=启用
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;
}