package com.arbonkeep.ui;


import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.service.AccountService;
import com.arbonkeep.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取bean对象
        AccountServiceImpl as1 = (AccountServiceImpl) context.getBean("accountService");
        System.out.println(as1);

        as1.saveAccount();
        context.close();//手动调用销毁方法
//        AccountService as2 = (AccountService) context.getBean("accountService");
//        System.out.println(as2);
//        System.out.println(as1 ==as2);//指定了作用范围为多例，所以为false

        //获取bean.dao对象
//        AccountDao dao = (AccountDao)context.getBean("accountDao",AccountDao.class);
//       System.out.println(dao);





    }
}
