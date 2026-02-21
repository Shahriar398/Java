package classes;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Order {
 
    private static final String PAYMENT_METHOD_CASH = "Cash";
    private static final String PAYMENT_METHOD_BKASH = "Bkash";
    private static final Color LABEL_COLOR = Color.BLACK;
    private static final Color FIELD_TEXT_COLOR = Color.BLACK;
    private static final Color FIELD_BACKGROUND_COLOR = Color.WHITE;
 
    public Order() {
        createPaymentPage();
    }
 
    public void createPaymentPage() {
        JFrame frame = new JFrame("Payment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(null);
 
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 800, 700);
        backgroundPanel.setLayout(null);
 
        JLabel paymentMethodLabel = new JLabel("Payment Method");
        paymentMethodLabel.setBounds(200, 30, 200, 30);
        paymentMethodLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        paymentMethodLabel.setForeground(LABEL_COLOR);
        backgroundPanel.add(paymentMethodLabel);
 
        JRadioButton cashOption = new JRadioButton(PAYMENT_METHOD_CASH);
        JRadioButton bkashOption = new JRadioButton(PAYMENT_METHOD_BKASH);
 
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashOption);
        paymentGroup.add(bkashOption);
 
        cashOption.setBounds(200, 80, 100, 30);
        bkashOption.setBounds(300, 80, 100, 30);
        backgroundPanel.add(cashOption);
        backgroundPanel.add(bkashOption);
 
        JPanel bkashPanel = new JPanel();
        bkashPanel.setBounds(100, 130, 400, 200);
        bkashPanel.setLayout(null);
        bkashPanel.setVisible(false);
        bkashPanel.setOpaque(false);
 
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(10, 20, 120, 25);
        phoneLabel.setForeground(LABEL_COLOR);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(140, 20, 200, 30);
        phoneField.setBackground(FIELD_BACKGROUND_COLOR);
        phoneField.setForeground(FIELD_TEXT_COLOR);
 
        JLabel pinLabel = new JLabel("Bkash Pin:");
        pinLabel.setBounds(10, 70, 120, 25);
        pinLabel.setForeground(LABEL_COLOR);
        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(140, 70, 200, 30);
        pinField.setBackground(FIELD_BACKGROUND_COLOR);
        pinField.setForeground(FIELD_TEXT_COLOR);
        pinField.setEchoChar('*');
 
        JLabel amountLabel = new JLabel("Amount :");
        amountLabel.setBounds(10, 120, 120, 25);
        amountLabel.setForeground(LABEL_COLOR);
        JTextField amountField = new JTextField();
        amountField.setBounds(140, 120, 200, 30);
        amountField.setBackground(FIELD_BACKGROUND_COLOR);
        amountField.setForeground(FIELD_TEXT_COLOR);
 
        bkashPanel.add(phoneLabel);
        bkashPanel.add(phoneField);
        bkashPanel.add(pinLabel);
        bkashPanel.add(pinField);
        bkashPanel.add(amountLabel);
        bkashPanel.add(amountField);
 
        backgroundPanel.add(bkashPanel);
 
        JButton payButton = new JButton("Pay");
        payButton.setBounds(250, 400, 170, 40);
        payButton.setBackground(Color.GREEN);
        backgroundPanel.add(payButton);
 
        cashOption.addActionListener(e -> bkashPanel.setVisible(false));
        bkashOption.addActionListener(e -> bkashPanel.setVisible(true));
 
        payButton.addActionListener(e -> {
            if (cashOption.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Your food is on the way. Thank you for ordering.");
                frame.dispose();
                new Main();
            } else if (bkashOption.isSelected()) {
                String phoneNumber = phoneField.getText();
                String pinCode = new String(pinField.getPassword());
                String amount = amountField.getText();
 
                if (phoneNumber.isEmpty() || pinCode.isEmpty() || amount.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all Bkash payment details.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Bkash payment successful. Thank you.");
                    frame.dispose();
                    new Main();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a payment method.");
            }
        });
 
        frame.add(backgroundPanel);
        frame.setVisible(true);
    }
 
    

 
}

