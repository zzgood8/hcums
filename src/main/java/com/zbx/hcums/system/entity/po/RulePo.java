package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限规则
 * @TableName system_rule
 */
@Data
public class RulePo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 规则路径
     */
    private String path;

    /**
     * 类型:menuSub=菜单目录,menuItem=菜单项,permission=权限
     */
    private Object type;

    /**
     * 方法:get=查询,post=新增,put=修改,delete=删除
     */
    private Object method;

    /**
     * 权重(排序)
     */
    private Integer weigh;

    /**
     * 备注
     */
    private String remark;

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