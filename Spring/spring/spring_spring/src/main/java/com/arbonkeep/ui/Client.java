package com.arbonkeep.ui;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.service.AccountService;
import com.arbonkeep.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:10
 * 模拟表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取Spring的IOC核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService accountService = (AccountService) ac.getBean("AccountService");
        AccountDao adao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(accountService);
        System.out.println(adao);

        AccountService as = new AccountServiceImpl();
        as.saveAccount();

    }

}
