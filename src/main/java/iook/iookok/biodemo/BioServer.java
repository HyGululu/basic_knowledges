package iook.iookok.biodemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        try {
            //创建ServerSocket
            serverSocket = new ServerSocket(1993);
            System.out.println("服务器启动了!!");
            Socket socket=null;
            while (true){
                System.out.println("等待连接");
                //监听 等待客户端连接
                socket=serverSocket.accept();
                System.out.println("链接到一个客户端 ……");
                //创建一个线程与之通讯
                Thread thread  = new BioServerHandle(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
