package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:07
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了数据");
    }
}
