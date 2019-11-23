package com.arbonkeep.ui;


import com.arbonkeep.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author arbonkeep
 * @date 2019/11/23 - 14:06
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//不能调用close方法
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        //AccountService service1 = (AccountService)ac.getBean("AccountService");
        //AccountService service2 = (AccountService)ac.getBean("AccountService");
        //AccountService service3 = (AccountService)ac.getBean("AccountService2");
        AccountService service4 = (AccountService)ac.getBean("AccountService3");

        //System.out.println(service1 == service2);
        //取决于bean的作用范围，如果是单例的就为true，如果为多例的就是false

        //service1.saveAccount();
        //service3.saveAccount();
        service4.saveAccount();

        //由于main方法结束也就是容器会被释放，所以需要手动调用destory方法才能看到消亡
        ac.close();
    }

}
