代理模式：
Proxy代理模式是一种结构型设计模式，
主要解决的问题是：在直接访问对象时带来的问题

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
例如Spring中的AOP，Struts2中的拦截器等

![img](https://pic4.zhimg.com/80/v2-d187a82b1eb9c088fe60327828ee63aa_1440w.jpg?source=1940ef5c)

![img](https://pic4.zhimg.com/80/v2-28223a1c03c1800052a5dfe4e6cb8c53_1440w.jpg?source=1940ef5c)

动态代理![img](https://pic4.zhimg.com/80/v2-ba3d9206f341be466f18afbdd938a3b3_1440w.jpg?source=1940ef5c)

![img](https://pic1.zhimg.com/80/v2-b5fc8b279a6152889afdfedbb0f611cc_1440w.jpg?source=1940ef5c)

![img](https://pic2.zhimg.com/80/v2-6aacbe1e9df4fe982a68fe142401952e_1440w.jpg?source=1940ef5c)

