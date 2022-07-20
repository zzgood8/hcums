package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 用户信息表
 * @TableName A_user
 */
@Data
public class UserPo implements Serializable {
    /**
     * 系统用户id
     */
    private Long id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    @JsonIgnore()
    private String password;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 是否锁定
     */
    private Boolean isLock;

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
    private String updateBy;

    private static final long serialVersionUID = 1L;
}