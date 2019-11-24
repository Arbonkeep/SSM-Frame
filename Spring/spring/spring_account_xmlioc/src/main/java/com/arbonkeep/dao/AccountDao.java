package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 15:03
 * 持久层接口
 */
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 查询一个
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 保存数据
     */
    void saveAccount(Account account);

    /**
     * 更新数据
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除数据
     * @param accountId
     */
    void deleteAccount(Integer accountId);

}
