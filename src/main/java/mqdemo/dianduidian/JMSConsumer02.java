package mqdemo.dianduidian;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者
 * 消息消费者二：通过消息监听获取消息
 */
public class JMSConsumer02 {
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

        //实例化连接工厂，使用默认用户名、密码、路径，路径 tcp://host:61616
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //开启连接
            connection.start();
            //建立会话,第一个参数，是否使用事务，如果设置true，操作消息队列后，必须使用 session.commit();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建消息队列或者话题
            destination = session.createQueue("HelloActiveMQ");

            //创建消息消费者
            messageConsumer = session.createConsumer(destination);

            //注册消息监听
            messageConsumer.setMessageListener(new Listener());

            //不能关闭线程
/*            while (true){

            }*/
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
