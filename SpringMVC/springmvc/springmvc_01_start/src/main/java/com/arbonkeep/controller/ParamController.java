package com.arbonkeep.controller;

import com.arbonkeep.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author arbonkeep
 * @date 2019/12/2 - 15:34
 */
@Controller
@RequestMapping(path = "/param")
public class ParamController {

    /**
     * 请求参数的绑定
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(path = "/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行。。。");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 请求参数的绑定，将参数封装在javabean对象中
     * @return
     */
    @RequestMapping(path = "/testParam2")
    public String testParam2(Account account) {
        System.out.println("执行了。。。");
        System.out.println(account);
        return "success";
    }
}
