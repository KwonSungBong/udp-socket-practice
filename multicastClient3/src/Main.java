import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

/*
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(); //Multicast용 우체통.
        while (true) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream (bos);
            out.writeObject(new Integer(5));
            out.flush();
            out.close();

            InetAddress ia = InetAddress.getByName("224.0.0.1");
            //Multicast용 IP중에서 임의의 하나를 선택.
            DatagramPacket data = new DatagramPacket(bos.toByteArray(), bos.size(), ia, 28000);
            ms.send(data);
            break;
        }
        //ms.close();
    }
*/

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(); //Multicast용 우체통.
        while (true) {
            int messageLength = 5;

            byte[] messageLengthByte = intToByteArray(messageLength);

            System.out.println(messageLengthByte.length);

            InetAddress ia = InetAddress.getByName("224.0.0.1");
            //Multicast용 IP중에서 임의의 하나를 선택.
            DatagramPacket data = new DatagramPacket(messageLengthByte, messageLengthByte.length, ia, 28000);
            ms.send(data);
            break;
        }
        //ms.close();
    }

    public static byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte)(value >> 24);
        byteArray[1] = (byte)(value >> 16);
        byteArray[2] = (byte)(value >> 8);
        byteArray[3] = (byte)(value);
        return byteArray;
    }


}
