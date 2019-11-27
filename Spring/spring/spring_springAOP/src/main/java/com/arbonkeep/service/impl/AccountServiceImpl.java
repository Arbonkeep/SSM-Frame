package com.arbonkeep.service.impl;

import com.arbonkeep.service.AccountService;

/**
 * @author arbonkeep
 * @date 2019/11/27 - 15:39
 */
public class AccountServiceImpl implements AccountService{
    @Override
    public void saveAccount() {
        System.out.println("保存了账户。。。");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户。。。" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了账户。。。");
        return 0;
    }
}
