package com.arbonkeep.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 16:24
 * 方式一：自定义jdbcDaoSupport(这种方式有利于自己实现注解开发，使用注解注入数据)
 * 那么也就是说，我们在使用set方法时，即使没有传一个JdbcTemplate，传一个dataSource也是可以创建到JdbcTemplate
 */
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    //private DataSource dataSource;//不再需要声明了

    public void setDataSource(DataSource dataSource) {
        //this.dataSource = dataSource;//如果执行了下面逻辑就不再需要这里了
        if (jdbcTemplate == null) {//如果jdbcTemplate为null，那么就赋值
            jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
