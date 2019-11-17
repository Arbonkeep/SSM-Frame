package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/11/17 - 17:01
 */
public class AccountUser extends Account{//继承account类，本类只需要声明两个属性即可
    private String username;
    private String address;

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

    /**
     * 生成toString方法时，需要将acount的信息也打印出来
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
