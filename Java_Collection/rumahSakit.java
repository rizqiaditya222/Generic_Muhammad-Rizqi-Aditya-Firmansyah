package Java_Collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class rumahSakit {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Queue<String> nama = new ArrayDeque<>(5);
        System.out.println("== SELAMAT DATANG DI RUMAH SAKIT SEJAHTERA ==");
        System.out.println("====== SILAHKAN MENGISI NOMOR ANTRIAN =======\n");
        for (int i = 0;i<5;i++){
            System.out.print("Masukkan nama anda : ");
            String namaPasien = input.nextLine();
            nama.offer(namaPasien);

        }
            System.out.println("\nNama dalam antrian :");
            int i = 0;
            for (String antrian:nama){
                System.err.println((i+1)+". "+antrian);
                i++;
            }
            System.out.println();
            
            for (int j = 0;j<5;j++){
                String pollNama = nama.poll();
                System.out.println("== Melayani pasien "+pollNama+" ==\n");
                
                if (!nama.isEmpty()) {
                    int k = 0;
                    System.out.println("Nama dalam antrian :");
                    for (String antrian:nama){
                        System.err.println((k+1)+". "+antrian);
                        k++;
                }

                }
                System.out.println();
            }
        // for(String next = nama.poll(); next != null; next = nama.poll()){
        //     System.out.println(next);
        // } 
    
}
}