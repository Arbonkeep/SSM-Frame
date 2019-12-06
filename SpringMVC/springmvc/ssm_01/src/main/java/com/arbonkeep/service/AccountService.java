package com.arbonkeep.service;

import com.arbonkeep.domain.Account;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 10:35
 * Account的业务层
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    public void saveAccount(Account account);
}
