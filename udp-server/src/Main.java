import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        DatagramSocket socket = new DatagramSocket(1234);
        boolean listen = true;

        while(listen) {
            byte buffer[] = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, 256);
            socket.receive(packet);

            String test = "testtest12345abcde";
            buffer = test.getBytes();

            InetAddress address = packet.getAddress();
            int portNo = packet.getPort();

            packet = new DatagramPacket(buffer, buffer.length, address, portNo);
            socket.send(packet);
        }

    }
}
