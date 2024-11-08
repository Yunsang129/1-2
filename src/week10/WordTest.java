package week10;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Math;
class Word{
    String Kor;
    String Eng;

    public Word(String Kor, String Eng) {
        this.Kor = Kor;
        this.Eng = Eng;
    }
    public void setWord(String Kor, String Eng){
        this.Kor = Kor;
        this.Eng = Eng;
    }
    public String getEng(){
        return Eng;
    }
    public String getKor(){
        return Kor;
    }
}
public class WordTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Vector<Word> wList = new Vector<>();
        wList.add(new Word("바나나", "banana"));
        wList.add(new Word("바람", "wind"));
        wList.add(new Word("책상", "desk"));
        wList.add(new Word("의자", "chair"));
        wList.add(new Word("창문", "window"));
        wList.add(new Word("하늘", "sky"));
        wList.add(new Word("나무", "tree"));
        wList.add(new Word("물고기", "fish"));
        wList.add(new Word("자동차", "car"));
        wList.add(new Word("집", "house"));
        wList.add(new Word("학교", "school"));
        wList.add(new Word("컴퓨터", "computer"));
        wList.add(new Word("모자", "hat"));
        wList.add(new Word("옷", "clothes"));
        wList.add(new Word("사람", "person"));
        wList.add(new Word("강아지", "dog"));
        wList.add(new Word("고양이", "cat"));
        wList.add(new Word("책", "book"));
        wList.add(new Word("가방", "bag"));
        wList.add(new Word("전화기", "phone"));
        int n;
        String correctKor;
        String eng;
        String kor;
        while(true) {
            System.out.println("1. 단어 추가\t2. 게임 시작\t3.종료");
            System.out.print("선택: ");
            try {
                n = s.nextInt();
                s.nextLine();
                if(n > 3 || n < 1){
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException e){
                System.out.println("잘못된 값을 입력하셨습니다.");
                continue;
            }
            if (n == 1){
                while(true) {
                    System.out.print("영어 단어 (or type '그만' to stop): ");
                    eng = s.nextLine();
                    if (eng.equals("그만"))
                        break;
                    System.out.print("한국어 뜻: ");
                    kor = s.nextLine();
                    wList.add(new Word(kor, eng));
                    System.out.println("단어 추가 성공!");
                }
            } else if (n == 2) {
                System.out.println("단어 맞추기 게임 시작! 종료를 원하시면 '그만'을 입력하세요.");
                while(true) {
                    int ind = (int) (Math.random() * wList.size());
                    System.out.print("이 단어의 한국어 뜻은 " + wList.get(ind).getEng() + "?");
                    correctKor = s.nextLine();
                    if (correctKor.equals(wList.get(ind).getKor())) {
                        System.out.println("정답!");
                    } else if (correctKor.equals("그만")) {
                        System.out.println("게임 종료.");
                        break;
                    }else{
                        System.out.println("오답! 정답은: " + wList.get(ind).getKor());
                    }

                }
            } else if (n == 3){
                System.out.println("안녕히 가세요!");
                break;
            }
        }
    }
}
