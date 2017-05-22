package Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Connection extends Thread {

    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    Socket socket;


    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void Send(int a) throws IOException {
        dataOutputStream.writeInt(a);
    }
    public void Send(String a) throws IOException {
        dataOutputStream.writeChars(a);
    }
    public void sendHoleCards(Card[] a) throws IOException {
        dataOutputStream.writeUTF("holecards" + "@" + a[0].value + "@" + a[0].color + "@" + a[1].value + "@" + a[1].color);
    }
    public void sendFlop(Card[] a) throws IOException {
        dataOutputStream.writeUTF(
                "flopcards" + "@" + a[0].value + "@" + a[0].color + "@" +
                a[1].value + "@" + a[1].color + "@" +
                        a[2].value + "@" + a[2].color);
    }
    public void sendTurn(Card a) throws IOException {
        dataOutputStream.writeUTF("turncard" + "@"+ a.value + "@"+ a.color);
    }
    public void sendRiver(Card a) throws IOException {
        dataOutputStream.writeUTF("rivercard" + "@"+ a.value + "@"+ a.color);
    }
}
class Receiver extends Thread {
    public Receiver() {

    }
}

