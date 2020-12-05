package rpcdemo.rpc01;

import rpcdemo.rpc1.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8881);
        while (running) {
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();

    }

    private static void process(Socket s) throws IOException {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        rpcdemo.rpc01.UserServiceImpl ser = new rpcdemo.rpc01.UserServiceImpl();
        User user = ser.findUserById(id);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();

    }
}
