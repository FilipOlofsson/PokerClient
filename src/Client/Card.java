package Client;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card implements java.io.Serializable {

    String value = null;
    String color = null;

    int width = 120;
    int height = 180;

    transient BufferedImage image = null;

    public Card(String value, String color) throws IOException {
        this.value = value;
        this.color = color;
        image = ImageIO.read(new File("Images\\" + value + "_of_" + color + "s.png"));
    }

    public String toString() {
        return value + color;
    }


}
