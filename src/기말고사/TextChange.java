package end;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextChange extends JFrame {
    public TextChange() {
        setTitle("텍스트 변환 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container p = getContentPane();
        setSize(500, 400);
        p.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());

        JLabel l1 = new JLabel("입력:");
        p1.add(l1, BorderLayout.NORTH);
        JLabel l2 = new JLabel("결과");
        p2.add(l2, BorderLayout.CENTER);
        JTextArea t1 = new JTextArea(5, 5);
        p1.add(t1, BorderLayout.CENTER);

        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(1, 0));
        JTextArea resultText = new JTextArea(5,5);
        resultText.setEditable(false);
        p2.add(resultText, BorderLayout.SOUTH);
        JButton b1 = new JButton("변환");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ct = t1.getText();
                String pt = ct.trim().replace(" ","");
                resultText.setText(pt.toUpperCase());
            }
        });
        JButton b2 = new JButton("초기화");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultText.setText("");
                t1.setText("");
            }
        });

        JButton b3 = new JButton("저장");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memo = resultText.getText();
                try{
                    PrintWriter fileOutPut = new PrintWriter("result.txt");
                    fileOutPut.println(memo);
                    fileOutPut.close();
                    JOptionPane.showMessageDialog(null,"결과가 result.txt에 저장되었습니다.","저장 완료"
                    ,JOptionPane.INFORMATION_MESSAGE);

                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        gridPane.add(b1);
        gridPane.add(b2);
        gridPane.add(b3);
        p1.add(gridPane, BorderLayout.SOUTH);
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextChange();
    }
}
