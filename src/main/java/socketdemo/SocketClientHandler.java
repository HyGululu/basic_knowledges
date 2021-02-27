package socketdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;


/**
 * 客户端信息处理为单独的线程
 * 1、保存客户端的socket对象
 * 2、接受客户端消息并进行处理(这里只是打印)
 * 3、同时实际完成向客户端发送消息
 */
public class SocketClientHandler extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(SocketClientHandler.class);

    Socket client;
    String ip;

    BufferedReader reader;
    PrintWriter writer;

    public SocketClientHandler(Socket socket) {
        this.ip=socket.getInetAddress().getHostAddress();

        this.client = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("init socket client error,{}", e.getMessage());

        }
    }

    public void run() {
        while (!client.isClosed()) {
            try {
                String msg = reader.readLine();
                if (msg == null) {
                    break;
                }
                receiveMessage(msg);
            } catch (IOException e) {
                logger.info(e.getMessage());
                break;
            }
        }
    }


    /**
     * 发送消息
     *
     * @param msg
     *            发送的消息
     */
    public void sendMessage(String msg) {
        logger.info("to:{},send:{}", ip, msg);
        writer.println(msg);
    }

    /**
     * 收到消息之后的处理
     *
     * @param msg
     *            收到的消息
     */
    public void receiveMessage(String msg) {
        logger.info("from:{},receive:{}", ip, msg);
    }



}
