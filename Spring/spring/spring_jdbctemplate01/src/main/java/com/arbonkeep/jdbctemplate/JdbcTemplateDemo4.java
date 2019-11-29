package com.arbonkeep.jdbctemplate;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 15:53
 * 模拟业务层完成对持久层方法的调用
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取bean对象
        AccountDao dao = context.getBean("accountDao", AccountDao.class);
        //3.调用方法执行
//        Account account = dao.findById(6);
//        System.out.println(account);
//
//        Account name = dao.findByName("fff");
//        System.out.println(name);

        Account account1 = new Account();
        account1.setName("va");
        account1.setMoney(47f);
        account1.setId(6);
        dao.updateAccount(account1);
    }
}
