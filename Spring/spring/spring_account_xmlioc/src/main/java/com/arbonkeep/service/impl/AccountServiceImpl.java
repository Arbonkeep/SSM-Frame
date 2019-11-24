package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 15:08
 * 业务层实现类
 */
public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    //生成set方法用于spring的数据注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
