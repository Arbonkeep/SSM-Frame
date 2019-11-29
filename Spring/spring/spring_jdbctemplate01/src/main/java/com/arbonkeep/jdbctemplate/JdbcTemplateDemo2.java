package com.arbonkeep.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 14:12
 * 使用配置的方式完成
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取核心容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取bean对象
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行方法
        template.execute("INSERT INTO account (name, money) VALUES ('eee', 4561.5)");
    }
}
