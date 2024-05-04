package Java_Collection;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
    public static void main(String[] args) {
        List<String> nama = new LinkedList<String>();
        nama.add("Panjol");
        nama.add("Suarez");
        nama.add("Angga");

        System.out.println(nama);
        nama.set(1, "Tiyan");
        System.out.println(nama);
    }
}
