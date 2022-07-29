package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户分组映射表
 * @TableName system_user_group
 */
@Data
public class UserGroupPo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 分组id
     */
    private Long groupId;

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

    private static final long serialVersionUID = 1L;
}