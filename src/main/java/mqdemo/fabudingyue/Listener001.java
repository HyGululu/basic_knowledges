package mqdemo.fabudingyue;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消费者二自定义消息监听器
 */
public class Listener001 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
            System.out.println("收到的消息：" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
