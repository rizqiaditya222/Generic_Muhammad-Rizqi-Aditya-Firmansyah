package Java_Collection;
import java.util.ArrayList;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<String> nama = new ArrayList<String>();
        nama.add("Damai");
        nama.add("Adit");
        nama.add("Kelmi");
        nama.add("Andre");
        nama.set(0, "Nopa");
        nama.remove("Adit");
        
        for(String name: nama){
            System.out.println(name);
        }

        System.out.println(nama);

        boolean contain = nama.contains("Damai");
        if (contain==true) {
            System.out.println("Ada");
        }else{
            System.out.println("Tidak ada");
        }
    }
}
