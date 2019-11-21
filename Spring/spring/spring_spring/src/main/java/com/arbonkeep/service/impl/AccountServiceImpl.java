package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.dao.impl.AccountDaoImpl;
import com.arbonkeep.service.AccountService;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:03
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao =  new AccountDaoImpl();//这里使用了new关键字增加了耦合


    /**
     * 执行保存的业务逻辑
     */
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
