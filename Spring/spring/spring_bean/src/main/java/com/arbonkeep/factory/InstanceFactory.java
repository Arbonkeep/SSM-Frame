package com.arbonkeep.factory;

import com.arbonkeep.service.AccountService;
import com.arbonkeep.service.impl.AccountServiceImpl;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 14:31
 * 模拟一个工厂类(该类可能存在jar包，我们无法通过修改源码的方式来提供构造函数)
 */
public class InstanceFactory {

    //提供获取AccountService对象的方法
    public AccountService getAccountService() {
        AccountService service = new AccountServiceImpl();
        System.out.println("通过类中的方法获取对象");
        return  service;
    }
}
