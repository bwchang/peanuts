import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bettychang on 12/31/17.
 */
public class BoardMouseListener implements MouseListener {

    private Board b;

    public BoardMouseListener(Board _b) {
        super();
        b = _b;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x);
        System.out.println(y);
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
