package com.arbonkeep.service;

import com.arbonkeep.domain.Account;

/**
 * @author arbonkeep
 * @date 2019/12/1 - 15:47
 * account的业务层接口
 */
public interface AccountService {
    /**
     * 使用id查询账户
     * @param accountId
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 金额
     */
    void transfer(String sourceName, String targetName, float money);

}
