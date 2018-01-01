/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board extends JPanel {

    int whoseTurn;
    ArrayList<Piece> onBoard;
    ArrayList<Piece> selected;

    public Board() {
        this.whoseTurn = 0;
        onBoard = new ArrayList<>();
        onBoard.addAll(Arrays.asList(Piece.values()));
        selected = new ArrayList<>();
        addMouseListener(new BoardMouseListener(this));
        setKeyBindings();
    }

    public ArrayList<Piece> pieces() {
        return onBoard;
    }

    public void takeTurn() {
        whoseTurn = 1 - whoseTurn;
    }

    public void toggleSelect(Piece p) {
        if (selected.contains(p)) {
            selected.remove(p);
        } else {
            selected.add(p);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (whoseTurn == 0) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.RED);
        }

        for (Piece p : onBoard) {
            g.fillRect(p.x, p.y, Piece.SIZE, Piece.SIZE);
        }

        g.setColor(Color.BLUE);

        for (Piece p : selected) {
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
