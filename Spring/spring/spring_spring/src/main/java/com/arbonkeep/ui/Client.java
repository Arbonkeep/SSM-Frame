package com.arbonkeep.ui;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.dao.impl.AccountDaoImpl;
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
     *
     * ApplicationContext的三个实现类
     * ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话就不能加载
     * FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须要有访问权限）
     *
     * AnnotationConfigApplicationContext：用于读取注解创建容器
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        //1.1使用ClassPathXmlApplicationContext
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //1.2使用 FileSystemXmlApplicationContext
        //ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\asus\\Desktop\\bean.xml");
        //2.根据id获取bean对象（下面使用了两种获取方式）
        //AccountService accountService = (AccountService) ac.getBean("AccountService");
        //AccountDao adao = ac.getBean("AccountDao", AccountDao.class);

        //System.out.println(accountService);
        //System.out.println(adao);

        //AccountService as = new AccountServiceImpl();
        //as.saveAccount();


        //---------------演示BeanFactory中配置文件对象的加载时机---------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        //下面使用了才会进行加载(延迟加载)
        AccountDao dao = (AccountDaoImpl)factory.getBean("AccountDao");
        System.out.println(dao);
    }

}
