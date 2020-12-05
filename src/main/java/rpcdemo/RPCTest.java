package rpcdemo;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * RPC demo 测试类
 */
public class RPCTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rpcdemo.Server serviceServer = (rpcdemo.Server) new rpcdemo.ServiceCenter(8088);
                    serviceServer.register(rpcdemo.HelloService.class, rpcdemo.HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        rpcdemo.HelloService service = rpcdemo.RPCClient.getRemoteProxyObj(rpcdemo.HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("hello a rpc !!! get it?"));
    }
}
