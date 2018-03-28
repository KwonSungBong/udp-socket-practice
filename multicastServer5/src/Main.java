import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(28000);
        ms.joinGroup(InetAddress.getByName("224.0.0.1"));
        //Multicast Group에 접속해야 한다.

        while (true)
        {
            byte[] data = new byte[256];
            DatagramPacket packet = new DatagramPacket(data, data.length );
            ms.receive(packet);

            byte[] messageLengthByte = Arrays.copyOfRange(packet.getData(), 0,4);
            byte[] commandByte = Arrays.copyOfRange(packet.getData(), 4,8);

            Integer messageLength = byteArrayToInt(messageLengthByte);
            String command = new String(commandByte);

            System.out.println("messageLength"+" ==> "+messageLength);
            System.out.println("command"+" ==> "+command);

        }
        //ms.close();
    }

    public static int byteArrayToInt(byte bytes[]) {
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) << 8) |
                (((int)bytes[3] & 0xff)));
    }

}
