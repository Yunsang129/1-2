package week13;

import javax.swing.*;

public class InputDialogExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton showInputDialogButton = new JButton("Show Input Dialog");
        showInputDialogButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter your name:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
            if (input != null) {
                JOptionPane.showMessageDialog(frame, "You entered: " + input, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(showInputDialogButton);
        frame.setVisible(true);
    }
}