package com.arbonkeep.jdbctemplate;

import com.arbonkeep.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/29 - 14:37
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取bean对象
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行方法

        //保存
//        template.update("insert into account (name, money) values(?,?)","fff",6585.6f);

        //更新
//        template.update("update account set name=?,money=? where id = ?","dxdx",0000.0f,7);

        //删除
//        template.update("delete from account where id = ?",8);

        //查询所有
//        方式一：使用自定义的rowmapper
//        List list = template.query("select * from account where money > ?",
//                  new AccountRowMapper(), 3000f);

//        方式二：使用spring提供的RowMappper实现类BeanPropertyRowMapper
//        List<Account> list = template.query("select * from account where money > ?",
//                new BeanPropertyRowMapper<Account>(Account.class), 3000);
//        //遍历
//        for (Object o : list) {
//            System.out.println(o);
//        }

        //查询一个(我们可以使用查询所有的方式，只获取一个即可)
        List<Account> list = template.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 9);


        System.out.println(list == null ? null : list.get(0));

    }
}

/**
 * 声明一个rowapper的实现类,account的封装策略
 */
class AccountRowMapper implements RowMapper {

    /**
     * 将结果集中的数据封装到Account中，然后由spring将每一个account添加到集合中
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override//最好返回account
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        //获取一个account对象
        Account account = new Account();
        account.setMoney(rs.getFloat("money"));//将结果集合中的money封装到Account中
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));

        return account;
    }
}