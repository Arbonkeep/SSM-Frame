package com.arbonkeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author arbonkeep
 * @date 2019/12/2 - 13:34
 * 控制器类
 */
@Controller//将类交给spring的ioc容器管理
@RequestMapping(path = "controller")
public class HelloController {

    @RequestMapping(path = "/hello")//指定请求路径
    public String sayHello() {
        System.out.println("Hello,SpringMVC");
        return "success";
    }

    //指定请求方式为post
    // @RequestMapping(path = "requestMapping", method ={RequestMethod.POST} )
    //指定请求参数的限制(请求参数必须是username=aaa，才能请求成功)
    //@RequestMapping(path = "requestMapping", params = {"username=aaa"})
    //指定请求头(请求头必须是Accept)
    @RequestMapping(path = "requestMapping", headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("测试requestMapping");
        return "success";
    }
}
