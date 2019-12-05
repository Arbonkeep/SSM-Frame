package com.arbonkeep.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author arbonkeep
 * @date 2019/12/5 - 19:11
 * 自定义拦截器类
 */
public class MyInterceptor1 implements HandlerInterceptor {
    //由于jdk8的特性，底层接口中提供了默认实现

    /**
     * 预处理方法：执行在Controller之前
     * return true，表示放行，执行下一个拦截器，如果没有执行Controller方法
     * return false，表示拦截
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        System.out.println("MyInterceptor1执行了。。。预处理111");
        //放行
        return true;

        //不放行
        //请求跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;

    }

    /**
     * 后处理方法：controller方法之后执行,success.jsp之前执行(controller方法之后执行了就一定会执行)
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了。。。后处理111");
        //这里也可以指定跳转页面，如果指定了，就不会跳转到success.jsp，但是success.jsp有输出
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("MyInterceptor1执行了。。。最后执行111");
    }
}
