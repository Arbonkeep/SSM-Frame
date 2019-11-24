package com.arbonkeep.test;
import com.arbonkeep.config.configuration;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 16:57
 */
public class AccountTest {
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //1.获取spring的核心容器对象(需要使用注解获取)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);
        //2.获取bean对象
        AccountService as = (AccountService) context.getBean("accountService");
        //3.执行方法
        List<Account> accounts = as.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    public void testFindById() {
        //1.获取spring的核心容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);
        //2.获取bean对象
        AccountService as = (AccountService) context.getBean("accountService", AccountService.class);
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

        //1.获取核心容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);
        //2.获取bean对象
        AccountService as = context.getBean("accountService", AccountService.class);
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
        //1.获取核心容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);
        //2.获取bean对象
        AccountService as = context.getBean("accountService", AccountService.class);
        //3.执行方法
        as.updateAccount(account);

    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        //1.获取核心对象
        ApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);

        //2.获取bean对象
        AccountService as = context.getBean("accountService", AccountService.class);
        //3.执行方法
        as.deleteAccount(4);
    }


}
