package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author arbonkeep
 * @date 2019/12/1 - 18:01
 *
 * 使用编程的方式完成事务的控制
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    //声明模板对象
    private TransactionTemplate transactionTemplate;

    //需要注入
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    //使用set方法完成注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 使用id查询账户
     * @param accountId
     * @return
     */
    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    /**
     * 转账操作
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 金额
     */
    @Override
    public void transfer(final String sourceName, final String targetName, final float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                System.out.println("transfer。。。");

                //1.根据名称查询转出账户
                Account source = accountDao.findByName(sourceName);
                //2.根据名称查询转入账户
                Account target = accountDao.findByName(targetName);
                //3.转出账户减钱
                source.setMoney(source.getMoney() - money);
                //4.转入账户加钱
                target.setMoney(target.getMoney() + money);
                //5.更新转出账户
                accountDao.updateAccount(source);

                //手动制造异常
//        int i = 1/0;

                //6.更新转入账户
                accountDao.updateAccount(target);
                return null;

            }
        });


    }
}
