import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        MulticastSocket ms=new MulticastSocket(); //Multicast용 우체통.
        while (true) {
            TestData testData = new TestData();
            testData.setId("1234");
            testData.setName("testName");
            testData.setLength(5);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream (bos);
            out.writeObject(testData);
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
}
