package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 16:08
 * 业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{
    //使用注解注入数据
    @Autowired
    private AccountDao accountDao;

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
