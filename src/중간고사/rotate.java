import java.util.Scanner;

public class rotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 크기: ");
        int n = sc.nextInt();
        int intArray[] = new int[n];
        System.out.println("정수 배열: ");
        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }
        System.out.print("오른쪽으로 회전할 횟수: ");
        int num5 = sc.nextInt();
        int rotateArray[] = new int[n];
        for(int i = 0; i < n; i ++){
            try{
                rotateArray[i+num5] = intArray[i];
            }catch(ArrayIndexOutOfBoundsException e){
                rotateArray[i + num5 - n] =  intArray[i];
            }
        }
        System.out.print("회전된 배열: ");
        for(int i = 0; i < n; i++){
            System.out.print(rotateArray[i]+" ");
        }
    }
}
