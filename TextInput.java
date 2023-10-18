import javax.swing.*;
import java.awt.*;

public class TextInput extends JTextField {

    public TextInput(int width, int height, int x, int y) {
        super();
        this.setSize(width, height);
        this.setLocation(x, y);
        this.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        this.setOpaque(false);

    }
}
