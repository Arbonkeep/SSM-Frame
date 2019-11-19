package com.arbonkeep.domain;

import java.io.Serializable;

/**
 * @author arbonkeep
 * @date 2019/11/19 - 19:00
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private double money;

    //多对一的映射：一个账户只能属于一个用户（mybatis中是一对一的关系）
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
