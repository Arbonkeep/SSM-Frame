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
     * 数据的保存
     */
    public void save(User user);

    /**
     * 更新数据用户
     * @param user
     */
    public void update(User user);

    /**`
     * 删除用户
     * @param id
     */
    public void delete(Integer id);

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
     * 查询总用户数
     * @return
     */
    public int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    public List<User> findUserByVo(QueryVo vo);
}
