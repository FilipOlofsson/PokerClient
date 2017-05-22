package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Engine extends Thread {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(5909);
        System.out.println("Waiting for connections...");

        Connection firstClient = new Connection(serverSocket.accept());
        System.out.println("One client is connected.");

        Connection secondClient = new Connection(serverSocket.accept());
        System.out.println("Second client is connected.");
        firstClient.start();
        secondClient.start();

        Deck deck = new Deck();

        firstClient.sendHoleCards(deck.getHoleCards());
        secondClient.sendHoleCards(deck.getHoleCards());
        Thread.sleep(3000);

        Card[] flop = deck.getFlop();

        firstClient.sendFlop(flop);
        secondClient.sendFlop(flop);
        Thread.sleep(3000);

        Card turn = deck.getTurn();

        firstClient.sendTurn(turn);
        secondClient.sendTurn(turn);
        Thread.sleep(3000);

        Card river = deck.getRiver();

        firstClient.sendRiver(river);
        secondClient.sendRiver(river);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}

