/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public Board() {

    }

//    public void drawBoard() {
//        repaint();
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(100, 100, 100, 100);

        System.out.println("hello");
    }
}
