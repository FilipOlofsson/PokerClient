package Client;

public class Player {

    int money = 20000;

    static Card[] holeCards;

    public Player(int money) {
        this.money = money;

    }

    public void giveCards(Card[] Cards) {
        holeCards = Cards;
    }

    public void getRanking() {
        /*
        Ska fixas
         */
    }

}
