package Java_Collection;

import java.util.Deque;
import java.util.LinkedList;

public class MyDequeue {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.offerFirst("Daffa");
        stack.offerFirst("Yogi");
        stack.offerFirst("Azzah");
        stack.offerFirst("Shofi");
       
        for(String next = stack.pollFirst(); next != null; next = stack.pollFirst()){
            System.out.println(next);
        }
        System.out.println("==================");

        Deque<String> stack2 = new LinkedList<>();
        stack2.offerFirst("Daffa");
        stack2.offerFirst("Yogi");
        stack2.offerFirst("Azzah");
        stack2.offerFirst("Shofi");
        for(String next = stack2.pollLast(); next != null; next = stack2.pollLast()){
            System.out.println(next);
    }
}
}
