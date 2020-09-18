import mqdemo.produce.QueueProducer;
import mqdemo.produce.TopicProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * 生产者ProducerTest生产
 */
public class ProducerTest {

    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void testProduce(){
        queueProducer.sendMessage("StringQueue","这是个队列消息(*^▽^*)");
        topicProducer.sendMessage("StringTopic","这是个发布/订阅消息ヾ(◍°∇°◍)ﾉﾞ");
    }
}
