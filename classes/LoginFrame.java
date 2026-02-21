package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginFrame extends JFrame implements ActionListener {

    JFrame userFrame = new JFrame("Login Frame");

    Container container = userFrame.getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign Up");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel titleLabel = new JLabel("SuRaSha", SwingConstants.CENTER);
    JLabel signupLabel = new JLabel("Don't have an account? Sign up here.", SwingConstants.CENTER);
    JRadioButton adminBtn;
    AdminUser adminuser = null;

    public LoginFrame() {
        setLayoutManager();
        
        titleLabel.setFont(new Font("Sherif", Font.ITALIC, 50));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(0, 60, 1000, 70);
        
        userLabel.setFont(new Font("Sherif", Font.BOLD, 18));
        Color c1 = Color.decode("#063970");
        userLabel.setForeground(c1);
        passwordLabel.setFont(new Font("Dialog", Font.BOLD, 19));
        Color c2 = Color.decode("#063970");
        passwordLabel.setForeground(c2);
       
        signupLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        signupLabel.setForeground(Color.BLACK);
        signupLabel.setBounds(250, 450, 500, 30);

        adminBtn = new JRadioButton("Admin Login");
        adminBtn.setBounds(450, 350, 150, 30);
        container.add(adminBtn);

        setLocationAndSize();        
        addComponentsToContainer();  
        addActionEvent();            

        container.add(titleLabel);
        container.add(signupLabel);
        container.add(signupButton);

        userFrame.setSize(1000, 1000);                
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setResizable(false);                
        userFrame.setLocationRelativeTo(null);        
        userFrame.setVisible(true);
        
        
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(350, 200, 100, 30);
        passwordLabel.setBounds(350, 270, 100, 30);
        userTextField.setBounds(500, 200, 200, 35);
        passwordField.setBounds(500, 270, 200, 35);
        showPassword.setBounds(450, 310, 150, 30);
        loginButton.setBounds(250, 380, 200, 30);
        resetButton.setBounds(550, 380, 200, 30);
        signupButton.setBounds(250, 490, 500, 30);

        userTextField.setBackground(new Color(236, 210, 181));
        passwordField.setBackground(new Color(236, 210, 181));

        userTextField.setFont(new Font("Ariel", Font.BOLD, 18));
        passwordField.setFont(new Font("Dialog", Font.BOLD, 18));
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(signupButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        signupButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            try {
                String userText = userTextField.getText();
                String pwdText = new String(passwordField.getPassword());
                if (validateLogin(userText, pwdText)) {
                    JOptionPane.showMessageDialog(userFrame, "Login Successful");
                    if (adminBtn.isSelected()) {
                        Admin adm = new Admin(adminuser);
                        adm.setVisible(true);
                        userFrame.setVisible(false);
                    }
                    else {
                        new Main();
                        userFrame.setVisible(false);
                    }
                } else {
                    throw new Exception("Invalid Username or Password");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userFrame, ex.getMessage());
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

        if (e.getSource() == signupButton) {
            new Signup();
            userFrame.setVisible(false);
        }
    }

    private boolean validateLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("UserData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 3 && credentials[0].equals(username) && credentials[2].equals(password)) {
                    adminuser = new AdminUser(credentials[0], credentials[1], credentials[2]);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

