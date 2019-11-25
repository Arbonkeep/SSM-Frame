package com.arbonkeep.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
<1> 如果需要使用完全注解的方式完成，那么首先需要定义一个configuration配置类

        <2> 在配置类中使用相关的注解进行配置
            1) Configuration注解
                * 作用：指定当前类是一个配置类

            2) ComponentScan注解
                * 作用：用于通过注解指定spring在创建容器时所需要的包

                * 属性：
                    value：它与basePackage的作用是一样的，都是用于指定创建容器时要扫描的包

                * 使用这个注解就相当于在xml配置中配置
                 <context:component-scan base-package="com.arbonkeep"></context:component-scan>

3) bean注解
                * 作用：用于把当前的返回值作为bean对象存入spring的ioc容器中

                * 属性：
                    name：用于指定bean的id。当不写时，默认id是当前方法的名称

                * 注意：
                    当我，们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
                    查找方式与Autowired注解是一样的

 */

/**
 * @author arbonkeep
 * @date 2019/11/24 - 17:22
 * 声明一个配置类，在里面完成配置QueryRunner，配置数据源
 */
//@Configuration//如果在使用spring框架时，使用注解导入了该类的字节码，就不再需要配置该注解
@ComponentScan(basePackages = {"com.arbonkeep"})//指定扫描的包
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")//使用注解指定jdbc的配置文件
public class configuration {


}
