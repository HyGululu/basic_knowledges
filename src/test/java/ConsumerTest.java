import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ConsumerTest(消费者监听)
 * spring的JUnit4来进行注解测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-mq-consumer.xml")
public class ConsumerTest {
    @Test
    public void testProduce(){
        //线程不能关闭
        while (true){

        }
    }
}
