package week10;

import java.util.LinkedList;

public class StackExample1 {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.addLast(12);
        stack.addLast(59);
        stack.addLast(7);
        while (!stack.isEmpty()) {
            Integer num = stack.removeLast();
            System.out.println(num);
        }
    }
}
