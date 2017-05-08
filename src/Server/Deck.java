package Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    List<Card> availableCards = new ArrayList();

    Random rnd = new Random();

    String[] Values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    String[] Colors = {"diamond", "heart", "spade", "club"};

    public Deck() throws IOException {
        for(int i = 0; i < Values.length; i++) {
            for(int j = 0; j < Colors.length; j++) {
                availableCards.add(new Card(Values[i], Colors[j]));
            }
        }
    }

    public int getCardsLeft() {
        return availableCards.size();
    }

    public Card[] getHoleCards() {
        Card[] holeCards = new Card[2];
        holeCards[0] = getRandom();
        holeCards[1] = getRandom();
        return holeCards;
    }

    public Card[] getFlop() {
        Card[] flopCards = new Card[3];
        flopCards[0] = getRandom();
        flopCards[1] = getRandom();
        flopCards[2] = getRandom();
        return flopCards;
    }

    public Card getTurn() {
        return getRandom();
    }

    public Card getRiver() {
        return getRandom();
    }

    public Card getRandom() {
        int random = rnd.nextInt(availableCards.size());
        Card toReturn = availableCards.get(random);
        availableCards.remove(toReturn);
        return toReturn;
    }

}
