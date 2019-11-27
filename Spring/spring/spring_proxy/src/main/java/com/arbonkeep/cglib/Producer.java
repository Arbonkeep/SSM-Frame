package com.arbonkeep.cglib;

/**
 * @author arbonkeep
 * @date 2019/11/26 - 17:35
 */
public class Producer {
    public void saleProduct(float money) {
        System.out.println("销售产品，并收到货款：" + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，并受到服务费用：" + money);
    }


}
