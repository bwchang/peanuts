/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel {

    int whoseTurn;

    public Board() {
        this.whoseTurn = 0;
        addMouseListener(new BoardListener(this));
        setKeyBindings();
    }

    public void takeTurn() {
        whoseTurn = 1 - whoseTurn;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (whoseTurn == 0) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.RED);
        }

        for (Piece p : Piece.values()) {
            g.fillRect(p.x, p.y, Piece.SIZE, Piece.SIZE);
        }
    }

    private void setKeyBindings() {
        ActionMap actionMap = getActionMap();
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);

        String vkSpace = "VK_SPACE";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), vkSpace);

        actionMap.put(vkSpace, new KeyAction(vkSpace));

    }

    private class KeyAction extends AbstractAction {
        public KeyAction(String actionCommand) {
            putValue(ACTION_COMMAND_KEY, actionCommand);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvt) {
            System.out.println(actionEvt.getActionCommand() + " pressed");
        }
    }
}
