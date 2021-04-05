package ipok.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClientDemo01 {
    /*
    UDP实现发送消息
    1、不需要连接服务器
    1、建立socket
    2、建个包
    3、发送包
     */
    public static void main(String[] args) throws IOException {
        //1、建立一个socket
        DatagramSocket socket = new DatagramSocket();

        //2、建立一个包
        String msg = "你好啊，服务器！";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port =9090;
        //数据，数据长度、发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3、发送包
        socket.send(packet);

        //4、关闭资源
        socket.close();
    }
}
