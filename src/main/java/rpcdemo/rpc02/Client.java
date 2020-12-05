package rpcdemo.rpc02;

import rpcdemo.rpc1.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //用代理，网络相关的代理
        Stub stub = new Stub();
        System.out.println(stub.findUserById(123234));
    }
}
