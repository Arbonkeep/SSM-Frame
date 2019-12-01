package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/1 - 13:31
 * 账户的持久层类
 * 使用spring提供的JdbcDaoSupport
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    /**
     * 通过name查询账户
     * @param accountName
     * @return
     */
    @Override
    public Account findByName(String accountName) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), accountName);

        if (list == null) {
            return null;
        }
        if (list.size() > 1) {
            throw new RuntimeException("查询结果出错");
        }

        return list.get(0);
    }

    /**
     * 通过id查询账户
     * @param accountId
     * @return
     */
    @Override
    public Account findById(Integer accountId) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list == null ? null : list.get(0);
    }

    /**
     * 更新账户
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
