package week11;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SearchWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("텍스트 파일명 입력: ");
        String textFile = sc.nextLine();
        ArrayList<String> wordList = new ArrayList<>();

        try {
            BufferedReader st = new BufferedReader(new FileReader(textFile));
            String line;
            while ((line = st.readLine()) != null) {
                wordList.add(line);
            }
            st.close();

            while (true) {
                System.out.print("검색할 단어: ");
                String word = sc.nextLine();
                if (word.equals("그만")) {
                    break;
                }

                boolean found = false;
                for (String lines : wordList) {
                    if (lines.contains(word)) {
                        System.out.println(wordList.indexOf(lines) + 1 + ": " + lines.trim());
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("단어를 찾을 수 없습니다.");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
