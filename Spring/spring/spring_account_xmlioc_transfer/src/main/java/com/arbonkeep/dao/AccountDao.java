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

    /**
     * 根据name查询账户
     * @param accountName
     * @return Account 如果有唯一的账户就返回，如果没有就返回null，如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
