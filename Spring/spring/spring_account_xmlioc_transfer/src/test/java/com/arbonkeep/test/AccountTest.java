package com.arbonkeep.test;

import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/26 13:16
 */
@RunWith(SpringJUnit4ClassRunner.class)//将测试类替换成spring中的test
@ContextConfiguration(locations = "classpath:bean.xml")//指定配置文件的位置
public class AccountTest {
    @Autowired
    private AccountService as = null;

    @Test
    public void testTransfer() {
        //调用方法，完成转账
        as.transfer("bbb", "aaa", 100f);
    }


}
