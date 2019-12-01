package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import com.arbonkeep.utils.TransactionManager;
import org.junit.rules.TestRule;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 13:18
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
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    @Override
    public Account findById(Integer accountId) {
        Account account = accountDao.findById(accountId);
        return account;

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

    @Override
    public void transfer(String sourceName, String targetName, float money) {

        System.out.println("transfer执行。。。");
        //2.1根据名称查询转出账户]
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减少钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户增加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转入账户
        accountDao.updateAccount(source);
        //int i = 1 / 0;//当出现异常后，我们运行测试类，会导致数据不匹配的问题。
                      // 也就是转出账户少钱，但是目标账户没有多钱(我们使用一个事务统一管理)
        //2.6更新转出账户
        accountDao.updateAccount(target);

    }
}
