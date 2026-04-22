package w12.tutorials.activity1;

import java.awt.*;
import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private final JButton btnLogin;
    private JLabel lblStatus;

    public LoginForm() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(300, 200));

        JLabel lblTitle = new JLabel("Simple Login Form", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(0, 10, 300, 30);

        JLabel lblUser = new JLabel("User");
        lblUser.setFont(new Font("Arial", Font.BOLD, 13));
        lblUser.setBounds(30, 55, 80, 25);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 55, 150, 25);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 13));
        lblPassword.setBounds(30, 90, 80, 25);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 90, 150, 25);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 125, 80, 25);

        lblStatus = new JLabel("", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 13));
        lblStatus.setBounds(0, 158, 300, 25);

        btnLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String pass = new String(txtPassword.getPassword());
            if (user.equals("snowflakesctb") && pass.equals("nghiep2208chi")) {
                lblStatus.setText("Login successful!");
            } else {
                lblStatus.setText("Login failed!");
            }
        });

        panel.add(lblTitle);
        panel.add(lblUser);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(lblStatus);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}