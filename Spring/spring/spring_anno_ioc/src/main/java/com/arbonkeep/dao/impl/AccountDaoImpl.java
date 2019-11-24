package com.arbonkeep.dao.impl;

import com.arbonkeep.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 13:07
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {

        System.out.println("保存了数据");
    }
}
