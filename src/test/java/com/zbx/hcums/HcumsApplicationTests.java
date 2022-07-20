package com.zbx.hcums;

import com.zbx.hcums.system.dao.UserMapper;
import com.zbx.hcums.system.entity.po.UserPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HcumsApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        UserPo userPo = userMapper.selectByPrimaryKey(1L);
        System.out.println(userPo);
    }

}
