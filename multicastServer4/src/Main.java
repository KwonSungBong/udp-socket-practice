import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(28000);
        ms.joinGroup(InetAddress.getByName("224.0.0.1"));
        //Multicast Group에 접속해야 한다.

        while (true)
        {
            byte[] data = new byte[256];
            DatagramPacket packet = new DatagramPacket(data, data.length );
            ms.receive(packet);

            ByteArrayInputStream bistream =

                    new ByteArrayInputStream(packet.getData());

            ObjectInputStream ois = new ObjectInputStream(bistream);

            TestData value = (TestData) ois.readObject();

            System.out.println("TEST ID"+" ==> "+value.getId());
            System.out.println("TEST NAME"+" ==> "+value.getName());
            System.out.println("TEST LENGTH"+" ==> "+value.getLength());

        }
        //ms.close();
    }
}
