package com.arbonkeep.factory;

import com.arbonkeep.service.AccountService;
import com.arbonkeep.service.impl.AccountServiceImpl;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 14:42
 */
public class StaticFactory {
    //获取AccountService对象的方法
    public static AccountService getAccountService() {
        System.out.println("使用工厂中的静态方法获取对象");
        return new AccountServiceImpl();
    }
}
