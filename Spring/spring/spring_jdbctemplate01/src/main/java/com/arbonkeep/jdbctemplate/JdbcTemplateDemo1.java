package com.arbonkeep.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 13:46
 * 直接使用new对象的方式使用
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.获取数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //2.设置相关信息
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("root");
        //3.获取jdbcTemp-late对象
        JdbcTemplate template = new JdbcTemplate(ds);//使用构造方法将数据源传入
        //为template设置数据源
        //template.setDataSource(ds);
        //4.调用执行语句
        template.execute("insert into account (name, money) values('ddd',1235.6)");

    }
}
