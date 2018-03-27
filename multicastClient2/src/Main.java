import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(28000);
        ms.joinGroup(InetAddress.getByName("224.0.0.1"));
        //Multicast Group에 접속해야 한다.

        while (true)
        {
            byte[] by=new byte[65508];
            DatagramPacket data=new DatagramPacket(by, by.length);
            ms.receive(data);
            InetAddress ia=data.getAddress(); //주소를 얻어냄.
            String str=new String(data.getData()).trim(); //Data를 얻어냄.
            System.out.println(ia.getHostName()+" ==> "+str);
        }
        //ms.close();
    }
}
