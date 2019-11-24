package com.arbonkeep.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 20:07
 * 和spring链接数据库相关的内容
 */
//@Configuration    //如果没有声明为配置类，那么可以在主配置类中使用import注解设置为子配置类
public class JdbcConfiguration {

    /**
     * 用于创建一个queryrunner
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        QueryRunner runner = new QueryRunner(dataSource);
        return runner;
    }

    /**
     * 创建数据源对象
     * @return
     */

    @Bean(name="dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
            ds.setUser("root");
            ds.setPassword("root");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
