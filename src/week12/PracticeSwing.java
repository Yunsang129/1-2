package week12;

import javax.swing.*;
import java.awt.*;

public class PracticeSwing extends JFrame {
    public PracticeSwing() {
        setTitle("BorderLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        // BorderLayout 설정
        c.setLayout(new BorderLayout(7, 7)); // 수평, 수직 간격 7픽셀

        // 버튼 라벨 및 색상 배열
        String[] labels = {"Calculate", "Add", "Sub", "Mul", "Div"};
        Color[] mycolors = {Color.CYAN, Color.RED, Color.GRAY, Color.YELLOW, Color.GREEN};

        // BorderLayout 위치 배열
        String[] positions = {BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST};

        // 버튼 생성 및 배치 반복문
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.setBackground(mycolors[i]);
            c.add(button, positions[i]); // 각 버튼을 해당 위치에 배치
        }

        // 프레임 크기 및 출력 설정
        setSize(300, 200); // 프레임 크기 300×200
        setVisible(true);  // 프레임을 화면에 출력
    }

    public static void main(String[] args) {
        new PracticeSwing();
    }
}
