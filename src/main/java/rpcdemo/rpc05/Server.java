package rpcdemo.rpc05;

import rpcdemo.rpc1.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
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

        //方法名读进来
        String methodName = ois.readUTF();
        //参数类型读进来
        Class[] parameterType = (Class[])ois.readObject();
        //具体参数传过来
        Object[] args = (Object[])ois.readObject();


        /*int id = dis.readInt();
        UserServiceImpl ser = new UserServiceImpl();
        User user = ser.findUserById(id);
        */

        UserServiceImpl ser = new UserServiceImpl();
        //找到方法
        Method method = ser.getClass().getMethod(methodName, parameterType);
        User user = (User)method.invoke(ser, args);

        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();

    }
}
