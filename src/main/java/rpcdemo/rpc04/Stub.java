package rpcdemo.rpc04;

import rpcdemo.rpc1.IUserService;
import rpcdemo.rpc1.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
public class Stub {
    public static IUserService getStub(){
        //调用处理器，调用方法处理器
        InvocationHandler h =new InvocationHandler(){
            @Override
            //proxy  :user, Method :findUserById, Object[] :123
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String methodName = method.getName();
                //防止重载，参数类型也写上
                Class<?>[] parameterTypes = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123);
                s.getOutputStream().write(baos.toByteArray());
                s.getOutputStream().flush();*/

                DataInputStream dis = new DataInputStream(s.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                System.out.println(user);

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
