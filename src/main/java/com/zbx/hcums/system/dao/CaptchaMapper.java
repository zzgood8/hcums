package com.zbx.hcums.system.dao;

import com.zbx.hcums.system.entity.po.CaptchaPo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【system_captcha(验证码表)】的数据库操作Mapper
* @createDate 2022-07-29 14:50:41
* @Entity com.zbx.hcums.system.entity.po.CaptchaPo
*/
@Mapper
public interface CaptchaMapper {

    CaptchaPo selectByKey(String key);

    void insert(CaptchaPo record);

    void deleteByKey(String key);

}
