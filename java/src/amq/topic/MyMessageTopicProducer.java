package amq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Q.W
 * @Date: 2019/8/17 20:08
 */
public class MyMessageTopicProducer {

    /**
     * 定义ActivMQ的连接地址
     */
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    /**
     * 定义发送消息的主题名称
     */
    private static final String TOPIC_NAME = "use_coupon_topic";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 100; i <= 200; i++) {
            TextMessage message = session.createTextMessage("当前message是(主题模型):" + i);
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("我现在发的消息是：" + message.getText());
        }
        //关闭连接
        connection.close();
    }
}
