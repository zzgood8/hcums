package com.zbx.hcums.system.entity.vo;

import com.zbx.hcums.system.entity.po.PermissionPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/21
 * @describe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionVo extends PermissionPo {

    List<PermissionVo> subList;

}
