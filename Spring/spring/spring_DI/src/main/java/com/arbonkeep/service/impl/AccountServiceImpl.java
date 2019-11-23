package com.arbonkeep.service.impl;

import com.arbonkeep.service.AccountService;

import javax.naming.BinaryRefAddr;
import java.util.Date;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 15:46
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    /**
     * 定义构造方法，用于依赖注入
     * @param name
     * @param age
     * @param birthday
     */
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;

    }

    /**
     * 执行保存的业务逻辑
     */
    @Override
    public void saveAccount() {
        System.out.println("Service中的saveAccount执行了。。。");
    }

}
