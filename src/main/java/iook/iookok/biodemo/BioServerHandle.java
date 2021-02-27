package iook.iookok.biodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//编写一个方法 和客户端通信
public class BioServerHandle extends Thread {
    //通过socket获取输入流
    private Socket socket;

    public BioServerHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        String body = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);
            //循环的读取客户端发送的数据
            while ((body = in.readLine()) != null && body.length() != 0) {
                //输出客户端发送的数据
                System.out.println("service received " + body);
                out.print("2\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
