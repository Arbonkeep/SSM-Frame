package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:07
 */
public class AccountDaoImpl implements AccountDao {
    //声明构造方法用于测试在使用ApplicationContext时是否是即时加载的
    public AccountDaoImpl() {
        System.out.println("对象加载。。。");
    }

    @Override
    public void saveAccount() {
        System.out.println("保存了数据");
    }
}
