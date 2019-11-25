package com.arbonkeep.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 20:07
 * 和spring链接数据库相关的内容
 */
//@Configuration    //如果没有声明为配置类，那么可以在主配置类中使用import注解设置为子配置类
public class JdbcConfiguration {
    @Value("${jdbc.driver}")//使用value注解注入数据
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个queryrunner
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype")
    //这里我们设置了两个数据源对象，所以不能匹配成功，那么可以通过指定id的方式来设置。
    //同样，我们也可以在方法声明上使用qualifier注解完成
    public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource) {
        QueryRunner runner = new QueryRunner(dataSource);
        return runner;
    }

    /**
     * 创建数据源对象
     * @return
     */
    //需求：将jdbc的信息配置提取出来为一个配置文件
    @Bean(name="ds2")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 创建第二个数据源对象
     * @return
     */
    @Bean("ds1")
    public DataSource createDataSource2() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring2");
            ds.setUser(username);
            ds.setPassword(password);
            return  ds;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


}
