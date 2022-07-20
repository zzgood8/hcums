package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.form.UserGetForm;
import com.zbx.hcums.system.entity.form.UserPostForm;
import com.zbx.hcums.system.entity.po.UserPo;
import com.zbx.hcums.system.entity.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【A_user(用户信息表)】的数据库操作Mapper
* @createDate 2022-07-18 10:11:36
* @Entity com.zbx.hcums.system.entity.po.UserPo
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    UserPo selectByUsername(String username);

    List<UserVo> selectByParams(UserGetForm params);

}
