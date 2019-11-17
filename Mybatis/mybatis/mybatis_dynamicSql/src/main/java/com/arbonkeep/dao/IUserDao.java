package com.arbonkeep.dao;

import com.arbonkeep.domain.QueryVo;
import com.arbonkeep.domain.User;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 16:19
 */
public interface IUserDao {
    /**
     * 查询所有的方法
     * @return
     */
    public List<User> findAll();

    /**
     * 通过id查询用户信息
     * @param id
     */
    public User selectById(Integer id);

    /**
     * 通过name对用户进行模糊查询
     * @param name
     */
    public List<User> selectByName(String name);

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    public List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入条件查询
     * @param user 查询条件：有可能有用户名，性别，地址，有可能什么也没有
     * @return
     */
    public List<User> findByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合查询用户信息
     * @param vo
     * @return
     */
    public List<User> findUserInIds(QueryVo vo);
}
