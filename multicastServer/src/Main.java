import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        System.out.println("Hello World!");
        new UdpServer().start();
    }
}

