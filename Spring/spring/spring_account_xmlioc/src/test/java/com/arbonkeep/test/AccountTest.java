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
 * @date 2019/11/24 - 16:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
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
     * 测试查询一个
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
