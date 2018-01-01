/**
 * Created by bettychang on 12/31/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static final int FRAMEWIDTH = 500;
    public static final int FRAMEHEIGHT = 500;

    public static void main(String[] args) {
        Board b = new Board();

        JFrame f=new JFrame();
        f.setSize(FRAMEWIDTH,FRAMEHEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(b);
        f.setVisible(true);

    }
}
