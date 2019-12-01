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

## AOP补充
    1. 使用xml配置Aop完成对事务的控制(参考spring_aoptx_xml)

    2. 使用注解的aop完成对事务的控制(参考spring_aoptx_anno)

    3. 关于在使用aop完成对事务控制中所遇到的问题
        <1> 当我们完成了基本的注解配置之后，运行test类发现会出现一个异常。即：
            can't call commit when autocommit = true

        <2> 产生这个问题的原因是什么呢？
            * 这是由于在执行程序时，会先执行最终通知然后再执行后置通知，那么也就是说，资源已经释放，即
              autocommit已经置为true了。

        <3> 产生上面问题的主要原因就是我们在实现spring中使用aop实现事务的控制时，我们使用4个通知注解类型，
            它们之间的执行顺序是存在问题的。那么，如果我们一定需要使用aop注解实现事务的控制的话，我们就应
            该使用环绕通知，因为环绕通知是自定义的，它不会存在执行顺序的问题
