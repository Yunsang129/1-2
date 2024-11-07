package week10;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[10];

        // 객체 배열 초기화(랜덤값으로)
        for(int i = 0; i < 10; i++) {
            arr[i] = new MyInteger((int)(Math.random() * 100));
        }

        // 정렬 전
        System.out.print("정렬전\n");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }

        // MyInteger 정렬 - 오름차순
        Arrays.sort(arr);

        // 정렬 후
        System.out.print("\n정렬후\n");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }
    }
}

class MyInteger implements Comparable<MyInteger> {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger o) {
        return this.value - o.value; // 나와 매개변수 객체의 차이값으로 비교
    }
}
