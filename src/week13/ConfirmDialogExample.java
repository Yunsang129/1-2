package week13;

import javax.swing.*;
public class ConfirmDialogExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JButton showConfirmDialogButton = new JButton("Show Confirm Dialog");
        showConfirmDialogButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(frame, "Do you want to continue?",
                    "Confirm Dialog", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "You chose YES!", "Response",
                        JOptionPane.INFORMATION_MESSAGE);


            } else {
                JOptionPane.showMessageDialog(frame, "You chose NO!", "Response",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(showConfirmDialogButton);
        frame.setVisible(true);
    }
}