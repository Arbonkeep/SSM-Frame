package com.arbonkeep.dao;

import com.arbonkeep.domain.User;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 16:19
 */
public interface IUserDao {
    /**
     * 查询所有的方法
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 通过id查询用户信息
     *
     * @param id
     */
    public User selectById(Integer id);
}