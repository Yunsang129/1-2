package week10;
import java.util.*;

public class HashMapQuiz {
    public static void main(String[] args) {
        String name;
        int point;
        Scanner scanner = new Scanner(System.in);
        System.out.println("**포인트 관리 프로그램입니다.**");
        HashMap<String, Integer> list = new HashMap<String, Integer>();

        while (true) {
            System.out.print("이름과 포인트 입력 >> ");
            name = scanner.next();
            if (name.equals("exit")) {
                break;
            }
            point = scanner.nextInt();
            scanner.nextLine();

            if (list.containsKey(name))
                list.put(name, list.get(name) + point);
            else
                list.put(name, point);

            System.out.println("**회원 목록**");
            for (String key : list.keySet()) {
                System.out.print("(" + key + ", " + list.get(key) + ") ");
            }
            System.out.println();
        }
        System.out.println("**골드 회원 목록**");
        for (String key : list.keySet()) {
            int pnt = list.get(key);
            if (pnt >= 50) {
                System.out.print(key + " ");
            }
        }
        System.out.println();

        System.out.println("**VIP 회원 목록**");
        HashMap<String, Integer> VipList = new HashMap<>(list);

        for (int i = 0; i < 3 && !VipList.isEmpty(); i++) {
            String maxName = null;
            int maxPoint = 0;

            for (String key : VipList.keySet()) {
                int pnt = VipList.get(key);
                if (pnt > maxPoint) {
                    maxPoint = pnt;
                    maxName = key;
                }
            }

            if (maxName != null) {
                System.out.print(maxName+" ");
                VipList.remove(maxName);
            }
        }
        scanner.close();
    }
}

