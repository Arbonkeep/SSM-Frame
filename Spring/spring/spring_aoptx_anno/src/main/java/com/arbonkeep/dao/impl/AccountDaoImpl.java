package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.arbonkeep.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/30 - 15:09
 * 持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",
                    new BeanListHandler<Account>(Account.class));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findById(Integer accountId) {
        try {

            return runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where id = ?",
                    new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "insert into account (name, money) values(?,?)",
                    account.getName(),account.getMoney());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name=?,money=? where id = ?",
                    account.getName(), account.getMoney(),account.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "delete from account where id = ?", accountId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts= runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name =?",
                        new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一，数据出错");
            }
            return accounts.get(0);//返回唯一的结果
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
