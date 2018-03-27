import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        MulticastSocket socket = new MulticastSocket(1235);
        InetAddress address = InetAddress.getByName("230.0.0.5");
        socket.joinGroup(address);

        DatagramPacket packet = null;

        for(int i=0; i<3; i++) {
            byte[] buffer = new byte[200];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            System.out.println("test : " + new String(packet.getData()));
        }
        socket.leaveGroup(address);
        socket.close();

    }
}
