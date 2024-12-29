import java.util.Scanner;

public class onlyplus {
    public static void main(String[] args) {
        int num;
        int sum = 0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.print("양의 정수를 입력하세요: ");
            num = sc.nextInt();
            if(num % 2 ==0){
                sum += num;
            }
        }while(num >= 0);
        System.out.println("입력한 양의 정수 중에서 짝수의 합은 " + sum);
    }
}
