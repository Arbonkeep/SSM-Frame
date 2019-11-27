package com.arbonkeep.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author arbonkeep
 * @date 2019/11/27 - 16:58
 * 用于记录日志的工具类，里面有公共的方法
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("执行了beforePrintLog方法。。。");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("执行了afterReturningPrintLog方法。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("执行了afterThrowingPrintLog方法。。。");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("执行了afterPrintLog方法。。。");
    }

    /**
     * 环绕通知
         1) 问题：
         当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。

         2) 分析：
         通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。

         3) 解决：
         * Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明
         确调用切入点方法。

         * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。

         4) spring中的环绕通知：
         它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。

     */
    //通过环绕通知可以自定义四种通知
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            //1.获取执行参数
            Object[] args = pjp.getArgs();
            System.out.println("执行了aroundPrintLog方法。。。");//前置
            //2.执行方法
            result = pjp.proceed(args);
            System.out.println("执行了aroundPrintLog方法。。。");//后置
            return result;
        }catch (Throwable t) {
            System.out.println("执行了aroundPrintLog方法。。。");//异常
            throw new RuntimeException(t);

        }finally {
            System.out.println("执行了aroundPrintLog方法。。。");//最终
        }
    }


}
