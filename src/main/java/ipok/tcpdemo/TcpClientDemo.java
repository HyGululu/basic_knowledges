package ipok.tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端 再点击客户端
/*
TCP实现聊天
  客户端
    1、连接服务器socket
    2、发送消息
  服务器
    1、建立服务的端口ServerSocket
    2、等待用户的连接 accept
    3、接收用户消息
 */
public class TcpClientDemo {
    public static void main(String[] args) {
        Socket socket =null;
        OutputStream os=null;

        try {
            //1,要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2、创建一个socket连接
             socket = new Socket(serverIP,port);
            //3，发送消息 IO流
             os = socket.getOutputStream();//往外流出去
            //流写出去
            os.write("你好，欢迎学习socket ".getBytes());




        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
