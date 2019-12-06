package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 10:37
 * 业务层的实现类
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有。。。");
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层保存账户。。。");
        accountDao.saveAccount(account);

    }
}
