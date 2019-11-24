package com.arbonkeep.test;
import com.arbonkeep.config.configuration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author arbonkeep
 * @date 2019/11/24 - 19:17
 * 测试QueryRunner是否为单例
 */
public class QueryRunnerTest{
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configuration.class);

        QueryRunner runner1 = context.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = context.getBean("runner", QueryRunner.class);

        System.out.println(runner1 == runner2);//我们在configuration配置中配置了多例prototype

    }

}
