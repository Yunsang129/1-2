package week13;
import javax.swing.*;
public class JOptionPaneExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JButton showMessageButton = new JButton("Show Message Dialog");
        showMessageButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "This is a message dialog!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        frame.add(showMessageButton);
        frame.setVisible(true);
    }
}