package com.arbonkeep.service.impl;

import com.arbonkeep.service.AccountService;

import java.util.Date;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 15:46
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    //提供对应的set方法，用于set依赖注入

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
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
