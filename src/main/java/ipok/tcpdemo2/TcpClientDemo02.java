package ipok.tcpdemo2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/*
TCP文件上传实现（图片）发送图片
  客户端
    1、连接服务器socket
    2、发送消息
  服务器
    1、建立服务的端口ServerSocket
    2、等待用户的连接 accept
    3、接收用户消息
 */
public class TcpClientDemo02 {

    public static void main(String[] args) throws IOException {
        //1、创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3、文件流-读取文件
        FileInputStream fis = new FileInputStream(new File("sster.jpg"));
        //4、写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //通知服务器，我已经接收了
        socket.shutdownOutput();//我已经传输完了

        //确定服务器接收完毕，才能断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[] 接收字符串用字符串的管道流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2=new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        //5、关闭资源
        fis.close();
        os.close();
        socket.close();

    }
}
