package com.arbonkeep.dao;

import com.arbonkeep.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.Test;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 16:26
 * mybatis中提供给了4种注解开发即：Select，Update，Delete，Insert
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     *
     */
    @Select("select * from user")//配置注解
    List<User> findAll();

    /**
     * 插入数据
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username},address = #{address},sex = #{sex},birthday = #{birthday} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username}")
    //@Select("select * from user where username like "%${value}%")//这种方式不需要%
    List<User> SelectByName(String name);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*)from user")
    int findTotal();
}
