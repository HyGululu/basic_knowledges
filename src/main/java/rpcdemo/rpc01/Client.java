package rpcdemo.rpc01;

import rpcdemo.rpc1.User;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 8881);
        //字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //基础数据类型
        DataOutputStream dos = new DataOutputStream(baos);
        //自动转成二进制类型
        dos.writeInt(234);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);

        System.out.println(user);

        dos.close();
        s.close();


    }
}
