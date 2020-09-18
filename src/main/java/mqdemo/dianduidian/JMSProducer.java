package mqdemo.dianduidian;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息发布者，队列形式(queue)
 * 消息队列--ActiveMQ
 * 点对点模式，不可重复消费
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory = null;
        //连接
        Connection connection = null;
        //会话接收或者发送消息的线程
        Session session = null;
        //消息的目的地
        Destination destination = null;
        //消息生产者
        MessageProducer messageProducer = null;

        //实例化连接工厂，使用默认的用户名,密码,路径，路径为 tcp://host:61616
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);


        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();

            connection.start();

            //建立会话,第一个参数是否开启事务,为true时,最后需要session.conmit()的提交
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //创建消息队列或者话题
            destination = session.createQueue("HelloActiveMQ");

            //创建消息生产者
            messageProducer = session.createProducer(destination);

            //发送消息
            sendMessage(session, messageProducer);

            //事务提交
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void sendMessage(Session session, MessageProducer messageProducer) {
        for (int i = 0; i < SENDNUM; i++) {
            try {
                TextMessage textMessage = session.createTextMessage("ActiveMQ 发送的消息 " + i);
                System.out.println("发送消息：ActiveMQ发送的消息 " + i);
                messageProducer.send(textMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
