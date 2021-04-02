package ipok;

//测试ip

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            //查询网址ip地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            System.out.println(inetAddress2.getCanonicalHostName());
            System.out.println(inetAddress2.getHostAddress());
            System.out.println(inetAddress2.getHostName());
            System.out.println(inetAddress2.getAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
