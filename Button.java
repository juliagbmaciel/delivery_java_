import javax.swing.*;
import java.awt.*;



public class Button extends JButton {

    String action;

    public Button(int width, int height, int x, int y, String text) {
        super();
        this.setSize(width, height);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setLocation(x, y);
        this.action = text;
    }



}
