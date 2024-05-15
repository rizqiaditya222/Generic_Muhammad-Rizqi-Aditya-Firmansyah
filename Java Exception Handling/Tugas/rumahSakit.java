package Java_Collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class rumahSakit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahAntrian = 5;
        
        while (true) {
            try {
                System.out.print("Masukkan jumlah antrian : ");
                jumlahAntrian = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Masukkan dalam bentuk angka!\n");
                input.nextLine(); 
            }
        }

        Queue<String> nama = new ArrayDeque<>(jumlahAntrian);
        System.out.println("== SELAMAT DATANG DI RUMAH SAKIT SEJAHTERA ==");
        System.out.println("====== SILAHKAN MENGISI NOMOR ANTRIAN =======\n");

        for (int i = 0; i < jumlahAntrian; i++) {
            System.out.print("Masukkan nama anda : ");
            String namaPasien = input.nextLine();
            nama.offer(namaPasien);
        }

        System.out.println("\nNama dalam antrian :");
        int i = 0;
        for (String antrian : nama) {
            System.err.println((i + 1) + ". " + antrian);
            i++;
        }
        System.out.println();

        for (int j = 0; j < jumlahAntrian; j++) {
            String pollNama = nama.poll();
            System.out.println("== Melayani pasien " + pollNama + " ==\n");

            if (!nama.isEmpty()) {
                int k = 0;
                System.out.println("Nama dalam antrian :");
                for (String antrian : nama) {
                    System.err.println((k + 1) + ". " + antrian);
                    k++;
                }
            }
            System.out.println();
        }

        input.close(); // Ensure the Scanner resource is closed after use
    }
}
