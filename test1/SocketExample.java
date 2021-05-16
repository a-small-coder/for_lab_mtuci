import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketExample {
    public static void main(String[] args) throws IOException, UnknownHostException{
        try(Socket socket = new Socket()){
            socket.connect( new InetSocketAddress("129.6.15.28", 13), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
