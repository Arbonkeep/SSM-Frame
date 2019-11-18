package com.arbonkeep.dao;

import com.arbonkeep.domain.User;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/18 - 13:23
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User selectById(int id);
}
