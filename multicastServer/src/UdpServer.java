import java.io.IOException;
import java.net.*;

public class UdpServer extends Thread {
    private DatagramSocket socket;
    private int port =1235;
    private boolean listen = true;

    public UdpServer() throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void run() {
        while (listen) {
            try {
                String test = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde";
                byte[] buffer = new byte[200];
                buffer = test.getBytes();

                InetAddress address = InetAddress.getByName("230.0.0.5");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
                socket.send(packet);

                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

}