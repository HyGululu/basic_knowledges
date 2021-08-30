import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JULTest {
    @Test
    public void testQuickJUL(){
        //1、获取日志记录器对象
        Logger logger = Logger.getLogger("JULTest");
        //2、日志记录输出
        logger.info("hello jul info");
        //3、通用方法日志输出
        logger.log(Level.INFO,"info info2");
        //4、占位符 输出变量值
        String name ="zhangsan";
        String age = "12";
        logger.log(Level.INFO,"用户信息{0}{1}",new Object[]{name,age});
    }
    @Test
    public void testQuickJUL2(){
        //1、获取日志记录器对象
        Logger logger = Logger.getLogger("JULTest");
        //2、7个日志级别
        logger.severe("severe log");
        logger.warning("warning log");
        logger.info("info log");// jul 默认的日志级别
        logger.fine("fine log");
        logger.finer("finer log");
        logger.finest("finest log");

    }
}
