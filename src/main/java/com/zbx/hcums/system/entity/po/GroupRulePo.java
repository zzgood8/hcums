package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 分组权限映射表
 * @TableName system_group_rule
 */
@Data
public class GroupRulePo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 组id
     */
    private Long groupId;

    /**
     * 规则id
     */
    private Long ruleId;

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