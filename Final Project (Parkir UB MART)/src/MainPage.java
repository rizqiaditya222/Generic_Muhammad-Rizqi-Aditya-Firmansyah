import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainPage implements ActionListener {
    HashMap<String, String> nomorParkir = new HashMap<String, String>();
    StringBuilder invoice = new StringBuilder();
    JFrame input;
    JLabel txtPlat, txtTime, txtFormat, txtPlat2, checkIn, checkOut; 
    JTextField plat, time, platCheck;
    JButton submit, submit2, showData, printInvoice;
    JTextArea show;

    public MainPage(){
        initComponents();
    }

    void initComponents(){
        input = new JFrame();
        input.getContentPane().setBackground(Color.white);
        input.setTitle("Input Customer");
        input.setLayout(null);
        input.setSize(600, 1000);
        input.setLocationRelativeTo(null);
        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setVisible(true);    
        
        checkIn = new JLabel("=== CHECK IN ===");
        checkIn.setBounds(250, 30, 180, 30);
        input.add(checkIn);

        txtPlat = new JLabel("Plat Nomor");
        txtPlat.setBounds(100, 70, 100, 30);
        input.add(txtPlat);

        plat = new JTextField();
        plat.setBounds(250, 70, 250, 30);
        plat.setBorder(BorderFactory.createCompoundBorder(plat.getBorder(), new EmptyBorder(5, 5, 5, 5)));
        input.add(plat);

        txtTime = new JLabel("Waktu Masuk");
        txtTime.setBounds(100, 110, 100, 30);
        input.add(txtTime);
        txtFormat = new JLabel("(yyyy-MM-dd HH:mm:ss)");
        txtFormat.setBounds(100, 130, 150, 30);
        input.add(txtFormat);

        time = new JTextField();
        time.setBounds(250, 110, 250, 30);
        time.setBorder(BorderFactory.createCompoundBorder(time.getBorder(), new EmptyBorder(5, 5, 5, 5)));
        input.add(time);

        submit = new JButton("input");
        submit.setFocusable(false);
        submit.setBounds(260, 160, 80, 30);
        submit.addActionListener(this);
        input.add(submit);

        checkOut = new JLabel("=== CHECK OUT ===");
        checkOut.setBounds(250, 210, 180, 30);
        input.add(checkOut);

        txtPlat2 = new JLabel("Plat Nomor");
        txtPlat2.setBounds(100, 250, 100, 30);
        input.add(txtPlat2);

        platCheck = new JTextField();
        platCheck.setBounds(200, 250, 300, 30); 
        platCheck.setBorder(BorderFactory.createCompoundBorder(platCheck.getBorder(), new EmptyBorder(5, 5, 5, 5)));
        input.add(platCheck);

        submit2 = new JButton("submit");
        submit2.setFocusable(false);
        submit2.setBounds(260, 290, 80, 30);
        submit2.addActionListener(this);
        input.add(submit2);

        showData = new JButton("Show Data");
        showData.setFocusable(false);
        showData.setBounds(100, 350, 200, 30);
        showData.addActionListener(this);
        input.add(showData);

        printInvoice = new JButton("Print Invoice");
        printInvoice.setFocusable(false);
        printInvoice.setBounds(300, 350, 200, 30); 
        printInvoice.addActionListener(this);
        input.add(printInvoice);

        show = new JTextArea();
        show.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        show.setFont(new Font(null, Font.PLAIN, 14));
        show.setBounds(100, 400, 400, 500);
        show.setBorder(BorderFactory.createCompoundBorder(show.getBorder(), new EmptyBorder(10, 10, 10, 10)));
        show.setBackground(Color.white);
        show.setEditable(false);
        input.add(show);
    }

    public HashMap<String, String> getNomorParkir() {
        return nomorParkir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (plat.getText().isEmpty() || time.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Plat nomor dan waktu masuk tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String inputTime = time.getText();
                String timeFormat = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
                
                try {
                    sdf.parse(inputTime);
                    nomorParkir.put(plat.getText(), inputTime);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    plat.setText("");
                    time.setText(""); 

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Format waktu tidak valid! Gunakan format: " + timeFormat, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == submit2) {
            if (nomorParkir.containsKey(platCheck.getText())) {
                invoice.setLength(0);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String inputMasuk = nomorParkir.get(platCheck.getText());
                LocalDateTime waktuMasuk = LocalDateTime.parse(inputMasuk, formatter);
                LocalDateTime waktuKeluar = LocalDateTime.now();
                String waktuKeluarFormatted = waktuKeluar.format(formatter);
                Duration durasi = Duration.between(waktuMasuk, waktuKeluar);
                long jam = durasi.toHours();
                long menit = durasi.toMinutes() % 60;
                long detik = durasi.getSeconds() % 60;
                String durasiTotal = jam + " jam, " + menit + " menit, " + detik + " detik";

                int jamInt = (int) jam;
                int biaya;
                if (jamInt < 3) {
                    biaya = 3000;
                } else {
                    biaya = 3000 + ((jamInt - 2) * 1000);
                }

                invoice.append("\nPlat Nomor\t: ").append(platCheck.getText())
                .append("\nWaktu masuk : ").append(inputMasuk)
                .append("\nWaktu Keluar : ").append(waktuKeluarFormatted)
                .append("\nDurasi Parkir  : ").append(durasiTotal)
                .append("\n\nBiaya Total : Rp.").append(biaya);
                show.setText(invoice.toString());
            } else if (platCheck.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Masukkan plat nomor!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ditemukan kendaraan dengan plat tersebut.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == showData) {
            StringBuilder data = new StringBuilder();
            data.append("Jumlah kendaraan: ").append(nomorParkir.size()).append("\n");
            for (String key : nomorParkir.keySet()) {
                data.append("\nPlat Nomor\t: ").append(key)
                    .append("\nWaktu Masuk\t: ").append(nomorParkir.get(key))
                    .append("\n");
            }
            show.setText(data.toString());
        } else if (e.getSource() == printInvoice) {
            if (platCheck.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Masukkan plat nomor!", "Error", JOptionPane.ERROR_MESSAGE); 
            } else if (!nomorParkir.containsKey(platCheck.getText())) {
                JOptionPane.showMessageDialog(null, "Tidak ada kendaraan dengan plat nomor tersebut.", "Error", JOptionPane.ERROR_MESSAGE); 
            } else {
                try {
                    FileWriter saveInvoice = new FileWriter("D:\\Java\\Final Project (Parkir UB MART)\\invoice\\Invoice.txt");
                    saveInvoice.write("=========== PARKIR UB MART ===========\n"+invoice.toString()+"\n\n============ TERIMA KASIH ============");
                    saveInvoice.close();
                    JOptionPane.showMessageDialog(null, "Berhasil mencetak invoice!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    nomorParkir.remove(platCheck.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal mencetak invoice!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }

    public static void main(String[] args) {
        new MainPage();
    }
}
