package week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class loginApplication extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private Map<String, String> userMap;
    public loginApplication() {

        setTitle(" ");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        userMap = new HashMap<String, String>();
        userMap.put("Kim", "1234");
        userMap.put("Lee", "4321");
        userMap.put("Park", "1234");

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        placeComponents(panel);

        setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel passwordLabel = new JLabel("Password");
        JLabel usernameLabel = new JLabel("User");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        passwordLabel.setLocation(10, 50);
        usernameLabel.setLocation(10, 20);
        passwordLabel.setSize(80,25);
        usernameLabel.setSize(80,25);
        loginButton.setSize(80,25);
        loginButton.setLocation(10,80);
        usernameField.setLocation(100, 20);
        usernameField.setSize(165, 25);
        passwordField.setLocation(100, 50);
        passwordField.setSize(165, 25);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        panel.add(loginButton);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
    }
    private void loginUser() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            JOptionPane.showMessageDialog(this, "정상적인 로그인");
            System.out.println("정상적인 로그인");
        } else {
            JOptionPane.showMessageDialog(this, "아이디 혹은 패스워드 오류");
            System.out.println("아이디 혹은 패스워드 오류");
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new loginApplication();
    }
}

