package com.arbonkeep.controller;

import com.arbonkeep.domain.User;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author arbonkeep
 * @date 2019/12/4 - 13:07
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
    /**
     * 测试返回值为字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString执行。。。");
//        模拟从数据库中获取到一个user对象
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(18);
        //将user对象存储起来(可以在页面上获取)
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 测试返回值是void
     * 请求转发是一次请求，不需要写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testViod(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
        System.out.println("testVoid方法执行了。。。");
        //1.跳转页面
        //1.1编写请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //1.2重定向
        //response.sendRedirect(request.getContextPath() + "index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //2.直接响应
        response.getWriter().print("大家好");
        return ;

    }

    /**
     * 测试返回值为ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法执行。。。");
        ModelAndView view = new ModelAndView();
        //模拟数据库用户对象
        User user = new User();
        user.setUsername("李四");
        user.setPassword("123");
        user.setAge(18);
        //调用方法将对象存入
        view.addObject("user",user);
        //设置跳转到那个页面（会根据视图解析器找到指定位置）
        view.setViewName("success");
        return view;
    }

    /**
     * 使用关键字完成转发或重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了。。。");

        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向(不需要指定项目名称，底层完成)
        return "redirect:/index.jsp";

    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    //@RequestBody获取请求体
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行。。。");
        //客户端发送ajax请求，传送的是json字符串，后端将json字符串封装成User对象
        System.out.println(user);
        //做出响应中，模拟查询数据库
        user.setUsername("美女");
        user.setAge(16);
        //做出响应
        return user;

    }
}
