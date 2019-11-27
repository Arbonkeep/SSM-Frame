package com.arbonkeep.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 17:36
 */
public class Client {
    public static void main(String[] args){
        final Producer producer = new Producer();

        Producer proxyProducer = (Producer) Enhancer.create(Producer.class, new MethodInterceptor() {
            Object result = null;

            /**
             *
             * @param proxy 被代理对象
             * @param method 执行的方法
             * @param args  执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //增强方法
                //1.获取方法执行参数
                float money = (float) args[0];
                //2.判断方法
                if ("saleProduct".equals(method.getName())) {
                    result = method.invoke(producer, money * 0.8f);
                }
                return result;
            }
        });

        proxyProducer.saleProduct(1000f);
    }

}


