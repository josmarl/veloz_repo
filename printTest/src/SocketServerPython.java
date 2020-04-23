
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerPython {

    ServerSocket serverSocket;
    Socket connection = null;

    public SocketServerPython() {
    }

    void client() throws IOException {
        serverSocket = new ServerSocket(5000);
        try {
            connection = serverSocket.accept();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String message = br1.readLine();
            String[] messages = message.split("_");
            String lines = "";
            for (String msg : messages) {
                lines += msg + "\n";
            }
            System.out.println(lines);
            PrintServiceUtil.printGeneric(lines);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String args[]) throws IOException {
        SocketServerPython server = new SocketServerPython();
        while (true) {
            server.client();
        }
    }
}
