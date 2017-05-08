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


    public GUI(int width, int height, String title) throws IOException {
        this.width = width;
        this.height = height;
        this.title = title;
        backgroundImage = ImageIO.read(background);
        init();
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
            g.drawImage(Player.holeCards[0].image,0, height - Player.holeCards[0].height, Player.holeCards[0].width, Player.holeCards[0].height, null);
            g.drawImage(Player.holeCards[1].image, Player.holeCards[1].width, height - Player.holeCards[1].height, Player.holeCards[1].width, Player.holeCards[1].height, null);
        }
        if (flopDealt) {
            g.drawImage(Engine.flop[0].image, (width/2) - (Engine.flop[0].width*3 - Engine.flop[0].width/2), height/2 - Engine.flop[0].height/2, Engine.flop[0].width, Engine.flop[0].height, null);
            g.drawImage(Engine.flop[1].image, (width/2) - (Engine.flop[1].width*2 - Engine.flop[1].width/2), height/2 - Engine.flop[1].height/2, Engine.flop[1].width, Engine.flop[1].height, null);
            g.drawImage(Engine.flop[2].image, (width/2) - (Engine.flop[2].width - Engine.flop[2].width/2), height/2 - Engine.flop[2].height/2, Engine.flop[2].width, Engine.flop[2].height, null);
        }
        if (turnDealt) {
            g.drawImage(Engine.turn.image, (width/2) + (Engine.turn.width - Engine.turn.width/2), height/2 - Engine.turn.height/2, Engine.turn.width, Engine.turn.height, null);
        }
        if(riverDealt) {
            g.drawImage(Engine.river.image, (width/2) + (Engine.river.width*2 - Engine.river.width/2), height/2 - Engine.river.height/2, Engine.river.width, Engine.river.height, null);
        }
    }
}
