package rpcdemo.rpc02;

import rpcdemo.rpc1.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//网络相关代理：屏蔽网络细节
//1、联网络
//2、id写出去
//3、对象写出来
public class Stub {
    public User findUserById(Integer id) throws Exception {

        Socket s = new Socket("127.0.0.1", 8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        int receivedId = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);

        System.out.println(user);

        dos.close();
        s.close();
        return user;


    }
}
