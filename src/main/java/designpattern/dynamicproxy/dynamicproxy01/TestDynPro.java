package designpattern.dynamicproxy.dynamicproxy01;

import java.lang.reflect.Proxy;
import java.sql.SQLException;


/*
    使用jdk动态代理接口时，
    若方法执行过程中抛出了受检异常但方法签名又没有声明该异常时
    则会被代理类包装成UndeclaredThrowableException抛出

    复现异常
    java.lang.reflect.UndeclaredThrowableException
    java.lang.reflect.InvocationTargetException

    我们期望的是
    java.sql.SQLException: I test throw an checked Exception
     at com.learn.reflect.ServiceImpl.foo(ServiceImpl.java:11)
     ...

     在上述问题还原中，真实的SQLException被包装了两层，
     先被InvocationTargetException包装，
     再被UndeclaredThrowableException包装。
     其中，InvocationTargetException为受检异常，UndeclaredThrowableException为运行时异常。
     为何会被包装呢，还要从动态代理的生成的代理类说起。

     解决方法
    在实现InvocationHandler的invoke方法体中，对method.invoke(target, args);调用进行try catch，重新 throw InvocationTargetException的cause。即：
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
  try {
   return method.invoke(target, args);
  } catch (InvocationTargetException e){
   throw e.getCause();
  }
}

   为什么代理类中对未声明的受检异常转为UndeclaredThrowableException？
    因为Java继承原则：即子类覆盖父类或实现父接口的方法时，
    抛出的异常必须在原方法支持的异常列表之内。 代理类实现了父接口或覆盖父类方法
     */
public class TestDynPro {
    public static void main(String[] args) {
        IService service = new ServiceImpl();
        IService serviceProxy = (IService) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),new IServiceProxy(service));

        try {
            serviceProxy.foo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
