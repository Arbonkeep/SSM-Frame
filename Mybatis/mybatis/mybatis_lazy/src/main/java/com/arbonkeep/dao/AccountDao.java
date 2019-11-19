package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/17 - 16:19
 */
public interface AccountDao {
    /**
     * 查询所有账户,(同时，还需要获取到当前账户的所属用户信息)
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param id
     * @return
     */
    List<Account> findAccountByUid(Integer id);


}
