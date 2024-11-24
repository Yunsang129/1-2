package week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousClassListener extends JFrame {

    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨테이너 설정
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 버튼 생성 및 리스너 등록
        JButton btn = new JButton("Action");
        c.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                if (b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");

                // 프레임 타이틀에 버튼 문자열 출력
                setTitle(b.getText());
            }
        });

        // 프레임 설정
        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnonymousClassListener();
    }
}
