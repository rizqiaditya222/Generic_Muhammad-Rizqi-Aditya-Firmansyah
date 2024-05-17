package Java_Operation_File.Latihan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LatihanFile {
    public static void main(String[] args) {
        try{
            File sample = new File("D:\\Java\\Praktisi Mengajar - Pemrograman Lanjut 2024\\Java_Operation_File\\Latihan\\sample.txt");
            System.out.println(sample.getAbsolutePath());
    
            FileReader reader = new FileReader(sample);
            BufferedReader buffer = new BufferedReader(reader);
    
            String rdLn = buffer.readLine();
            while (rdLn != null) {
                System.out.println(rdLn);
                rdLn = buffer.readLine();
            }
    
            buffer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("File Tidak Ada");
        }
    }
}
