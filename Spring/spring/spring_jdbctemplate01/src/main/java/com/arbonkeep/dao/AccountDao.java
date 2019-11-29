package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 15:38
 * account的持久层接口
 */
public interface AccountDao {
    /**
     * 通过id查询
     * @param accountId
     * @return
     */
    Account findById(int accountId);

    /**
     * 通过name查询账户
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

}


