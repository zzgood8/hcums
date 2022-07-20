package com.zbx.hcums.system.entity.vo;

import com.zbx.hcums.system.entity.po.UserPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends UserPo {

    private List<String> roles;

}
