package week11;
import java.io.*;
import java.util.Scanner;

public class QuizFileAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫 번째 파일 이름을 입력하세요>>");
        File f1 = new File(scanner.nextLine());
        System.out.print("두 번째 파일 이름을 입력하세요>>");
        File f2 = new File(scanner.nextLine());
        System.out.print("세 번째 파일 이름을 입력하세요>>");
        File f3 = new File(scanner.nextLine());
        try {
            FileReader fr1 = new FileReader(f1);
            FileReader fr2 = new FileReader(f2);
            FileWriter fw = new FileWriter(f3);

            int c;
            char[] buf = new char[1024 * 10];
            while ((c = fr1.read(buf)) != -1) {
                fw.write(buf, 0, c);
            }
            while ((c = fr2.read(buf)) != -1) {
                fw.write(buf, 0, c);
            }

            fr1.close();
            fr2.close();
            fw.close();

            System.out.println("프로젝트 폴더 밑에 " + f3.getName() + "파일에 저장하였습니다.");

        } catch (IOException e) {
            System.out.println("오류발생.");
        }
        scanner.close();
    }
}
