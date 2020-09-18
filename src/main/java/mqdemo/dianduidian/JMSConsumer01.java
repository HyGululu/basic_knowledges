package mqdemo.dianduidian;

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
public class JMSConsumer01 {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKERURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory = null;
        //连接
        Connection connection = null;
        //会话接收或者发送消息的线程
        Session session = null;
        //消息的目的地
        Destination destination = null;
        //消息消费者
        MessageConsumer messageConsumer = null;

        //实例化连接工厂，使用默认用户名、密码、路径， 路径 tcp://host:61616
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);


        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //开启连接
            connection.start();
            //建立会话,第一个参数是否开启事务,为true时,最后需要session.conmit()的提交
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建消息队列或者话题，这里是队列
            destination = session.createQueue("HelloActiveMQ");

            //创建消息生产者
            messageConsumer = session.createConsumer(destination);

            while (true) {
                TextMessage message = (TextMessage) messageConsumer.receive(5000);
                if (message != null) {
                    System.out.println("接收到的消息： " + message.getText());
                } else {
                    break;
                }
            }
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
}
