package com.arbonkeep.controller;

import com.arbonkeep.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author arbonkeep
 * @date 2019/12/5 - 16:20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException方法执行了");
        try {
            //模拟异常
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义异常
            throw new SysException("查询出错。。。");
        }

        return "success";
    }

}
