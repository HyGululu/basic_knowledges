package rpcdemo.rpc07;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8882);
        while (running) {
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();

    }

    private static void process(Socket s) throws Exception {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        ObjectInputStream ois = new ObjectInputStream(in);

        //先读到class名字
        String clazzName = ois.readUTF();
        String methodName = ois.readUTF();
        Class[] parameterType = (Class[])ois.readObject();
        Object[] args = (Object[])ois.readObject();



        //UserServiceImpl ser = new UserServiceImpl();
        //对象
        Class clazz = null;
        //从服务注册表找到具体的实现类,可以用spring注入
        clazz = UserServiceImpl.class;



       /* Method method = ser.getClass().getMethod(methodName, parameterType);
        User user = (User)method.invoke(ser, args);*/
        Method method = clazz.getMethod(methodName, parameterType);
        Object o = (Object)method.invoke(clazz.newInstance(), args);


        /*dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();*/

        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);
        oos.flush();

    }
}
