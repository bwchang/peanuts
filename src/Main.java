/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board b = new Board();
        f.add(b);

        f.setVisible(true);//making the frame visible
    }
}
