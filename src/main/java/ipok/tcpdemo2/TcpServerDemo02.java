package ipok.tcpdemo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/*
TCP文件上传实现（图片） 接收图片
  客户端
    1、连接服务器socket
    2、发送消息
  服务器
    1、建立服务的端口ServerSocket
    2、等待用户的连接 accept
    3、接收用户消息
 */
public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2、监听客户端连接，
        // 是阻塞式监听，一直等待客户端连接,代码才会走下去，同下Scanner
        /*Scanner scanner = new Scanner(System.in);
        scanner.next();*/
        Socket socket = serverSocket.accept();
        //3、获取输入流
        InputStream is = socket.getInputStream();

        //4、文件输出，接收文件用文件的管道流
        FileOutputStream fos = new FileOutputStream(new File("received.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //通知客户端我接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕了，你可以断开了".getBytes());

        //5、关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
