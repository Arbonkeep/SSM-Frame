package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 10:31
 * 账户持久层接口
 * 使用mybatis不需要实现类，可以使用代理对象
 */
@Repository
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    @Insert("insert into account (name, money) values(#{name},#{money})")
    public void saveAccount(Account account);
}
