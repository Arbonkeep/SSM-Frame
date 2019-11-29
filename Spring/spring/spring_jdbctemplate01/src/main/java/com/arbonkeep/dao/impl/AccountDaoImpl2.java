package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import com.arbonkeep.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 15:41
 * 使用自定义的
 */
public class AccountDaoImpl2 implements AccountDao {
    //声明一个JdbcTemplate
    private JdbcTemplate template;

    //通过set方法注入
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * 通过id查询账户
     * @param accountId
     * @return
     */
    @Override
    public Account findById(int accountId) {
        List<Account> list = template.query("select * from account where id = ?",
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
        List<Account> list = template.query("select * from account where name = ?",
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
        template.update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
