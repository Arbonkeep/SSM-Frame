package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;//使用spring提供的

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 15:41
 * 使用Spring提供的JdbcDaoSupport
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    //需要继承JdbcDaoSupport类才能获取到JdbcTempalate

    /**
     * 通过id查询账户
     * @param accountId
     * @return
     */
    @Override
    public Account findById(int accountId) {
        List<Account> list = super.getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list == null ? null : list.get(0);
    }

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
     * 更新账户
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
