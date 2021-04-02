代理模式：
动态代理
静态代理

静态代理角色：
抽象角色：一般使用接口or抽象类实现
真实角色：被代理角色
代理角色：代理真实角色；代理真实角色后，一般会做一些附属操作；提前写好代理类
客户：使用代理角色进行操作

静态代理优点：
真实的角色，如房东租房子，只管租房子，不管其他事情
公共业务由代理完成，实现业务分工
公共业务扩展变得集中和方便
缺点：
类多了，多了代理类，开发效率低了

动态代理角色：同静态代理
抽象角色：一般使用接口or抽象类实现
真实角色：被代理角色
代理角色：代理真实角色；代理真实角色后，一般会做一些附属操作；动态生成的代理类
客户：使用代理角色进行操作

动态代理分两类：
基于接口动态代理--JDK动态代理
基于类动态代理--CGLIB动态代理
现在用的多的是javasist来生成动态代理

动态代理的几种实现方式，它们分别有什么优缺点
JDK动态代理
CGLIB动态代理
JDK原声动态代理时java原生支持的、不需要任何外部依赖、但是它只能基于接口进行代理
CGLIB通过继承的方式进行代理、无论目标对象没有没实现接口都可以代理，但是无法处理final的情况

JDK动态代理，有两个类，都在rt.jar包java.lang.reflect包下
InvocationHandler  
Proxy

public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
public class Proxy implements java.io.Serializable {
    public static Object newProxyInstance(ClassLoader loader,
                                              Class<?>[] interfaces,
                                              InvocationHandler h)
            throws IllegalArgumentException
        {
}

一个动态代理，一般代理某一类业务
一个动态代理可以代理多个类，代理的是接口

AOP的底层机制是动态代理
AOP核心思想，不改变原来代码的情况下，对原有功能的增强