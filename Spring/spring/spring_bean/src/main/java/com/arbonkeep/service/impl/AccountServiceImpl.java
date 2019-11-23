package com.arbonkeep.service.impl;

import com.arbonkeep.service.AccountService;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 14:03
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //提供个构造函数之后，就不再有默认构造函数
    public AccountServiceImpl(String str) {
        System.out.println("构造函数字符串");

    }

    //提供默认构造函数
    public AccountServiceImpl() {
        System.out.println("对象创建。。。");
    }

    /**
     * 执行保存的业务逻辑
     */
    @Override
    public void saveAccount() {
        System.out.println("Service中的saveAccount执行了。。。");
    }

    public void init() {
        System.out.println("对象被创建了");
    }

    public void destroy() {
        System.out.println("对象消亡了");
    }
}
