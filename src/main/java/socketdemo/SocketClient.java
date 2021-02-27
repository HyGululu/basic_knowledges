package socketdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * 客户端的启动类
 * 1、完成向用户询问服务器地址和端口的操作
 * 2、然后向服务端发起连接
 * 3、接受用户输入，并发送到服务端
 */
public class SocketClient {

    private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);

    /**
     * 启动客户端，连接服务器
     */
    public SocketClient() {

        //从控制台输入System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("请输入服务器地址：");
            String host = reader.readLine();
            System.out.print("请输入服务器端口：");
            int port = Integer.parseInt(reader.readLine());

            Socket socket = new Socket(host, port);
            logger.info("连接：{}:{}", host, port);

            // 开启多线程接收信息，并解析
            ClientHandler handler = new ClientHandler(socket);
            handler.start();

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (!socket.isClosed()){
                String line =reader.readLine();
                if (line==null||line.isEmpty()){
                    continue;
                }
                logger.info("读取：{}", line);
                //发消息
                writer.println(line);
                writer.flush();
            }
            


        } catch (IOException e) {
            e.printStackTrace();
            logger.error("服务器异常,{}", e.getMessage());

        }
    }
    }
