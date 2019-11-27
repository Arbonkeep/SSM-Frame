package com.arbonkeep.test;

import com.arbonkeep.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author arbonkeep
 * @date 2019/11/27 - 16:56
 */
public class Test4AOP {
    public static void main(String[] args) {
        //获取springioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //调用方法获取bean对象
        AccountService as = context.getBean("accountService", AccountService.class);
        //调用方法执行保存
        as.saveAccount();
    }
}
