import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bettychang on 12/31/17.
 */
public class BoardMouseListener implements MouseListener {

    private Board b;

    public BoardMouseListener(Board b) {
        super();
        this.b = b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        for (Piece p : b.pieces()) {
            if (p.inBounds(x, y)) {
                b.toggleSelect(p);
                break;
            }
        }

//        b.takeTurn();
        b.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
}
