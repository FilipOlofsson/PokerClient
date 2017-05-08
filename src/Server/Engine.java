package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Engine extends Thread {
    BufferedReader inFromUser;
    BufferedReader inFromServer;

    Socket socket;

    DataOutputStream outToServer;

    public Engine(int PORT, String IP) throws IOException {
        socket = new Socket(IP, PORT);
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToServer = new DataOutputStream(socket.getOutputStream());
        this.start();
    }

    public void run() {
        while(true) {
            try {
                System.out.println(inFromServer.readLine());
            } catch (Exception e) {

            }
        }
    }

    public void close() throws IOException {
        socket.close();
    }

    public void send(String Message) throws IOException {
        outToServer.writeBytes(Message + "\n");
        outToServer.flush();
    }

    public void giveCardsToPlayer() {

    }

}
