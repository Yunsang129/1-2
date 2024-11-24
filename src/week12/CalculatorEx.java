package week12;

import java.awt.*;
import javax.swing.*;



public class CalculatorEx extends JFrame{

    public CalculatorEx() {
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setLayout(new BorderLayout());

        Container input = new Container();
        input.setLayout(new FlowLayout(FlowLayout.LEFT));
        c.add(input, BorderLayout.NORTH);

        input.add(new JLabel( "수식입력"));
        input.add(new JTextField("",20));

        Container num = new Container();
        c.add(num, BorderLayout.CENTER);
        num.setLayout(new GridLayout(4,4,0,8));
        for(int i = 0; i<10; i++) {
            num.add(new JButton(String.valueOf(i)));
        }
        String[] str = {"CE", "계산", "+", "-", "X", "/"};
        for(int i = 0; i<str.length;i++) {
            num.add(new JButton(str[i]));
        }

        Container output = new Container();
        output.setLayout(new FlowLayout(FlowLayout.LEFT));
        c.add(output, BorderLayout.SOUTH);
        output.add(new JLabel("수식입력"));
        output.add(new JTextField("", 20));




        setSize(350,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new CalculatorEx();
    }

}
