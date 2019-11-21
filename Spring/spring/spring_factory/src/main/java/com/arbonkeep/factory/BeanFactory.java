package com.arbonkeep.factory;

import java.io.InputStream;
import java.util.*;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:25
 *
 * 一个创建bean对象的工厂
 * Bean在计算机英语中，有可重用组件的含义
 * JavaBean：用Java语言编写的可重用组件(javabean 不等于实体类)
 *
 * 在这里就是用于创建service和dao对象的
 *
 *实现步骤（配置文件可以是xml或者properties文件）
 *  1.需要一个配置文件对我们的service和dao进行配置
 *      其中配置内容包括：唯一标识=全限定类名(key = value)
 *  2.通过读取配置文件，使用反射创建对象
 *
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties prop;

    //定义一个map，用于存放创建的对象，即容器
    private static Map<String, Object> beans;

    //使用静态代码块完成初始化
    static {
        try {
            //实例化prop
            prop = new Properties();
            //获取一个properties的InputStream流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //加载
            prop.load(is);

            //实例化容器
            beans = new HashMap<>();

            //取出配置文件中所有key
            Enumeration keys = prop.keys();
            //遍历枚举
            while(keys.hasMoreElements()) {
                //获取到每一个key
                String key = keys.nextElement().toString();
                //通过key获取value
                String beanPath = prop.getProperty(key);
                //使用反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //将对象添加到map中
                beans.put(key,value);
            }

        }catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    public static Object getBean(String name) {

        /**
         * 为了解决空指针异常，做出间歇性判断(由于在初始化没有完成的情况下(第一次循环未结束)调用了getBean方法)
         */
        try {
            Object result = beans.get(name);
            if ( result == null ) {
                String beanPath = prop.getProperty(name);
                result = Class.forName(beanPath).newInstance();
                beans.put(name,result);
            }
            return beans.get( name );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


//    /**
//     * 根据bean的名称获取bean对象
//     * @param name
//     * @return
//     */
//    public static Object getBean(String name) {
//        Object bean = null;
//
//        try {
//            //获取到传入bean的名称的完全限定名
//            String beanPath = prop.getProperty(name);
//            //使用反射完成对象的获取
//            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //将bean返回
//        return bean;
//
//    }

}
