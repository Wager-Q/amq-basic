package spring.topic.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Q.W
 * @Date: 2019/8/17 23:29
 */

public class ConsumerTest {
    public static void main(String[] args){
        //启动消费者
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer-topic.xml");
    }
}
