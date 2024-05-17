package Java_Operation_File.Tugas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class rumahSakit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlahAntrian = 5;

        System.out.print("Masukkan tanggal hari ini (DD/MM/YYYY) : ");
        String tanggal = input.next();
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
        while (true) {
            System.out.println("1. Tambahkan Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cetak Antrian");
            System.out.print("Pilih opsi : ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    if (nama.size() < jumlahAntrian) {
                        System.out.print("Masukkan nama pasien : ");
                        String namaPasien = input.nextLine();
                        nama.offer(namaPasien);
                    } else {
                        System.out.println("Antrian penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\nNama dalam antrian :");
                    int i = 0;
                    for (String antrian : nama) {
                        System.out.println((i + 1) + ". " + antrian);
                        i++;
                    }
                    System.out.println("");
                    break;

                case 3:
                    String pollNama = nama.poll();
                    if (pollNama != null) {
                        System.out.println("== Melayani pasien " + pollNama + " ==\n");
                    } else {
                        System.out.println("Tidak ada antrian!\n");
                    }
                    break;

                case 4:
                    String filePath = "D:\\Java\\Praktisi Mengajar - Pemrograman Lanjut 2024\\Java_Operation_File\\Tugas\\Antrian.txt";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write("Antrian Rumah Sakit Sejahtera (" + tanggal + ")\n");
                        int k = 1;
                        for (String antrian : nama) {
                            writer.write(k + ". " + antrian + "\n");
                            k++;
                        }
                        System.out.println("Data antrian berhasil disimpan di " + filePath + "\n");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat menyimpan data antrian: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        }
    }
}
