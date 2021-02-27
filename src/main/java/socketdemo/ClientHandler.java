package socketdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端信息处理
 * <p>
 * 由于客户端的启动类需要完成用户输入的收集，
 * 所以接受服务端消息的操作由单独的线程进行，
 * 用于对服务器端发送过来的消息进行处理
 */
public class ClientHandler extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    private Socket socket;
    BufferedReader reader;

    public ClientHandler(Socket socket) {
        this.socket = socket;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 接收消息并打印，在收到的消息为{@code null}或者空字符串时退出
     */
    @Override
    public void run() {
        while (!socket.isClosed()) {
            String msg = null;
            try {
                msg = reader.readLine();
                if (msg == null) {
                    break;
                }
                receiveMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 对服务器发送消息进行处理
     *
     * @param msg 消息内容
     */
    private void receiveMessage(String msg) {
        logger.info("收到：{}", msg);

    }
}
