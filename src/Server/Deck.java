package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    List<Card> availableCards = new ArrayList();

    Random rnd = new Random();

    String[] Values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    String[] Colors = {"diamond", "heart", "spade", "club"};

    public Deck() {
        for(int i = 0; i < Values.length; i++) {
            for(int j = 0; j < Colors.length; j++) {
                availableCards.add(new Card(Values[i], Colors[j]));
            }
        }
    }

    public int getCardsLeft() {
        return availableCards.size();
    }

    public Card getRandom() {
        int random = rnd.nextInt(availableCards.size());
        Card toReturn = availableCards.get(random);
        availableCards.remove(toReturn);
        return toReturn;
    }

}
