package network.exception.connect;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ConnectTimeOutMain1 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket("192.168.1.250", 45678);
        } catch (SocketException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
