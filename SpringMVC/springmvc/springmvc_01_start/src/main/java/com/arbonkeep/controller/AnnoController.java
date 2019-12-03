package com.arbonkeep.controller;

import com.arbonkeep.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @author arbonkeep
 * @date 2019/12/3 - 13:31
 * 测试注解的Controller
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg")//把msg=张三存到session域中

public class AnnoController {
    /**
     * 测试RequestParam注解
     * @return
     */
    @RequestMapping("/testRequestParam")
    //当形参与jsp中页面发送的请求参数不一致时，可以使用该注解完成匹配
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行中。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * 测试requestBody注解
     * @param body
     * @return
     */
    @RequestMapping(path = "/testRequestBody")
    //该注解用于获取请求体
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行中。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * 测试PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(path = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("执行中。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 测试RequestHeader注解
     * @param
     * @return
     */
    @RequestMapping(path = "/testRequestHeader")
    //该注解用于获取请求头
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("执行中。。。");
        System.out.println(header);
        return "success";
    }

    /**
     * 测试CookieValue
     * @return
     */
    @RequestMapping(path = "/testCookieValue")
    //该注解用于获取Cookie的值
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String s) {
        System.out.println("执行中。。。");
        System.out.println(s);
        return "success";
    }

    /**
     * 测试ModelAttribute没有参数
     * @return
     */
//    @RequestMapping(path = "/testModelAttribute")
//    public String testModelAttribute( User user) {
//        System.out.println("testModelAttribute执行中。。。");
//        System.out.println(user);
//        return "success";
//    }

    //方法会先执行
//       @ModelAttribute
//    public User testUser(String name) {
//        System.out.println("testUser执行中。。。");
//        //模拟从数据库中获取到数据
//        User user = new User();
//        user.setName(name);
//        user.setAge(18);
//        user.setBirthday(new Date());
//        return user;
//    }

    /**
     * 测试有参数的ModelAttribute
     * @param user
     * @return
     */
    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("01") User user) {
        System.out.println("testModelAttribute执行中。。。");
        System.out.println(user);
        return "success";
    }

    //方法会先执行
    @ModelAttribute
    public void testUser(String name, Map<String,User> map) {
        System.out.println("testUser执行中。。。");
        //模拟从数据库中获取到数据
        User user = new User();
        user.setName(name);
        user.setAge(18);
        user.setBirthday(new Date());

        map.put("01",user);
    }

    /**
     * 测试SessionAttributes
     * @return
     */
    @RequestMapping(path = "/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行中。。。");
        //底层会存储到request域对象中
        model.addAttribute("msg", "账单");
        return "success";
    }

    /**
     * 获取
     * @param modelMap
     * @return
     */
    @RequestMapping(path = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行中。。。");
        //底层会存储到request域对象中
        String msg = (String)modelMap.get("msg");
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(path = "/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("deleteSessionAttributes执行中。。。");
        //底层会存储到request域对象中
        status.setComplete();
        return "success";
    }





}
