package com.arbonkeep.proxy;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 16:31
 * 模拟生产者的接口
 */
public interface IProducer {
    /**
     * 销售产品的方法
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后服务的方法
     * @param money
     */
    void afterService(float money);
}
