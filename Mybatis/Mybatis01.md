# Mybatis

## SSM框架与三层架构之间的关系
    1. 框架的概念
        * 它是我们软件开发中的一套解决方案，不同的框架解决的是不同的问题。
	
    2. 使用框架的好处：
		* 框架封装了实现细节，使开发者可以使用极简的方式实现功能。大大提高开发效率。

    3. 三层架构
        表现层：是用于展示数据的

        业务层：是处理业务需求

        持久层：是和数据库交互的

    4. SSM框架与三层架构之间的关系如下所示

<img src="./img/img01.png" width=800>

## Mybatis概述
    1. mybatis是一个持久层框架，用java编写的。它封装了jdbc操作的很多细节，使开发者只需要关注sql语句本身，而无需关注
       注册驱动，创建连接等繁杂过程。它使用了ORM思想实现了结果集的封装。

    2. ORM的简介
        * ORM(Object Relational Mapping): 对象映射关系。简单的说：就是把数据库表和实体类及实体类的属性对应起来。让
                                          我们可以操作实体类就实现操作数据库表。

## Mybatis入门
    1. Mybatis的准备工作(环境搭建)
        <1> 创建相关maven工程,并导入相关的依赖
            1) mysql
                * 代码如下：
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>5.1.6</version>
                    </dependency>

            2) log4j
                * 代码如下：
                    <dependency>
                        <groupId>log4j</groupId>
                        <artifactId>log4j</artifactId>
                        <version>1.2.12</version>
                    </dependency>

            3) mybatis
                * 代码如下：
                    <dependency>
                        <groupId>org.mybatis</groupId>
                        <artifactId>mybatis</artifactId>
                        <version>3.4.5</version>
                    </dependency>

            4) junit
                * 代码如下：
                    <dependency>
                        <groupId>junit</groupId>
                        <artifactId>junit</artifactId>
                        <version>4.10</version>
                    </dependency>

        <2> 创建数据库的相关数据(请参考mybatis.sql)

        <3> 创建实体类和dao接口

        <4> 创建Mybatis的主配置文件:SqlMapConifg.xml
            * xml文件需要引用相关约束

<img src="./img/img02.png" width =800px>

        <5> 创建映射配置文件:IUserDao.xml
            * xml文件需要引用相关约束

<img src="./img/img03.png" width =800px>

    2. 环境搭建的注意事项
        <1> mybatis的映射配置文件位置必须和dao接口的包结构相同(参考IUserDao.java与IUserDao.xml的文件目录)

<img src="./img/img04.png" width =800px>

        <2> 映射配置文件的mapper标签namespace属性的取值必须是dao接口的全限定类名

<img src="./img/img05.png" width =800px>

        <3> 映射配置文件的操作配置（select），id属性的取值必须是dao接口的方法名

<img src="./img/img06.png" width =800px>

        <4> 创建IUserDao.xml 和 IUserDao.java时名称是为了保持一致。在Mybatis中它把持久层的操作接口名称和映
            射文件也叫做：Mapper。所以：IUserDao 和 IUserMapper是一样的

        <5> 当我们遵从了第一、二、三点之后，我们在开发中就无须再写dao的实现类。

    3. 入门案例(参考Test)
        <1> 案例：
            第一步：读取配置文件
            第二步：创建SqlSessionFactory工厂
            第三步：创建SqlSession
            第四步：创建Dao接口的代理对象
            第五步：执行dao中的方法
            第六步：释放资源

        <2> 使用xml配置文件的方式实现(参考mybatis)
            1) 注意事项：
                * 不要忘记在映射配置中告知mybatis要封装到哪个实体类中。配置的方式：指定实体类的全限定类名。            
                  即在接收返回结果是需要IUserDao.xml中的查询语句中指定resultType。用于指定接收查询结果的类。

        <3> 使用注解的方式实现(参考mybatis_annotation)
            1) 注意事项：
                [1] 把IUserDao.xml移除，直接在接口中使用注解@Select并且指定SQL语句

<img src="./img/img07.png" width =800px>

                [2] 在mybatis的主配置文件中指定映射配置文件时，需要使用class属性指定被注解的dao的全限定类名

        <3> 使用实现类的方式实现(参考mybatis_dao)

    4. 入门案例分析

<img src="./img/img08.png" width =800px>

    5. 自定义Mybatis(参考Mybatis_design)


    



