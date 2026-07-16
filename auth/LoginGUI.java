package auth;

import javax.swing.*;

import gui.Dashboard;

public class LoginGUI extends JFrame {

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    public LoginGUI() {

        setTitle("Login System");
        setSize(400,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        l1.setBounds(50,50,100,25);
        username.setBounds(150,50,150,25);

        l2.setBounds(50,100,100,25);
        password.setBounds(150,100,150,25);

        JButton login = new JButton("Login");
        login.setBounds(120,160,100,30);

        add(l1); add(username);
        add(l2); add(password);
        add(login);

        login.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            LoginDAO dao = new LoginDAO();

            if (dao.validate(user, pass)) {

                JOptionPane.showMessageDialog(this, "Login Successful!");

                new Dashboard();   
                dispose();         

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        setVisible(true);
    }
}