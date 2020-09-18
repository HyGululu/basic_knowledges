package mqdemo.consumer;


import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Queue消费者(队列消费者)
 */
@Service
public class QueueConsumer2 implements MessageListener{
    @Override
    public void onMessage(Message message) {
        //每次接收消息，自动调用 onMessage
        try {
            String messageText = ((TextMessage) message).getText();
            System.out.println("消费的QueueConsumer2获取消息："+messageText);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
