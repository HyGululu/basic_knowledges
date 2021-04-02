package designpattern.dynamicproxy.dynamicproxy01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class IServiceProxy implements InvocationHandler {
    private Object target;

    IServiceProxy(Object target){
        this.target =target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
        /*try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e){
            throw e.getCause();
        }*/
    }

}
