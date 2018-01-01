/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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

    private void takeTurn() {
        whoseTurn = 1 - whoseTurn;
    }

    public void toggleSelect(Piece p) {
        if (selected.contains(p)) {
            selected.remove(p);
        } else if (selected.size() < 3) {
            selected.add(p);
            selected.sort(new PieceComparator());
        }
    }

    private void removePieces() {
        if (isConnected(selected)) {
            onBoard.removeAll(selected);
            selected.clear();
            takeTurn();
        }
    }

    private boolean isConnected(ArrayList<Piece> pieces) {
        if (pieces.size() == 0) {
            return false;
        } else if (pieces.size() == 1) {
            return true;
        } else if (pieces.size() == 2) {
            return areTwoConnected(pieces.get(0), pieces.get(1));
        } else {
            return areThreeConnected(pieces.get(0), pieces.get(1), pieces.get(2));
        }
    }

    private boolean areTwoConnected(Piece first, Piece second) {
        int firstID = first.id;
        int secondID = second.id;
        if (!(firstID == 1 || firstID == 3 || firstID == 6 || firstID == 10 || firstID == 15)) {
            if (secondID - firstID == 1) {
                return true;
            }
        }
        int level = first.level;
        if (secondID - firstID == level || secondID - firstID == level + 1) {
            return true;
        }
        return false;
    }

    private boolean areThreeConnected(Piece first, Piece second, Piece third) {
        int firstID = first.id;
        int secondID = second.id;
        int thirdID = third.id;
        if (!(firstID == 1 || firstID == 3 || firstID == 6 || firstID == 10 || firstID == 15 ||
                firstID == 2 || firstID == 5 || firstID == 9 || firstID == 14)) {
            if (secondID - firstID == 1 && thirdID - secondID == 1) {
                return true;
            }
        }
        return false;
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
            removePieces();
            repaint();
        }
    }

    class PieceComparator implements Comparator<Piece> {

        @Override
        public int compare(Piece o1, Piece o2) {
            return o1.id - o2.id;
        }
    }
}
