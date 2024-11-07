package week10;
import java.util.*;
public class QueueExample {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer("토끼");
        queue.offer("사슴");
        queue.offer("호랑이");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
