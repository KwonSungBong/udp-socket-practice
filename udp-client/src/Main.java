import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte buffer[] = new byte[256];

        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 1234);

        socket.send(packet);

        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        byte[] param1 = Arrays.copyOfRange(packet.getData(),0, 8);
        byte[] param2 = Arrays.copyOfRange(packet.getData(),8, 13);
        byte[] param3 = Arrays.copyOfRange(packet.getData(),13, 18);

        String parseParam1 = new String(param1);
        int parseParam2 = Integer.parseInt(new String(param2));
        String parseParam3 = new String(param3);

        System.out.println("parseParam1 : " + parseParam1);
        System.out.println("parseParam2 : " + parseParam2);
        System.out.println("parseParam3 : " + parseParam3);

        socket.close();
    }
}
