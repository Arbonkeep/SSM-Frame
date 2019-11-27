package com.arbonkeep.proxy;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 16:31
 * 模拟一个生产者
 */
public class Producer implements IProducer{
    @Override
    public void saleProduct(float money) {
        System.out.println("销售产品，并收到货款：" + money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("提供售后服务，并受到服务费用：" + money);
    }
}
