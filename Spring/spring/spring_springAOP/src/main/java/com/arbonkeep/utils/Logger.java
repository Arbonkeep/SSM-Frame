package com.arbonkeep.utils;

/**
 * @author arbonkeep
 * @date 2019/11/27 - 15:43
 * 用于记录日志的工具类，里面有公共的方法
 */
public class Logger {
    /**
     * 用于打印日志，计划让该方法在切入点方法执行之前执行（切入点方法是业务层方法）
     */
    public void printLog() {
        System.out.println("执行了printLog方法。。。");
    }
}
