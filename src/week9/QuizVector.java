package week9;

import java.util.Scanner;
import java.util.Vector;

public class QuizVector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.print("강수량 입력 (0입력시 종료)>> ");
            int n = sc.nextInt();
            if (n == 0)
                break;
            else {
                v.add(n);

                for (int i = 0; i < v.size(); i++) {
                    System.out.print(v.get(i) + " ");
                }
                System.out.println();
                System.out.print("현재 평균: ");
                for (int j = 0; j < v.size(); j++) {
                    sum += v.get(j);
                }
                System.out.println(sum / v.size());
            }
        }
    }
}