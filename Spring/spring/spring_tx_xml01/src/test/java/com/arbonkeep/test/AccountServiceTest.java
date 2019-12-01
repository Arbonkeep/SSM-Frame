package com.arbonkeep.test;

import com.arbonkeep.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author arbonkeep
 * @date 2019/12/1 - 14:03
 */

@RunWith(SpringJUnit4ClassRunner.class)//使用spring的测试类
@ContextConfiguration(locations = "classpath:bean.xml")//指定配置文件
public class AccountServiceTest {

    @Autowired//自动按照类型注入
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa","bbb", 100f);
    }
}
