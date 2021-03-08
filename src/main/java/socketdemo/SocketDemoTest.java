package socketdemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1、接受用户输入端口并且启动服务器的入口类
 * 2、还需要完成接受用户输入发送给客户端
 */
public class SocketDemoTest {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入服务器端口(默认8080):");
        Integer port =8881;

        try {
            Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        SocketServer server = new SocketServer(port);
        while (true){
            try {
                String line = reader.readLine();
                if (line.equals("exit")){
                    System.exit(0);
                    break;
                }
                server.sendMessage(line);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }
}
