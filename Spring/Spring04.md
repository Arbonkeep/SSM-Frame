# Spring

## JDBC Template
    1. JdbcTemplate的作用：
		* 它就是用于和数据库交互的，实现对表的CRUD操作

    2. 实现CRUD操作的方式(请参考spring_jdbctemplate01)
        * 注意
            <1> 查询所有中一般使用query方法中的两个具体的有相关参数的方法
                
<img src="./img/img20.png" width = 800px>

            <2> 其中RowMapper参数一般会使用Spring提供的BeanPropertyRowMapper，当然也可以自己去完成Account对结果集
                的封装
                
            <3> 增删改都可以使用update方法完成

    3. JdbcTemplate在DAO持久层的使用(请参考spring_jdbctemplate01下的dao层)

    4. 如果有多个dao的实现类，如何将实现类中共同的代码提取出来？
        <1> JdbcDaoSupport的使用
            1) 自定义一个JdbcDaoSupport类，将公共代码放在该类中，同时可以添加一个创建JdbcTemplate的方法。

            2) 不需要自定JdbcDaoSupport，可以直接使用spring提供的。不利于注解注入数据

        <2> dao实现类的两种编写方式
            1) 继承JdbcDaoSupport使用spring提供的

            2) 自己定义jdbcTemplate，有利于注解开发

    
