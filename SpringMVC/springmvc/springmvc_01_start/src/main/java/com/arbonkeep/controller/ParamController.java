package com.arbonkeep.controller;

import com.arbonkeep.domain.Account;
import com.arbonkeep.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(path = {"/testUser"})
    public String testUser(User user) {
        System.out.println("执行测试user。。。");
        System.out.println(user);
        return "success";
    }

    /**
     * 获取Request对象
     */
    @RequestMapping(path = "/testRequest")
    public String testRequest(HttpServletRequest request) {
        System.out.println("开始执行");
        System.out.println(request);
        return "success";
    }
}
