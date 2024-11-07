package week10;
import java.util.*;
public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String,Integer> scoreMap = new HashMap<String, Integer>();
        scoreMap.put("김성동", 97);
        scoreMap.put("황기태", 88);
        scoreMap.put("김남윤", 98);
        scoreMap.put("이재문", 70);
        scoreMap.put("한원선", 99);

        System.out.println("HashMap의 요소 개수: " + scoreMap.size());

        Set<String> keys = scoreMap.keySet();
        Iterator<String> it = keys.iterator();
        int sum = 0;
        int min = 100;
        int max = 0;
        while(it.hasNext()){
            String name = it.next();
            int score = scoreMap.get(name);
            sum += score;
            if (max < score)
                max = score;
            if (min>score)
                min = score;

            System.out.println(name + ":" + score);
        }
        System.out.println("평균은 " + sum / scoreMap.size());
        System.out.println("최댓값은 " + max);
        System.out.println("최솟값은 " + min);
    }
}
