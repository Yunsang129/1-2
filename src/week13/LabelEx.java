package week13;

import javax.swing.*; import java.awt.*;
public class LabelEx extends JFrame {
    public LabelEx() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("사랑의열매");
        ImageIcon beauty = new ImageIcon("images/heart.jpg");
        JLabel imageLabel = new JLabel(beauty);
        ImageIcon normalIcon = new ImageIcon("images/phone.gif");
        JLabel label = new JLabel(" 전화하세요",
                normalIcon, SwingConstants.CENTER);
        c.add(textLabel); c.add(imageLabel); c.add(label);
        setSize(400,600); setVisible(true);
    }
    public static void main(String [] args) {
        new LabelEx();
    }
}