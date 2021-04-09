package designpattern.dynamicproxy.rpcanddyn;


import java.lang.reflect.Method;

/**
 * ProxyHandler
 * 代理类，必须继承自InvocationHandler接口
 */
public class ProxyHandler implements  java.lang.reflect.InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy Doing");
        System.out.println("Proxy: "+proxy.getClass());
        System.out.println("method: "+method.toGenericString());
        System.out.println("args: " +args);
        System.out.println("序列化后去寻找具体实现……");
        return "Proxy Finish";
    }
}
