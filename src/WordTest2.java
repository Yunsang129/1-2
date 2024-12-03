import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Word {
    String engWord;
    String example;

    public Word(String engWord, String example) {
        this.engWord = engWord;
        this.example = example;
    }

    public String getWord() {
        return engWord;
    }

    public String getEx() {
        return example;
    }
}

public class WordTest2 {
    private static Vector<Word> wList = new Vector<>();
    private static Set<Integer> usedIndices = new HashSet<>();
    private static int totalWords = 0;
    private static int remainingWords;

    public static void main(String[] args) {
        // 단어 목록 추가
        wList.add(new Word("capacity", "ability to do something"));
        wList.add(new Word("decline", "to gradually become less"));
        wList.add(new Word("disposal", "the act or means of getting rid of something"));
        wList.add(new Word("eliminate", "to remove (something that is not wanted or needed): to get rid of (something)"));
        wList.add(new Word("equivalent", "having the same amount, value, purpose, qualities, etc"));
        wList.add(new Word("guarantee", "to promise that something will be done or will happen"));
        wList.add(new Word("protest", "a formal and solemn declaration of objection"));
        wList.add(new Word("steep", "going very quickly from low to high or from high to low"));
        wList.add(new Word("substitute", "a thing or person that is used instead of another thing or person"));
        wList.add(new Word("utilize", "to use something in an effective way"));
        wList.add(new Word("conscious", "intentionally conceived"));
        wList.add(new Word("emotion", "a strong human feeling"));
        wList.add(new Word("flexible", "able to change or be changed easily according to the situation"));
        wList.add(new Word("function", "to work in the correct or intended way"));
        wList.add(new Word("perspective", "a particular way of considering something"));
            wList.add(new Word("reinforce", "to make something stronger"));
        wList.add(new Word("structure", "something that has been built"));
        wList.add(new Word("transform", "to change completely the appearance or character of something or someone"));
        wList.add(new Word("vast", "very great in size, amount, or extent"));
        wList.add(new Word("welfare", "physical and mental health and happiness"));
        wList.add(new Word("appreciate", "to recognize or understand that something is valuable or important"));
        wList.add(new Word("classic",   "having a high quality or standard against which other things are judged"));
        wList.add(new Word("creativity", "the ability to use your imagination to produce new ideas"));
        wList.add(new Word("innovative", "using new methods or ideas"));
        wList.add(new Word("purchase", "to buy something"));
        wList.add(new Word("recovery", "to get back something lost"));
        wList.add(new Word("resist", "to refuse to accept or be changed by something"));
        wList.add(new Word("sensible", "acting on good judgment and practical ideas"));
        wList.add(new Word("sensitive", "easily influenced, changed or damaged"));
        wList.add(new Word("wander", "to walk around slowly in a relaxed way or without any clear purpose or direction"));

        totalWords = wList.size();
        remainingWords = totalWords;

        JFrame frame = new JFrame("Word Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel("이 단어는?");
        JLabel exampleLabel = new JLabel("");
        JTextField answerField = new JTextField();
        JButton submitButton = new JButton("확인");

        // 크기 및 위치 설정
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        exampleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        answerField.setMaximumSize(new Dimension(200, 25));
        answerField.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setMaximumSize(new Dimension(200, 30));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 패널에 추가
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // 상단 여백
        panel.add(questionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5))); // 간격
        panel.add(exampleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // 간격
        panel.add(answerField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // 간격
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);

        playGame(questionLabel, exampleLabel, answerField, submitButton);
    }

    private static void playGame(JLabel questionLabel, JLabel exampleLabel, JTextField answerField, JButton submitButton) {
        Random random = new Random();

        // 현재 인덱스 설정
        int[] currentIndex = {getNextIndex(random)};
        questionLabel.setText("이 단어는?");
        exampleLabel.setText("예문: " + wList.get(currentIndex[0]).getEx() + " (앞 글자는: " + wList.get(currentIndex[0]).getWord().charAt(0) + ")");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (remainingWords == 0) {
                    questionLabel.setText("게임 종료! 모든 단어를 다 했습니다.");
                    exampleLabel.setText("");
                    answerField.setEnabled(false);
                    submitButton.setEnabled(false);
                    return;
                }

                String userAnswer = answerField.getText().trim();
                Word currentWord = wList.get(currentIndex[0]);

                if (userAnswer.equals("그만")) {
                    questionLabel.setText("게임 종료.");
                    exampleLabel.setText("");
                    answerField.setEnabled(false);
                    submitButton.setEnabled(false);
                    return;
                }

                if (userAnswer.equalsIgnoreCase(currentWord.getWord())) {
                    JOptionPane.showMessageDialog(null, "정답입니다!");
                } else {
                    JOptionPane.showMessageDialog(null, "오답입니다! 정답은: " + currentWord.getWord() + ".");
                }

                remainingWords--;

                if (remainingWords > 0) {
                    currentIndex[0] = getNextIndex(random);
                    questionLabel.setText("이 단어는?");
                    exampleLabel.setText("예문: " + wList.get(currentIndex[0]).getEx() + " (앞 글자는: " + wList.get(currentIndex[0]).getWord().charAt(0) + ")");
                    answerField.setText("");
                    answerField.setEnabled(true); // 텍스트 필드를 항상 활성화 확인 버튼을 누르면 다시 돌아가지 못하는 오류 고침
                } else {
                    questionLabel.setText("게임 종료! 모든 단어를 다 했습니다.");
                    exampleLabel.setText("");
                    answerField.setEnabled(false);
                    submitButton.setEnabled(false);
                }
            }
        });

        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.doClick();
            }
        });
    }

    private static int getNextIndex(Random random) {
        int randomIndex = random.nextInt(wList.size());
        while (usedIndices.contains(randomIndex)) {
            randomIndex = random.nextInt(wList.size());
        }
        usedIndices.add(randomIndex);
        return randomIndex;
    }
}
