package rpcdemo.rpc06;

import rpcdemo.rpc1.IUserService;
import rpcdemo.rpc1.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    //public static IUserService getStub(){
    public static Object getStub(Class clazz){
        //调用处理器，调用方法处理器
        InvocationHandler h =new InvocationHandler(){
            @Override
            //proxy  :user, Method :findUserById, Object[] :123
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                //class名字
                String clazzName = clazz.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                //class名字
                oos.writeUTF(clazzName);
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();


                //返回值搞个普通对象
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User user =(User)ois.readObject();

                oos.close();
                s.close();
                return user;
            }
        };
        //代理类对象  实现的接口
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class},h);
        System.out.println(o.getClass().getName());
        System.out.println(o.getClass().getInterfaces()[0]);
        return (IUserService)o;
    }
}
