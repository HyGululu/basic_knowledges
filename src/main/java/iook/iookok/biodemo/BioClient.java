package iook.iookok.biodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioClient {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket=null;
                    BufferedReader in = null;
                    PrintWriter out = null;

                    try {
                        socket = new Socket("127.0.0.1",1993);
                        System.out.println("client init ");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out = new PrintWriter(socket.getOutputStream());
                        out.print("1\n");
                        out.flush();
                        System.out.println("client send ");
                        System.out.println("client received "+in.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
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
            }).start();
        }
    }
}
