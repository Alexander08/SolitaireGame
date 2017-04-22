package tests;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PanelTest p = new PanelTest();
        frame.setContentPane(p);
        p.c.flip();
        frame.repaint();
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
