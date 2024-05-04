package Java_Collection;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {
        Queue<String> nama = new ArrayDeque<>(10);
        nama.offer("Sumiyati");
        nama.offer("Mukodas");

        for(String next = nama.poll(); next != null; next = nama.poll()){
            System.out.println(next);
        }
    }
}
