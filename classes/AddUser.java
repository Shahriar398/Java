package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class AddUser extends JFrame implements ActionListener {
 
    private JFrame frame;
    private Container c;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JLabel titleLabel, userNameLabel, mobileNumberLabel, emailLabel;
    private JTextField userTb, mobTb, emailTb;
    private JButton addButton, updateButton, deleteButton, clearButton, backButton;
    private int selectedRow = -1;  // Variable to track selected row index
 
    private String[] columns = {"User Name", "Password", "Email Address"};
    private String[] rows = new String[3];
    AdminUser user;
 
    // Constructor
    AddUser(AdminUser user) {
        // Create JFrame manually
        frame = new JFrame("Admin Panel - Add New User");
        this.user = user;
        initComponents();
    }
 
    // Initialize components
    public void initComponents() {
        // Set default JFrame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Set appropriate frame size
        frame.setLocationRelativeTo(null); // Center the frame on screen
        frame.setLayout(null); // Using absolute layout
 
        // Get content pane for adding components
        c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
 
        // Set font for labels and buttons
        Font font = new Font("Arial", Font.BOLD, 16);
 
        // Title label
        titleLabel = new JLabel("Add New User");
        titleLabel.setFont(font);
        titleLabel.setBounds(300, 10, 250, 50);
        c.add(titleLabel);
 
        // Username label and text field
        userNameLabel = new JLabel("User Name:");
        userNameLabel.setFont(font);
        userNameLabel.setBounds(30, 80, 200, 30);
        c.add(userNameLabel);
 
        userTb = new JTextField();
        userTb.setFont(font);
        userTb.setBounds(230, 80, 200, 30);
        c.add(userTb);
 
        // Mobile number label and text field
        mobileNumberLabel = new JLabel("Password:");
        mobileNumberLabel.setFont(font);
        mobileNumberLabel.setBounds(30, 130, 200, 30);
        c.add(mobileNumberLabel);
 
        mobTb = new JTextField();
        mobTb.setFont(font);
        mobTb.setBounds(230, 130, 200, 30);
        c.add(mobTb);
 
        // Email label and text field
        emailLabel = new JLabel("Email Address:");
        emailLabel.setFont(font);
        emailLabel.setBounds(30, 180, 200, 30);
        c.add(emailLabel);
 
        emailTb = new JTextField();
        emailTb.setFont(font);
        emailTb.setBounds(230, 180, 200, 30);
        c.add(emailTb);
 
        // Buttons (Add, Update, Delete, Clear)
        addButton = new JButton("Add");
        addButton.setFont(font);
        addButton.setBounds(470, 80, 150, 30);
        c.add(addButton);
 
        updateButton = new JButton("Update");
        updateButton.setFont(font);
        updateButton.setBounds(470, 130, 150, 30);
        c.add(updateButton);
 
        deleteButton = new JButton("Delete");
        deleteButton.setFont(font);
        deleteButton.setBounds(470, 180, 150, 30);
        c.add(deleteButton);
 
        clearButton = new JButton("Clear");
        clearButton.setFont(font);
        clearButton.setBounds(470, 230, 150, 30);
        c.add(clearButton);
 
        backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.setBounds(660, 230, 150, 30);
        c.add(backButton);
 
        // Table to display users
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.GRAY);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Ensure single row selection
 
        scroll = new JScrollPane(table);
        scroll.setBounds(30, 280, 700, 300);
        c.add(scroll);
 
        // Add action listeners for buttons
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        backButton.addActionListener(this); // Back button listener
 
        // Add MouseListener to the table for row selection
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                selectedRow = table.getSelectedRow();
 
                if (selectedRow >= 0) {
                    // Set the values from the selected row to the text fields
                    userTb.setText(model.getValueAt(selectedRow, 0).toString());
                    mobTb.setText(model.getValueAt(selectedRow, 1).toString());
                    emailTb.setText(model.getValueAt(selectedRow, 2).toString());
                }
            }
        });
 
        // Set visibility
        frame.setVisible(true);
    }
 
    // Action performed when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            rows[0] = userTb.getText();
            rows[1] = mobTb.getText();
            rows[2] = emailTb.getText();
 
            model.addRow(rows);
        } else if (e.getSource() == clearButton) {
            // Clear the text fields
            userTb.setText("");
            mobTb.setText("");
            emailTb.setText("");
        } else if (e.getSource() == deleteButton) {
            // Delete selected row
            int selectedRow = table.getSelectedRow();
 
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No row selected or table is empty.");
            }
        } else if (e.getSource() == updateButton) {
            // Update the selected row
            if (selectedRow >= 0) {
                model.setValueAt(userTb.getText(), selectedRow, 0);  // Update user name
                model.setValueAt(mobTb.getText(), selectedRow, 1);   // Update mobile number
                model.setValueAt(emailTb.getText(), selectedRow, 2); // Update email address
 
                JOptionPane.showMessageDialog(null, "Selected row updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No row selected or table is empty.");
            }
        } else if (e.getSource() == backButton) {
            // Handle back button
            frame.dispose(); // Close the current frame
            Admin adm = new Admin(user); // Open the Admin panel
            adm.setVisible(true);
        }
    }
    
    /*
    public static void main(String[] args) {
        new AddUser(); // This will initialize the GUI
    }
    */
}

 