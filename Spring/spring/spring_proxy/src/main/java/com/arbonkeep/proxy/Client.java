package com.arbonkeep.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 16:36
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {

        final Producer producer = new Producer();

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),//被代理对象的类加载器
                producer.getClass().getInterfaces(),//字节码数组
                new InvocationHandler() {
                    /**
                     * 作用:执行被代理对象的任何接口方法都会执行该方法
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需要的参数
                     * @return 与被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        //增强方法
                        //1.获取方法的执行参数
                        float money = (float)args[0];
                        //2.判断当前方法是否为销售
                        if ("saleProduct".equals(method.getName())) {
                            result = method.invoke(producer, money * 0.8f);
                        }
                        return result;
                    }
                });

        proxyProducer.saleProduct(1000);
    }

}
