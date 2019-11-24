package com.arbonkeep.service.impl;


import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:03
 * 账户的业务层实现类
 * 之前配置
 * <bean id="AccountService" class="com.arbonkeep.service.impl.AccountServiceImpl"
 *  scope="" init-methid="" destroy-method="">
 *      <property name="" value=""|ref=""></property>
 * </bean>
 *
 * <1> 用于创建对象的
 *     作用相当于在xml配置文件中编写一个<bean>标签实现的功能类似
 *       1) component注解：
 *           作用：用于把当前类对象存入spring容器中
 *           属性：
 *                value：用于指定bean的id。当我们不写时，它的默认值就是当前类名，首字母小写
 *       2) Controller:一般用于表项层
 *       3) Service：一般用于业务层
 *       4) Respository:一般用于持久层
 *          * 以上三个注解的作用和属性都与conponent一样。它们三个是spring框架为我们提供明确的三层使用的注解，
 *            使我们的三层对象更加清晰
 *
 * <2> 用于注入数据的
 *     作用相当于在xml配置文件中的bean标签中写一个<property>标签的作用类似
 *        1) Autowired
 *              作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                   如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则会报错
 *                   如果iioc容器中有多个类型匹配时：首先会按照类型圈定出能够匹配的范围，然后通过变量的名称在范
 *                   围内进行匹配，我们可以通过修改id的方式完成匹配
 *
 *              出现位置：可以在变量上也可以在方法上
 *
 *              细节：在使用注解注入时，set方法就不是必要的了
 *
 * <3> 用于改变作用范围的
 *     作用相当于在bean标签中使用scope属性实现的功能类似
 * <4> 与生命周期相关的
 *     作用相当于在bean标签中使用init-method和destroy-method的作用类似
 *
 */

@Component(value="accountService")
//@Scope(value = "prototype")
public class AccountServiceImpl implements AccountService {
    @Autowired//使用注解注入数据
    private AccountDao accountDao1 = null;//在没有注入数据之前会报出空指针异常

    /**
     * 执行保存的业务逻辑
     */
    public AccountServiceImpl() {
        System.out.println("对象创建。。。");
    }

    @PostConstruct//指定初始化方法
    public void init() {
        System.out.println("初始化。。。");
    }

    @PreDestroy//指定销毁方法
    public void destory() {
        System.out.println("销毁。。。");
    }

    @Override
    public void saveAccount() {

    }
}
