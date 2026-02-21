package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Signup extends JFrame implements ActionListener {

    JButton back;
    JButton signUp;
    JTextField usernameField, emailField;
    JPasswordField passwordField;

    public Signup() {
        JFrame j = new JFrame("Sign up page");
        int frameWidth = 1200;
        int frameHeight = 700;
        j.setSize(frameWidth, frameHeight);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, frameWidth, frameHeight);
        panel.setOpaque(false);
        panel.setLayout(null);

        back = new JButton("Back");
        back.setBounds(150, 300, 100, 40);
        back.setBackground(Color.decode("#0080FF"));
        back.addActionListener(this);
        panel.add(back);

        signUp = new JButton("Sign up");
        signUp.setBounds(300, 300, 100, 40);
        signUp.setBackground(Color.decode("#0080FF"));
        panel.add(signUp);

        JLabel S1 = new JLabel("Sign up");
        S1.setBounds(100, 50, 100, 40);
        panel.add(S1);
        
        JLabel L2 = new JLabel("User Name: ");
        L2.setBounds(100, 100, 100, 40);
        panel.add(L2);
        
        usernameField = new JTextField();
        usernameField.setBounds(250, 100, 150, 40);
        panel.add(usernameField);
        
        JLabel L1 = new JLabel("User Email: ");
        L1.setBounds(100, 150, 100, 40);
        panel.add(L1);
        
        emailField = new JTextField();
        emailField.setBounds(250, 150, 150, 40);
        panel.add(emailField);
        
        JLabel L3 = new JLabel("Password: ");
        L3.setBounds(100, 200, 100, 40);
        panel.add(L3);
        
        L3.setForeground(Color.decode("#063970"));
        passwordField = new JPasswordField();
        passwordField.setBounds(250, 200, 150, 40);
        panel.add(passwordField);
        
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(250, 250, 150, 40);
        panel.add(showPassword);
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmpty = false;
                if (usernameField.getText().trim().isEmpty()) {
                    usernameField.setBackground(Color.RED);
                    isEmpty = true;
                }
                if (emailField.getText().trim().isEmpty()) {
                    emailField.setBackground(Color.RED);
                    isEmpty = true;
                }
                if (new String(passwordField.getPassword()).trim().isEmpty()) {
                    passwordField.setBackground(Color.RED);
                    isEmpty = true;
                }
                if (isEmpty) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserData.txt", true))) {
                        writer.write(usernameField.getText().trim() + "," + emailField.getText().trim() + "," + new String(passwordField.getPassword()).trim());
                        writer.newLine();
                        JOptionPane.showMessageDialog(null, "Sign up successfully.");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                j.setVisible(false);
            }
        });

        j.add(panel);
        j.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

