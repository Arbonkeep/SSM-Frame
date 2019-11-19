package com.arbonkeep.dao;

import com.arbonkeep.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.Test;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 16:26
 * mybatis中提供给了4种注解开发即：Select，Update，Delete，Insert
 */

@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有
     * @return
     *
     */
    @Select("select * from user")//配置注解
    @Results(id = "userMap",value = {//设置id可让其他方法使用
            @Result(id=true,column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),

            @Result(property = "accounts",column = "id",many =
                    @Many(select = "com.arbonkeep.dao.AccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY))
            //后面id不需要写了
    })
    List<User> findAll();


    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap(value={"userMap"})//如果只有一个属性value可以省略，只有一个参数大括号也可以省略
    User findById(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap(value={"userMap"})
    //@Select("select * from user where username like "%${value}%")//这种方式不需要%
    List<User> SelectByName(String name);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*)from user")
    int findTotal();
}
