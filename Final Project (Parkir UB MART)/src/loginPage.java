import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class loginPage implements ActionListener {

    public static void main(String[] args) {
        new loginPage();
    }

    public loginPage() {
        initComponents();
    }
    
    JFrame loginFrame;
    JLabel txtLogin, txtPassword;
    JTextField inputUser;
    JPasswordField inputPass;
    JButton btnLogin;

    void initComponents() {
        loginFrame = new JFrame();
        loginFrame.getContentPane().setBackground(Color.white);
        loginFrame.setTitle("Login");
        loginFrame.setLayout(null);
        loginFrame.setSize(600, 700);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("D:\\Java\\Parkir UB MART\\img\\logo.png");
        JLabel imageLabel = new JLabel(imageIcon);
        int imageX = (loginFrame.getWidth() - imageIcon.getIconWidth()) / 2;
        int imageY = 50;  // You can adjust this value to move the image up or down
        imageLabel.setBounds(imageX, imageY, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        loginFrame.add(imageLabel);

        txtLogin = new JLabel("Username");
        txtLogin.setBounds(100, 400, 100, 30);
        loginFrame.add(txtLogin);
        
        txtPassword = new JLabel("Password");
        txtPassword.setBounds(100, 440, 100, 30);
        loginFrame.add(txtPassword);
        
        inputUser = new JTextField();
        inputUser.setBounds(200, 400, 300, 30);
        inputUser.setBorder(BorderFactory.createCompoundBorder(inputUser.getBorder(), new EmptyBorder(5, 5, 5, 5)));
        loginFrame.add(inputUser);
        
        inputPass = new JPasswordField();
        inputPass.setBounds(200, 440, 300, 30);
        inputPass.setBorder(BorderFactory.createCompoundBorder(inputPass.getBorder(), new EmptyBorder(5, 5, 5, 5)));
        loginFrame.add(inputPass);

        btnLogin = new JButton("Login");
        btnLogin.setFocusable(false);
        btnLogin.setBounds(260, 480, 80, 30);
        btnLogin.addActionListener(this);
        loginFrame.add(btnLogin);
        
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnLogin) {
            if (inputUser.getText().isEmpty() || inputPass.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (inputUser.getText().equals("username") && inputPass.getText().equals("password") ) {
                loginFrame.dispose();
                MainPage newMainPage = new MainPage();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
