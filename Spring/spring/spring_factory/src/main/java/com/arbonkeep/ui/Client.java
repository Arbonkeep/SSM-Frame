package com.arbonkeep.ui;

import com.arbonkeep.factory.BeanFactory;
import com.arbonkeep.service.AccountService;
import com.arbonkeep.service.impl.AccountServiceImpl;

/**
 * @author arbonkeep
 * @date 2019/11/21 - 14:10
 * 模拟表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();

        //使用工厂模式获取对象,降低耦合
//        AccountService as = (AccountService) BeanFactory.getBean("AccountService");
                                            //注意名称需要与配置文件中一致，注意大小写
//        as.saveAccount();

        //进一步分析问题：由下面运行结果发现，工厂类创建的对象是多例的，即每个对象都是不同的
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService) BeanFactory.getBean("AccountService");
            System.out.println(as);

            as.saveAccount();
        }

    }

}
