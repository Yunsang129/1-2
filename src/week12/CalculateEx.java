package week12;
import javax.swing.*;
import java.awt.*;

public class CalculateEx extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("계산기 프레임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // 전체 레이아웃 설정
        frame.setLayout(new BorderLayout());

        // 입력 패널 (JTextField와 JLabel)
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel inputLabel = new JLabel("수식 입력:");
        JTextField inputField = new JTextField();
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "계산", "+", "-", "x", "/" };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);

            if (i >= 12) {  
                button.setBackground(Color.LIGHT_GRAY);
            }
            buttonPanel.add(button);
        }

        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("계산 결과");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultPanel.add(resultLabel, BorderLayout.WEST);
        resultPanel.add(resultField, BorderLayout.CENTER);

        // 프레임에 패널 추가
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        // 프레임 표시
        frame.setVisible(true);
    }
}

