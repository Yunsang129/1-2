package MyCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
class MyCalendar extends JFrame {
    //캘린더 객체 생성
    Calendar calendar = Calendar.getInstance();

    JLabel monthLabel = new JLabel("", JLabel.CENTER);

    JLabel yearLabel = new JLabel("", JLabel.CENTER);

    //날짜를 표시하는 패널을 생성
    JPanel datePanel = new JPanel();

    //메모를 저장할 해시맵 생성
    Map<String, String> memoMap = new HashMap<>();

    //메모필드 생성
    JTextField memoField;

    //메모 할 날짜를 선택하는 콤보박스들을 생성
    JComboBox<String> monthComboBox;
    JComboBox<String> dayComboBox;
    JComboBox<String> yearComboBox;

    //일 버튼을 클릭시 며칠인지 받아오는 변수
    String clickedDateButton;


    public MyCalendar() {
        //캘린더를 2024년 11월 1일을 기준으로 설정
        calendar.set(2024, 11 - 1, 1);

        setTitle("MyCalendar");                       //창의 이름 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 완전하게 종료하도록 하는 코드

        // 탑 패널 생성
        JPanel topPanel = new JPanel();


        //버튼 객체 생성 및 달 변경 기능 추가
        JButton previousButton = new JButton("<");
        previousButton.addActionListener(new changeMonth(-1));
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(new changeMonth(1));

        // 탑 패널에 버튼과 라벨 추가
        topPanel.add(previousButton);
        topPanel.add(yearLabel);
        topPanel.add(new JLabel("년"));
        topPanel.add(monthLabel);
        topPanel.add(new JLabel("월"));
        topPanel.add(nextButton);

        //가운데 패널 생성
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());

        //요일 패널 생성
        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(0, 7));

        //요일 배열 생성 후 라벨로 패널에 추가
        String[] day = {"일", "월", "화", "수", "목", "금", "토"};
        for (String d : day) {
            JLabel dayLabel = new JLabel(d, JLabel.CENTER);
            dayPanel.add(dayLabel);
        }

        //날짜를 표시하는 패널 생성
        datePanel.setLayout(new GridLayout(0, 7, 8, 8));

        //몇 월 달인지 판단하고 이에 따라 일 패널을 채우는 메서드
        setMonth();

        //미들 패널에 요일 패널과 일 패널을 추가
        middlePanel.add(dayPanel, BorderLayout.NORTH);
        middlePanel.add(datePanel, BorderLayout.CENTER);


        //아래 패널 생성
        JPanel bottomPanel = new JPanel();

        //날을 선택하는 패널을 만들기
        JPanel chooseDatePanel = new JPanel();
        chooseDatePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        //콤보박스에 들어갈 숫자들을 채우기
        yearComboBox = new JComboBox<>();
        for (int i = 1970; i <= 2030; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        monthComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});

        dayComboBox = new JComboBox<>();

        //1월 기준으로 처음에 채워두기
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }

        //month 콤보박스에 따라서 day콤보박스의 원소 개수를 조정
        monthComboBox.addActionListener(e -> {
            int selectedYear = monthComboBox.getSelectedIndex();
            int selectedMonth = yearComboBox.getSelectedIndex();
            Calendar cal = Calendar.getInstance();
            cal.set(selectedYear, selectedMonth - 1, 1);
            int maxDayInComboBox = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

            dayComboBox.removeAllItems();
            for (int i = 1; i <= maxDayInComboBox; i++) {
                dayComboBox.addItem(String.valueOf(i));
            }
        });

        //날을 선택하는 패널에 요소들을 추가하기
        chooseDatePanel.add(yearComboBox);
        chooseDatePanel.add(new JLabel("년"));
        chooseDatePanel.add(monthComboBox);
        chooseDatePanel.add(new JLabel("월"));
        chooseDatePanel.add(dayComboBox);
        chooseDatePanel.add(new JLabel("일"));

        //메모란 패널을 만들기
        JPanel memoPanel = new JPanel();
        memoPanel.setLayout(new FlowLayout());

        //메모라는 글자를 레이블로 만들고, 텍스트필드를 만들어 메모패널에 추가하기
        memoPanel.add(new JLabel("메모: "));
        memoField = new JTextField("", 30);
        memoPanel.add(memoField);

        JButton registerButton = new JButton("Register");
        registerButton.setText("등록");
        registerButton.addActionListener(new memoDate());


        //바텀패널에 날짜 선택패널과, 메모패널을 넣고 아래에 등록버튼 넣기
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(chooseDatePanel, BorderLayout.NORTH);
        bottomPanel.add(memoPanel, BorderLayout.CENTER);
        bottomPanel.add(registerButton, BorderLayout.SOUTH);


        //컨테이너 생성 및 모든 패널 추가
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(middlePanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        setSize(500, 650);
        setVisible(true);
    }

    //버튼을 눌러 달이 바뀔 때 마다 사용하는 클래스
    class changeMonth implements ActionListener {

        int d; //달을 어느 방향으로 바꿔야하는 지 알려주는 변수

        public changeMonth(int direction) {
            //버튼에 따라서 +1과 -1을 정해줌
            this.d = direction;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + this.d); // 달을 변수에 따라 바꿔 줌

            // 변화 된 달에 따라 달력을 갱신하는 메서드
            setMonth();
        }
    }

    class memoDate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //각각 필드와 콤보박스에서 메모할 내용, 년, 월, 일을 가져오기
            String memo = memoField.getText();
            String year = yearComboBox.getItemAt(yearComboBox.getSelectedIndex());
            String month = monthComboBox.getItemAt(monthComboBox.getSelectedIndex());
            String date = dayComboBox.getItemAt(dayComboBox.getSelectedIndex());

            //저장하기위해 스트링으로 모두 합침
            String ymd = year + month + date;

            //만약 메모가 비어있다면 메모가 존재하지 않는다는 알림을 띄우고, 빈 메모를 저장하지 않도록하기
            if (memo.equals("")) {
                JOptionPane.showMessageDialog(MyCalendar.this, "저장할 메모가 존재하지 않습니다.",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //해시맵에 메모와 날짜를 넣음
                memoMap.put(ymd, memo);
                memoField.setText("");   //메모칸 초기화
                JOptionPane.showMessageDialog(MyCalendar.this, "메모 저장!\n" + year + "년 " + month + "월 "
                        + date + "일\n" + "메모: " + memo, "Message", JOptionPane.INFORMATION_MESSAGE);
                //달력에 체크표시를 반영하기 위해 다시 한번 setMonth() 메서드를 불러옴
                setMonth();
            }
        }
    }

    class confirmMemo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //년 월을 라벨에서 가져오고, 버튼을 클릭했을 때 그 텍스트를 가져와서 날짜 텍스트를 만들기
            String clickedYMD = yearLabel.getText() + monthLabel.getText() + clickedDateButton;

            // 메모가 있는지 확인하고 존재한다면 출력, 아니라면 없다는 알림을 띄우기
            if (memoMap != null && memoMap.containsKey(clickedYMD)) {
                String memo = memoMap.get(clickedYMD);
                JOptionPane.showMessageDialog(null, "메모:\n" + memo, "메모 확인", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "해당 날짜에 메모가 없습니다.", "메모 없음", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //실행
    public static void main(String[] args) {
        new MyCalendar();
    }

    //달을 갱신하는 메서드
    private void setMonth() {
        //그 달의 총 일 수, 무슨 요일부터 1일인지, 몇 월 달인지를 불러온다.
        int maxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);


        //불러온 정보를 기반으로 텍스트를 설정한다
        yearLabel.setText(String.valueOf(year));
        monthLabel.setText(String.valueOf(month + 1));

        // 기존 일 수 패널을 초기화
        datePanel.removeAll();

        //무슨 요일부터 1일인지 알아낸 정보를 기반으로 그 이전 날들을 공백으로 채우기
        for (int start_day = 1; start_day < startDayOfWeek; start_day++) {
            datePanel.add(new JLabel(" "));
        }

        //이후 그 달의 최대 요일까지 숫자를 넣은 라벨로 채우기
        for (int date = 1; date <= maxDate; date++) {
            JButton dateButton = new JButton("");


            String buttonText = String.valueOf(date);
            if (memoMap.containsKey(String.valueOf(year) + String.valueOf(month + 1) + String.valueOf(date))) {
                buttonText += " ✓";
            }
            dateButton.setText(buttonText);

            //date를 가져오기 위해서 dateButton을 눌렀을 때 숫자를 가져오는 이벤트와 동시에 메모확인을 호출함
            dateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //체크표시가 있을 때, 숫자만을 가져오기 위해 공백을 기준으로 나눈 뒤 첫번째 원소를 할당
                    clickedDateButton = (((JButton) e.getSource()).getText()).split(" ")[0];

                    // 메모 확인 호출
                    new confirmMemo().actionPerformed(e);
                }
            });
            //위에서 만든 데이터 버튼들을 패널에 추가하기
            datePanel.add(dateButton);
        }
        datePanel.revalidate(); // 레이아웃 재배치 << 달이 바뀔 때 마다 레이아웃도 바뀌어야
        datePanel.repaint();    // 화면 다시 그리기 << 기존 데이터 날리기 새로고침
    }
}
