/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel {

    public Board() {
        addMouseListener(new BoardMouseListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(40, 40, 40, 40);

    }
}
