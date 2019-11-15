package com.arbonkeep.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arbonkeep
 * @date 2019/11/14 - 12:51
 * 自定义Mybatis的配置类
 */
public class Configuration {
    private String Driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers = new HashMap<>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);//此处需要使用追加的方式，因为当有多个mappers时，才不会将前面的覆盖
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
