package week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlyingTextEx extends JFrame {
    private final int FLYING_UNIT = 10;
    private JLabel la = new JLabel("HELLO");

    public FlyingTextEx() {
        setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null); // 절대 위치 배치
        c.addKeyListener(new MyKeyListener());

        la.setLocation(50, 50); // 라벨 위치 초기화
        la.setSize(100, 20); // 라벨 크기 설정
        c.add(la);

        setSize(300, 300); // 프레임 크기 설정
        setVisible(true);

        c.setFocusable(true); // 컨테이너에 포커스 설정
        c.requestFocus();

        // 마우스 클릭 시 포커스 처리
        c.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Component com = (Component) e.getSource();
                com.setFocusable(true);
                com.requestFocus();
            }
        });
    }

    // 메인 메서드
    public static void main(String[] args) {
        new FlyingTextEx();
    }

    // 키 입력 처리 클래스
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP: // 위쪽 화살표 키
                    la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
                    break;
                case KeyEvent.VK_DOWN: // 아래쪽 화살표 키
                    la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
                    break;
                case KeyEvent.VK_LEFT: // 왼쪽 화살표 키
                    la.setLocation(la.getX() - FLYING_UNIT, la.getY());
                    break;
                case KeyEvent.VK_RIGHT: // 오른쪽 화살표 키
                    la.setLocation(la.getX() + FLYING_UNIT, la.getY());
                    break;
            }
        }
    }
}
