package socketdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

/**
 * 服务器类
 * 1、需要完成启动ServerSocket接受客户端连接
 * 2、保留客户端信息
 * 3、清除已经断开的客户端信息
 * 4、对外暴露向客户端发送消息的接口
 *
 * 使用到了定时器，代码需要java8环境，日志记录为slf4j接口
 */
public class SocketServer extends Timer {
    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    ServerSocket serverSocket;

    private List<SocketClientHandler> clients = new ArrayList<>();

    /**
     * 开启监听，接受链接
     */
    public SocketServer(Integer port) {
        // 清理客户端

        try {
            serverSocket = new ServerSocket(port);
            logger.info("服务端已启动，等待客户端连接..");
            new Thread(() -> {
                while (!serverSocket.isClosed()) {
                    try {
                        Socket socket = serverSocket.accept();
                        logger.info("与客户端连接成功");
                        String clientIp = socket.getInetAddress().getHostAddress();
                        logger.info("client:{}", clientIp);

                        SocketClientHandler handler = new SocketClientHandler(socket);
                        handler.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用于清理已经断开的客户端
     */
    public void run() {
        Iterator<SocketClientHandler> it =clients.iterator();
        while (it.hasNext()){
            SocketClientHandler handler = it.next();
            if (handler.isAlive()){
                it.remove();
            }
        }
    }

    /**
     * 往客户端发送消息
     *
     * @param msg
     *            消息
     */
    public void sendMessage(String msg){
        logger.info("send:{}", msg);
        clients.stream().forEach(client->client.sendMessage(msg));
    }


}
