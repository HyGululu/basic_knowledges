package designpattern.dynamicproxy.rpcanddyn;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * 使用代理
 */
public class TestRpc {
    @Test
    public void test(){
        //生成一个代理对象实例，注意，我们这里只需要接口，不需要知道任何实现类信息
        RemoteService remoteService = (RemoteService) Proxy.newProxyInstance(RemoteService.class.getClassLoader(),
                new Class[]{RemoteService.class},
                new ProxyHandler());

        String out = remoteService.getValue("AA");
        System.out.println(out);
    }
}
