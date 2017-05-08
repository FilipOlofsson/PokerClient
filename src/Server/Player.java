package Server;

public class Player {

    int money;

    Card holeCard1;
    Card holeCard2;

    int Ranking;
    int subRanking;

    public Player(int money) {
        this.money = money;

    }

    public void giveCards(Card card1, Card card2) {
        holeCard1 = card1;
        holeCard2 = card2;
    }

    public void getRanking() {
        /*
        Ska fixas
         */
    }

}
