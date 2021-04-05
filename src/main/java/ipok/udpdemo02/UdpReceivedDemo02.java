package ipok.udpdemo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceivedDemo02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true) {

            //准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //阻塞式接收包裹
            socket.receive(packet);

            //断开连接 控制台输入bye
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);

            System.out.println(receiveData);


            if (receiveData.equals("bye")) {
                break;
            }


        }
        socket.close();
    }
}
