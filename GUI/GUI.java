package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class GUI extends JFrame implements ActionListener {
    private JTextField txtTanggal, txtNamaPasien;
    private JTextArea txtAreaAntrian;
    private Queue<String> nama;
    private int jumlahAntrian;
    private JButton btnTambah, btnTampilkan, btnLayani, btnCetak;

    public GUI() {
        jumlahAntrian = 5;
        nama = new ArrayDeque<>(jumlahAntrian);

        setTitle("Antrian Rumah Sakit Sejahtera");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblTanggal = new JLabel("Masukkan tanggal hari ini (DD/MM/YYYY): ");
        txtTanggal = new JTextField(20);

        JLabel lblJumlahAntrian = new JLabel("Masukkan jumlah antrian: ");
        JTextField txtJumlahAntrian = new JTextField(String.valueOf(jumlahAntrian), 20);
        txtJumlahAntrian.setEditable(true);

        JLabel lblNamaPasien = new JLabel("Masukkan nama pasien: ");
        txtNamaPasien = new JTextField(20);

        btnTambah = new JButton("Tambahkan Antrian");
        btnTampilkan = new JButton("Tampilkan Antrian");
        btnLayani = new JButton("Layani Pasien");
        btnCetak = new JButton("Cetak Antrian");

        txtAreaAntrian = new JTextArea(15, 30);
        txtAreaAntrian.setEditable(false);

        btnTambah.addActionListener(this);
        btnTampilkan.addActionListener(this);
        btnLayani.addActionListener(this);
        btnCetak.addActionListener(this);

        add(lblTanggal);
        add(txtTanggal);
        add(lblJumlahAntrian);
        add(txtJumlahAntrian);
        add(lblNamaPasien);
        add(txtNamaPasien);
        add(btnTambah);
        add(btnTampilkan);
        add(btnLayani);
        add(btnCetak);
        add(new JScrollPane(txtAreaAntrian));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            if (nama.size() < jumlahAntrian) {
                String namaPasien = txtNamaPasien.getText();
                if (!namaPasien.isEmpty()) {
                    nama.offer(namaPasien);
                    txtNamaPasien.setText("");
                    JOptionPane.showMessageDialog(this, "Pasien berhasil ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(this, "Nama pasien tidak boleh kosong!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Antrian penuh!");
            }
        }else if (e.getSource() == btnTampilkan) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nama dalam antrian:\n");
            int i = 1;
            for (String antrian : nama) {
                sb.append(i).append(". ").append(antrian).append("\n");
                i++;
            }
            txtAreaAntrian.setText(sb.toString());
        }else if (e.getSource() == btnLayani) {
            String pollNama = nama.poll();
            if (pollNama != null) {
                JOptionPane.showMessageDialog(this, "== Melayani pasien " + pollNama + " ==");
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada antrian!");
            }
        } else if (e.getSource() == btnCetak){
            String tanggal = txtTanggal.getText();
            if (tanggal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal tidak boleh kosong!");
                return;
            }
            String filePath = "Antrian.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("Antrian Rumah Sakit Sejahtera (" + tanggal + ")\n");
                int k = 1;
                for (String antrian : nama) {
                    writer.write(k + ". " + antrian + "\n");
                    k++;
                }
                JOptionPane.showMessageDialog(this, "Data antrian berhasil disimpan di " + filePath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data antrian: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
