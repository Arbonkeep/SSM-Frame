package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;
import com.arbonkeep.domain.AccountUser;

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
     * 查询所有，并且包含用户名和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
