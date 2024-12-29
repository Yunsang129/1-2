package end;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class borrowBook {
    public static void main(String[] args) {
        Map<String, String> borrowBookMap = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=== 도서관 대여 관리 시스템 ===");
            System.out.println("1. 책 대여");
            System.out.println("2. 책 반납");
            System.out.println("3. 대여 목록 조회");
            System.out.println("4. 종료");
            System.out.printf("선택: ");
            int number = scanner.nextInt();
            //int라서 다른 문자들이 입력되었을 때 오류를 일으킬 수 있기 때문에 String으로 했어야..
            scanner.nextLine();
            if (number == 1) {
                System.out.print("책 제목: ");
                String bookName = scanner.nextLine();
                System.out.print("학생 이름: ");
                String studentName = scanner.nextLine();
                if (borrowBookMap.containsKey(bookName)) {
                    System.out.println("이미 대여 중입니다.");
                }
                else{
                    borrowBookMap.put(bookName, studentName);
                    System.out.println("대여가 완료되었습니다.");
                }
            }
            else if (number == 2) {
                System.out.print("반납할 책 제목: ");
                String bookName = scanner.nextLine();
                if(borrowBookMap.containsKey(bookName)) {
                    borrowBookMap.remove(bookName);
                    System.out.println("반납이 완료되었습니다.");
                }
                else{
                    System.out.println("존재하지 않는 책입니다.");
                }

            }
            else if (number == 3) {
                System.out.println("대여 목록:");
                for(String bookName : borrowBookMap.keySet()) {
                    System.out.println("- " + bookName + ": " + borrowBookMap.get(bookName));
                }
            }
            else if (number == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else{
                System.out.println("선택지에 없는 번호입니다. 처음으로 돌아갑니다.");
            }
        }
    }
}