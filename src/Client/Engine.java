package Client;

import java.io.*;
import java.net.Socket;

import static Client.Engine.*;

public class Engine {

    static DataOutputStream dataOutputStream;
    static DataInputStream dataInputStream;

    public static Card[] flop;

    public static Card turn;
    public static Card river;

    static GUI frame;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 5909);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        frame = new GUI(1200, 800, "Hej");
        Connection connection = new Connection();
        connection.start();
    }

}
class Connection extends Thread {

    public Connection() throws IOException {
        while(true) {
            String wholeString = dataInputStream.readUTF();
            String[] splitString = wholeString.split("@");

            switch(splitString[0]) {

                case "holecards":
                    Card[] holeCardArray = new Card[2];
                    holeCardArray[0] = new Card(splitString[1], splitString[2]);
                    holeCardArray[1] = new Card(splitString[3], splitString[4]);
                    Player.holeCards = holeCardArray;
                    frame.holeCardsDealt = true;
                    break;

                case "flopcards":
                    Card[] flopArray = new Card[3];
                    flopArray[0] = new Card(splitString[1], splitString[2]);
                    flopArray[1] = new Card(splitString[3], splitString[4]);
                    flopArray[2] = new Card(splitString[5], splitString[6]);
                    frame.flopDealt = true;
                    flop = flopArray;
                    break;

                case "turncard":
                    Card turnCard = new Card(splitString[1], splitString[2]);
                    frame.turnDealt = true;
                    turn = turnCard;
                    break;

                case "rivercard":
                    Card riverCard = new Card(splitString[1], splitString[2]);
                    frame.riverDealt = true;
                    river = riverCard;
                    break;
            }

            frame.repaint();
            frame.validate();

        }
    }
}
