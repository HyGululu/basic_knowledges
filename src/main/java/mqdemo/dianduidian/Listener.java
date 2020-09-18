package mqdemo.dianduidian;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消费者二自定义消息监听器
 */
public class Listener  implements MessageListener{
    @Override
    public void onMessage(Message message) {
        //每次接收消息，自动调用 onMessage
        try {
            String messageText = ((TextMessage) message).getText();
            System.out.println("消费者 获取消息："+messageText);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
