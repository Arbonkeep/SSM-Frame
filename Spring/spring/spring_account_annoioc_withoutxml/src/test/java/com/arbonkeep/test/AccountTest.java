package com.arbonkeep.test;
import com.arbonkeep.config.configuration;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/25 - 14:45
 *
 * 本类所需要实现的需求
 * 在测试时，不再需要手写获取容器以及bean对象的代码，即使用spring整合junit
 */

@RunWith(SpringJUnit4ClassRunner.class)//将原有的main方法替换成spring提供的
@ContextConfiguration(classes = configuration.class)//指定注解类所在位置
public class AccountTest {
    @Autowired
    private AccountService as = null;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 测试通过id查询
     */
    @Test
    public void testFindById() {
        //3.执行方法
        Account account = as.findById(4);

        System.out.println(account);
    }

    /**
     * 测试保存数据
     */
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("july");
        account.setMoney(45465f);

        //3.执行方法
        as.saveAccount(account);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(3);
        account.setName("ccc");
        account.setMoney(1000f);
        //3.执行方法
        as.updateAccount(account);

    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(4);
    }


}
