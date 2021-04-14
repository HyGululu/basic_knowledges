package designpattern.dynamicproxy;

import java.lang.reflect.*;

/**
 * Proxy类getProxyClass方法（一般不用这个方法；而使用Proxy类的另一个静态方法：Proxy.newProxyInstance()）
 */

public class ProxyDemoTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Landlord target = new Landlord();

        //传入目标对象 调用者把目标对象作为参数传进来
        //目的：1.根据它实现的接口生成代理对象
        // 2.代理对象调用目标对象方法
        Rent proxyObject = (Rent) getProxy(target);//强制转换，从Object到Rent类型
        proxyObject.rent();

        System.out.println(proxyObject.getClass().getName());
        System.out.println(proxyObject instanceof Rent);


    }

    private static Object getProxy(Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 两个参数  参数1：随便找个类加载器给它， 参数2：目标对象实现的接口，让代理对象实现相同接口
         * ClassLoader loader 类加载器；把类加载到内存的类加载器
         * Class<?>... interfaces 接口；代理对象和目标对象需要实现相同的接口
         */
        Class proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(),
                target.getClass().getInterfaces());
        //得到有参构造器$Proxy0(InvactionHander h)
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //反射创建代理实例
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行...");
                //反射执行目标对象的方法
                Object result = method.invoke(target, args);
                System.out.println(result);
                System.out.println(method.getName() + "方法执行结束...");
                //返回目标对象执行结果
                return result;
            }
        });
        return proxy;
    }
}
/*
Proxy.getProxyClass()这个方法的本质就是：以Class造Class

代理对象是什么类型。
首先，请区分两个概念：代理Class对象和代理对象

代理Class对象  com.sun.proxy.$Proxy0
Class proxyClazz = Proxy.getProxyClass
代理对象
Object proxy

 */