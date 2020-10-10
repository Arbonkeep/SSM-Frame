# SSM整合

## web.xml配置文件

``` xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!--配置中文乱码过滤器-->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

        <!--指定编码-->
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <!--forceEncoding,默认为false，表示当请求已经设置过编码格式，则不再设置，如果设置为true，则表示一定会设置编码-->
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--设置restul中的delete和put请求的过滤器-->
    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!--配置前端控制器-->
    <servlet>
        <servlet-name>springMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--设置springMVC配置文件的文件名与路径-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springMVC.xml</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>springMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!--指定spring配置文件的位置以及文件名-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>

    <!--配置spring的监听器，在项目启动时，自动加载spring的配置文件-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

</web-app>
```

## springMVC配置文件

```xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <!--springMVC的配置文件，需要扫描到cntroller-->
    
    <!--配置需要扫描的包-->
    <context:component-scan base-package="com.arbonkeep.ssm.controller"></context:component-scan>
    
    <!--配置视图解析器-->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!--配置前缀-->
        <property name="prefix" value="/WEB-INF/view/"></property>
        <!--配置后缀-->
        <property name="suffix" value=".jsp"></property>
    </bean>
    
    <!--配置默认的servlet-->
    <mvc:default-servlet-handler></mvc:default-servlet-handler>
    
    <!--配置注解驱动-->
    <mvc:annotation-driven></mvc:annotation-driven>
    
    <!--配置拦截器-->
    <!--
                表示拦截器为FirstInterceptor，拦截所有，除了/up路径
    <mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/*"/>
            <mvc:exclude-mapping path="/up"></mvc:exclude-mapping>
            <ref bean="FirstInterceptor"></ref>
        </mvc:interceptor>
    </mvc:interceptors>
    -->

    <!--配置视图控制器-->
    <!--对于不需要进行其他操作的页面（只需要返回一个页面），直接使用该注解进行请求转发-->
    <mvc:view-controller path="/success" view-name="success"></mvc:view-controller>


</beans>

```

## spring的配置文件

```xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/cache http://www.springframework.org/schema/cache/spring-cache.xsd">

    <!--配置需要扫描的包,扫描控制层之外的组件-->
    <context:component-scan base-package="com.arbonkeep.ssm">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:exclude-filter>
    </context:component-scan>

    <!--读取jdbc.properties，注意需要加上classpath:-->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>

    <!--配置数据源对象-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>

    <!--配置Mybatis操作数据库的对象sqlSession-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--配置数据源-->
        <property name="dataSource" ref="dataSource"></property>
        <!--配置mybatis的核心配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <!--配置mybatis的映射配置文件(注意使用/分割，location)-->
        <property name="mapperLocations" value="classpath:com/arbonkeep/ssm/dao/*.xml"></property>
        <!--配置起别名-->
        <property name="typeAliases" value="com.arbonkeep.ssm.bean"></property>
    </bean>

    <!--将通过sqlSession所获取的mapper接口的代理实现类自动扫描，作为spring的组件进行管理-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.arbonkeep.ssm.bean"></property>
    </bean>

    <!--配置事务管理器对象-->
    <bean name="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--指定数据源-->
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置事务-->
    <tx:advice id="tx" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="add*"/>
            <tx:method name="update*"/>
            <tx:method name="delete*"/>
            <tx:method name="select*" read-only="true"/>
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>

    <!--使用AOP将事务通知通过切入点作用于连接点-->
    <aop:config>
        <aop:advisor advice-ref="tx" pointcut="execution(* com.arbonkeep.ssm.service.impl.*(..))"></aop:advisor>
    </aop:config>


</beans>

```