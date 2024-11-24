package MyCalendar;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
class MyFrame extends JFrame {
    public MyFrame() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 11 - 1 , 1);

        //캘린더에서 달의 시작 요일, 최대 일 수, 현재가 무슨 달 인지를 불러옴
        int maxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);

        setTitle("MyCalendar");                       //창의 이름 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 완전하게 종료하도록 하는 코드

        // 탑 패널 생성
        JPanel topPanel = new JPanel();
        JButton previousButton = new JButton("<");
        JLabel monthLabel = new JLabel(String.valueOf(month + 1) + "월", JLabel.CENTER);
        JButton nextButton = new JButton(">");
        // 탑 패널에 버튼과 라벨 추가
        topPanel.add(previousButton);
        topPanel.add(monthLabel);
        topPanel.add(nextButton);

        //가운데 패널 생성
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());

        //요일 패널 생성
        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(0, 7));

        //요일 배열 생성 후 라벨로 패널에 넣기
        String[] day = {"일", "월", "화", "수", "목", "금","토"};
        for (String d : day) {
            JLabel dayLabel = new JLabel(d, JLabel.CENTER);
            dayPanel.add(dayLabel);
        }

        middlePanel.add(dayPanel, BorderLayout.NORTH);  //가운데 패널에 요일패널 추가

        //일 수 패널 생성
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(0, 7, 8, 8));

        //그 달의 시작 요일 까지 빈 라벨로 채우기
        for (int start_day =1; start_day < startDayOfWeek; start_day++) {
            datePanel.add(new JLabel(" "));
        }

        //이후 그 달의 최대 요일까지 숫자를 넣은 라벨로 채우기
        for (int date = 1; date <= maxDate; date++) {
            JButton dateButton = new JButton(String.valueOf(date));
            datePanel.add(dateButton);
        }
        middlePanel.add(datePanel, BorderLayout.CENTER);


        //아래 패널 생성
        JPanel BottomPanel = new JPanel();
        JPanel chooseDatePanel = new JPanel();

        //날을 선택하는 패널을 만들기
        chooseDatePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //콤보박스로 월과 일을 선택하기 및 라벨로 월, 일 글자 채우기
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12"});
        //int findMaxDay = calendar.getActualMaximum(); 월 선택마다 일 선택 만들기?
        JComboBox<String> dayComboBox = new JComboBox<>();
        for(int i = 1; i <= 31; i++){
            dayComboBox.addItem(String.valueOf(i));
        }
        chooseDatePanel.add(monthComboBox);
        chooseDatePanel.add(new JLabel("월"));
        chooseDatePanel.add(dayComboBox);
        chooseDatePanel.add(new JLabel("일"));

        //메모란 패널을 만들기
        JPanel memoPanel = new JPanel();
        memoPanel.setLayout(new FlowLayout());
        memoPanel.add(new JLabel("메모: "));
        JTextField memo = new JTextField("", 30);
        memoPanel.add(memo);

        //바텀패널에 날짜 선택패널과, 메모패널을 넣고 아래에 등록버튼 넣기
        BottomPanel.setLayout(new BorderLayout());
        BottomPanel.add(chooseDatePanel, BorderLayout.NORTH);
        BottomPanel.add(memoPanel, BorderLayout.CENTER);
        BottomPanel.add(new JButton("등록"), BorderLayout.SOUTH);


        //컨테이너 생성 및 모든 패널 추가
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(middlePanel,BorderLayout.CENTER);
        contentPane.add(BottomPanel, BorderLayout.SOUTH);
        setSize(400, 500);
        setVisible(true);
    }
}

//실행
public class MyCalendar {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
