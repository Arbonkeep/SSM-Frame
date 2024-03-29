package com.arbonkeep.dao;

import com.arbonkeep.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 19:02
 */
public interface AccountDao {
    /**
     * 查询所有账户并获取对应的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap", value = {
            @Result(id = true,column="id", property = "id"),
            @Result(column="uid", property = "uid"),
            @Result(column="money", property = "money"),
            @Result(property = "user",column = "uid",one=@One(select = "com.arbonkeep.dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })

    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);

}
