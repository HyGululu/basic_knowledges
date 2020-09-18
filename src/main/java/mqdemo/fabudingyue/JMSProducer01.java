package mqdemo.fabudingyue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息发布者
 * 消息队列--ActiveMQ
 * 发布/订阅模式，可重复消费
 */
public class JMSProducer01 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null; //连接工厂
        Connection connection = null; //连接
        Session session = null; //会话接收或者发送消息的线程
        Destination destination = null; //消息的目的地
        MessageProducer messageProducer = null; //消息生产者

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //创建消息队列
            destination = session.createTopic("FirstTopic1");
            //创建消息生产者
            messageProducer = session.createProducer(destination);

            //发送消息
            sendMessage(session, messageProducer);

            session.commit();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer messageProducer) {
        for (int i = 0; i < SENDNUM; i++) {
            try {
                TextMessage textMessage = session.createTextMessage("ActiveMQ 发送的消息" + i);
                System.out.println("发送消息：ActiveMQ发布的消息" + i);
                messageProducer.send(textMessage);
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
