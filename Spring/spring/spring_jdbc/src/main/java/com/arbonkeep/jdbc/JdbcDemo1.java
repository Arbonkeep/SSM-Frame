package com.arbonkeep.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 13:24
 * 程序的耦合：程序间的依赖关系
 *          包括：类之间的依赖与方法间的依赖
 *
 *      解耦：降低程序间的依赖
 *      实际开发中应该做到：编译期不依赖，运行时才依赖
 *      解耦的思路：
 *          1.使用反射来创建对象，而避免使用new关键字
 *          2.通过读取配置文件的方式来获取要创建对象的全限定类名(这样可以解决如果使用oracle数据库不能注册的问题)
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //DriverManager.registerDriver(new Driver());//这种方式如果没有对应的依赖jar包就会导致编译期通不过，编译器错误
        Class.forName("com.mysql.jdbc.Driver");//这种方式如果没有对应的依赖jar包会导致运行期异常
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "root");
        //3.获取数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行sql，获取结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }

}
