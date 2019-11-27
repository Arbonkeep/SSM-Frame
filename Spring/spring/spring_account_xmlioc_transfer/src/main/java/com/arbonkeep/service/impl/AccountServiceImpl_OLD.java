package com.arbonkeep.service.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import com.arbonkeep.utils.TransactionManager;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 13:18
 * 业务层实现类
 */
public class AccountServiceImpl_OLD implements AccountService{
    private AccountDao accountDao;

    private TransactionManager txManager;


    //生成set方法用于spring的数据注入
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public List<Account> findAll() {
        try {
            //1.开启事务
            txManager.openTransaction();
            //2.执行方法
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        }catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }


    }

    @Override
    public Account findById(Integer accountId) {
        try {
            //1.开启事务
            txManager.openTransaction();
            //2.执行方法
            Account account = accountDao.findById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            txManager.release();

        }

    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.openTransaction();
            //2.执行方法
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放资源
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.openTransaction();
            //2.执行方法
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();

        } catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //5.释放资源
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            txManager.openTransaction();
            accountDao.deleteAccount(accountId);
            txManager.commit();
        }catch (Exception e) {
            txManager.rollback();
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        try {
            //1.开启事务
            txManager.openTransaction();
            //2.执行方法（转账操作）
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
            int i = 1 / 0;//当出现异常后，我们运行测试类，会导致数据不匹配的问题。
                          // 也就是转出账户少钱，但是目标账户没有多钱(我们使用一个事务统一管理)
            //2.6更新转出账户
            accountDao.updateAccount(target);

            //3.提交事务
            txManager.commit();
        }catch (Exception e) {
            //4.回滚事务
            txManager.rollback();
        }finally {
            //5.释放连接
            txManager.release();
        }
    }
}
