package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 15:09
 * 持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;

    //声明set方法，利用spring来注入数据
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findById(Integer accountId) {
        try {

            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account (name, money) values(?,?)", account.getName(),account.getMoney());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,money=? where id = ?", account.getName(),account.getMoney(),account.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id = ?", accountId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
