import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(); //Multicast용 우체통.
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Message = ");
            String msg = in.readLine();
            InetAddress ia = InetAddress.getByName("224.0.0.1");
            //Multicast용 IP중에서 임의의 하나를 선택.
            DatagramPacket data = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 28000);
            ms.send(data);
        }
        //ms.close();
    }

}
