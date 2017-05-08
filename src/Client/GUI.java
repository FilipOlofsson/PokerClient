package Client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends Canvas {
    JFrame frame;

    int width = 0;
    int height = 0;

    String title;

    File background = new File("Images\\background.jpeg");
    BufferedImage backgroundImage;

    boolean flopDealt = false;
    boolean holeCardsDealt = false;
    boolean turnDealt = false;
    boolean riverDealt = false;

    Card holeCard1;
    Card holeCard2;
    Card flopCard1;
    Card flopCard2;
    Card flopCard3;
    Card turnCard;
    Card riverCard;

    public GUI(int width, int height, String title) throws IOException {
        this.width = width;
        this.height = height;
        this.title = title;
        backgroundImage = ImageIO.read(background);
        dealHole(new Card("ace", "diamond"), new Card("king", "diamond"));
        dealFlop(new Card("queen", "diamond"), new Card("jack", "diamond"), new Card("10", "diamond"));
        dealTurn(new Card("ace", "spade"));
        dealRiver(new Card("ace", "heart"));
        init();
    }

    public void dealHole(Card kort1, Card kort2) {
        holeCardsDealt = true;
        this.holeCard1 = kort1;
        this.holeCard2 = kort2;
    }

    public void dealFlop(Card flop1, Card flop2, Card flop3) {
        flopDealt = true;
        this.flopCard1 = flop1;
        this.flopCard2 = flop2;
        this.flopCard3 = flop3;
    }

    public void dealTurn(Card turnCard) {
        turnDealt = true;
        this.turnCard = turnCard;
    }

    public void dealRiver(Card riverCard) {
        riverDealt = true;
        this.riverCard = riverCard;
    }

    public void init() {
        Dimension dim = new Dimension(this.width, this.height);
        setPreferredSize(dim);
        frame = new JFrame(title);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, width, height, null);
        if (holeCardsDealt) {
            g.drawImage(holeCard1.image,0, height - holeCard1.height, holeCard1.width, holeCard1.height, null);
            g.drawImage(holeCard2.image, holeCard1.width, height - holeCard2.height, holeCard2.width, holeCard2.height, null);
        }
        if (flopDealt) {
            g.drawImage(flopCard1.image, (width/2) - (flopCard1.width*3 - flopCard1.width/2), height/2 - flopCard1.height/2, flopCard1.width, flopCard1.height, null);
            g.drawImage(flopCard2.image, (width/2) - (flopCard2.width*2 - flopCard2.width/2), height/2 - flopCard2.height/2, flopCard2.width, flopCard2.height, null);
            g.drawImage(flopCard3.image, (width/2) - (flopCard3.width - flopCard3.width/2), height/2 - flopCard3.height/2, flopCard3.width, flopCard3.height, null);
        }
        if (turnDealt) {
            g.drawImage(turnCard.image, (width/2) + (turnCard.width - turnCard.width/2), height/2 - turnCard.height/2, turnCard.width, turnCard.height, null);
        }
        if(riverDealt) {
            g.drawImage(riverCard.image, (width/2) + (riverCard.width*2 - riverCard.width/2), height/2 - riverCard.height/2, riverCard.width, riverCard.height, null);
        }
    }
}
