package designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyInvocationHandler代理角色，中介，中介出租房子
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成代理类；重点是第二个参数，获取要代理的抽象角色；之前是一个角色，现在可以代理一类角色
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }


    //proxy：代理类method：代理类的调用处理程序的方法对象
    //处理代理实例上的方法调用并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //核心，本质利用反射实现
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    //看房
    public void seeHouse() {
        System.out.println("我是代理，带客户看房");
    }

    //收中介费
    public void fare() {
        System.out.println("我是代理，收中介费");
    }
}
