package ipok.tcpdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器 先启动服务端
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
public class TcpServerDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket =null;
        InputStream is =null;
        ByteArrayOutputStream baos = null;
        try {
            //1，我要有个地址
             serverSocket =new ServerSocket(9999);
            //2、等待客户端连接过来        
            socket= serverSocket.accept();
            //3、读取客户端的消息        
             is = socket.getInputStream();

            /*
            暴力方式读消息

            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
               java.lang.String msg = new java.lang.String(buffer,0,len);
                System.out.println(msg);
            }
            */

            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len ;
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
