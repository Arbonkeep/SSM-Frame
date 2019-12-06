package com.arbonkeep.test;

import com.arbonkeep.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 11:02
 */
public class TestSpring {

    /**
     * 测试spring
     */
    @Test
    public void run1() {
        //加载spring的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService bean = context.getBean("accountService", AccountService.class);
        //调用方法
        bean.findAll();

    }
}
