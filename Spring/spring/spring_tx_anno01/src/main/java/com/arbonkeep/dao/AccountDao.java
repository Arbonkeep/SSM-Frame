package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;

/**
 * @author arbonkeep
 * @date 2019/12/1 - 15:45
 * 账户的持久层接口
 */
public interface AccountDao {
    /**
     * 通过name查询账户
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 通过id查询账户
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
