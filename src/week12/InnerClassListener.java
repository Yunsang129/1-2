package week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame {

    // 생성자
    InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨테이너 설정
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 버튼 생성 및 리스너 등록
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        // 프레임 설정
        setSize(350, 150);
        setVisible(true);
    }

    // 내부 클래스: ActionListener 구현
    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");

            // 프레임 타이틀에 버튼 문자열 출력
            InnerClassListener.this.setTitle(b.getText());
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        new InnerClassListener();
    }
}

