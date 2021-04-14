package designpattern.dynamicproxy;

import java.lang.reflect.*;

/**
 * 使用Proxy类的另一个静态方法：
 * Proxy.newProxyInstance()，
 * 直接返回代理实例，连中间得到代理Class对象的过程都帮你隐藏
 */
public class ProxyDemoTest02 {
    public static void main(String[] args) throws Exception {
        Landlord target = new Landlord();
        Rent rent = (Rent) getProxy(target);
        rent.rent();
    }

    private static Object getProxy(Object target) throws Exception {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),/*类加载器*/
                target.getClass().getInterfaces(),//让代理对象和目标对象实现相同接口
                new InvocationHandler() {//代理对象的方法最终都会被JVM导向它的invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName()+" 方法开始执行……");
                        Object result = method.invoke(target, args);
                        System.out.println(result);
                        System.out.println(method.getName()+" 方法执行结束");
                        return result;
                    }
                });

        return proxy;
    }
}
