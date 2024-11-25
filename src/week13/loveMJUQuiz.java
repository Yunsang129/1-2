package week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loveMJUQuiz extends JFrame {
    private JLabel MJU = new JLabel("Love MJU");

    public loveMJUQuiz() {
        Container c = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.addMouseListener(new labelLocation());
        c.addKeyListener(new labelReverse());

        c.setLayout(null);
        MJU.setSize(100, 20);
        MJU.setLocation(50, 50);
        c.add(MJU);
        setSize(400, 400);
        setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    class labelLocation extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            MJU.setLocation(x, y);
        }
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);
                Component c = (Component) e.getSource();
                c.setBackground(new Color(r, g, b));
            }
        }
    }

    class labelReverse extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int x = e.getKeyCode();

            if (x == KeyEvent.VK_LEFT) {
                if (MJU.getText().equals("Love MJU"))
                    MJU.setText("UJM evoL");
                else
                    MJU.setText("Love MJU");
            }
        }
    }

    public static void main(String[] args) {
        new loveMJUQuiz();
    }
}
