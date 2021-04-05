package classloaderdemo;

import java.awt.*;

public class Test {
    public static void main(String[] args) throws AWTException {
        new Test().a();//Exception in thread "main" java.lang.StackOverflowError

        new Robot();//牛气的类，可以操作电脑
    }

    public void a(){
        b();
    }
    public void b(){
        a();
    }
}

/*

    沙箱委派机制（了解）
        jvm自我保护的机制，是java历史的发展，代码是安全的，有机制的保障
        安全、权限
        1、类文件里少了分号，字节码校验
        自己写的代码不能调c的库
        new Robot();//可以操作电脑
        数字签名 keytools  https（几万块一年的证书）：
        本地跑https，tomcat跑不起来，但是java可以生成安全证书，这样tomcat可以跑https
        公司信用背书

 */

