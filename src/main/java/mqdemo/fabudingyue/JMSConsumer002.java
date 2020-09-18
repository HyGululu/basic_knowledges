package mqdemo.fabudingyue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者（两种消费方式）
 * 消息消费者一：不断从队列出口获取消息
 * <p>
 * 消息队列--ActiveMQ
 * 发布/订阅模式，可重复消费
 */
public class JMSConsumer002 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null; //连接工厂
        Connection connection = null; //连接
        Session session = null; //会话接收或者发送消息的线程
        Destination destination = null; //消息的目的地
        MessageConsumer messageConsumer = null; //消息消费者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建消息队列
            destination = session.createTopic("FirstTopic1");

            // 创建消息消费者
            messageConsumer = session.createConsumer(destination);

            // 注册消息监听
            messageConsumer.setMessageListener(new Listener002());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
