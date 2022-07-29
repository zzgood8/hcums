package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户分组表
 * @TableName system_group
 */
@Data
public class GroupPo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 分组名称
     */
    private String name;

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
    private Integer status;

    private static final long serialVersionUID = 1L;
}