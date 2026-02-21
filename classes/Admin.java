package classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Admin extends JFrame implements ActionListener
{
	JLabel emailLabel, passLabel, regLabel;
	JTextField emailTF;
	JPasswordField passPF;
	JButton addBtn;
	JPanel panel;
	JLabel lab;
	JLabel label1;
	ImageIcon img;
	JLabel label2;
	Font myFont;
	JLabel label3;
	JButton backBtn;
	JButton addAdminBtn;
	JButton editItems;
	AdminUser user;
	
	public Admin(AdminUser user)
	{
		super("Admin Panel");
		this.setSize(500, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.user = user;

		myFont = new Font("Cambria", Font.PLAIN, 16);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		backBtn = new JButton("Log Out");
		backBtn.setBounds(170, 460, 160, 40);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		panel.add(backBtn);

		label1 = new JLabel("Welcome to the admin panel, " + user.getName() + "!");
		label1.setBounds(120,120,400, 30);
		label1.setFont(myFont);
		panel.add(label1);
						
		addBtn = new JButton("Add User");
		addBtn.setBounds(170, 300, 160, 40);
		addBtn.addActionListener(this);
		addBtn.setBackground(Color.BLACK);
		addBtn.setForeground(Color.WHITE);
		panel.add(addBtn);

		addAdminBtn = new JButton("Add Admin");
		addAdminBtn.setBounds(170, 220, 160, 40);
		addAdminBtn.addActionListener(this);
		addAdminBtn.setBackground(Color.BLACK);
		addAdminBtn.setForeground(Color.WHITE);
		panel.add(addAdminBtn);

		editItems = new JButton("Edit Items");
		editItems.setBounds(170, 380, 160, 40);
		editItems.addActionListener(this);
		editItems.setBackground(Color.BLACK);
		editItems.setForeground(Color.WHITE);
		panel.add(editItems);


		
		
		this.add(panel);
		this.setLocationRelativeTo(null);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(addBtn.getText().equals(command))
		{
		}
		else if(backBtn.getText().equals(command))
		{
			//AdminLogin lgn = new AdminLogin();
			LoginFrame lgn = new LoginFrame();
			lgn.setVisible(true);
			this.setVisible(false);
		}
		else if(addAdminBtn.getText().equals(command))
		{
			AddUser au = new AddUser(user);
			au.setVisible(true);
			this.setVisible(false);
		}
		else if(editItems.getText().equals(command))
		{
		}
	}

}
	
	
	
	