package com.arbonkeep.service.impl;

import com.arbonkeep.service.AccountService;

import java.util.*;

/**
 * @author arbonkeep
 * @date 2019/11/23 - 15:46
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements AccountService {
    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProp;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProp(Properties myProp) {
        this.myProp = myProp;
    }

    /**
     * 执行保存的业务逻辑
     */
    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(myStr));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProp);
    }

}
