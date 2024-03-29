package com.arbonkeep.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author arbonkeep
 * @date 2019/12/2 - 16:14
 */
public class User implements Serializable {
    private String name;
    private Integer age;

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
