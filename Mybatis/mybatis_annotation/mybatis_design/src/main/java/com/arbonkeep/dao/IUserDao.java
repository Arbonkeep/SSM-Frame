package com.arbonkeep.dao;

import com.arbonkeep.domain.User;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 13:33
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有的接口
     */
    List<User> findAll();

}
