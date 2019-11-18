package com.arbonkeep.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/11/18 - 13:19
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String address;
    private Date birthday;
    private String sex;

    //多对多的关系映射：一个用户可以被赋予多个角色（查询用户获取角色下所属的角色信息）
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
