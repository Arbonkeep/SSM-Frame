package com.arbonkeep.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author arbonkeep
 * @date 2019/12/5 - 18:53
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor方法执行。。。");

        return "success";
    }

}
