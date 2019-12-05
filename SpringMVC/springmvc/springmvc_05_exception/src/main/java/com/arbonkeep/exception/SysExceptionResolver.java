package com.arbonkeep.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器类
 * @author arbonkeep
 * @date 2019/12/5 - 17:01
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o 当前处理器对象
     * @param e 我们抛出的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        //获取异常对象
        SysException ex = null;
        if (e instanceof SysException) {
            ex = (SysException)e;
        }else {
            e = new SysException("系统正在维护...");
        }

        //创建ModelAndView对象
        ModelAndView m = new ModelAndView();
        m.addObject("errorMessage",ex.getMessage());//获取到异常的信息
        m.setViewName("error");//设置跳转页面
        return m;
    }
}
