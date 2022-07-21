package com.zbx.hcums.system.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统权限表
 * @TableName A_permission
 */
@Data
public class PermissionPo implements Serializable {
    /**
     * 权限id
     */
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限路径
     */
    private String path;

    /**
     * 是否菜单权限
     */
    private Boolean isMenu;

    /**
     * 权限父类
     */
    private Long parentId;

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