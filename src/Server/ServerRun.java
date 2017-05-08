package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRun {

    static final int PORT = 51515;
    final String IP = "localhost";
    static int maxConnections = 2;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket;

            while(i++ < maxConnections) {
                socket = serverSocket.accept();
                Server connection = new Server(socket);

                Thread t = new Thread(connection);
                t.start();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
class Server implements Runnable {

    private Socket socket;

    DataInputStream inFromClient;
    DataOutputStream outToClient;

    public Server(Socket socket) throws IOException {
        this.socket = socket;
        inFromClient = new DataInputStream(socket.getInputStream());
        outToClient = new DataOutputStream(socket.getOutputStream());
    }

    public void run() throws IOException {
        outToClient.writeBytes("AB");
    }

}

