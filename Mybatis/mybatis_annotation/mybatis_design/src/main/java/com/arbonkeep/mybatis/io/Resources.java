package com.arbonkeep.mybatis.io;

import java.io.InputStream;

/**
 * @author arbonkeep
 * @date 2019/11/13 - 20:10
 * 使用类加载器加载配置文件的类
 *
 */
public class Resources {
    /**
     * 根据一个传入的参数获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }

}
