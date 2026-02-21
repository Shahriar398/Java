package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements MouseListener, ActionListener{

    // Declare cart panels as instance variables
    JPanel burgerPanel, pizzaPanel, sandwichPanel, shawarmaPanel, pastaPanel, drinksPanel;
    JFrame j;


    JButton viewCart;

    // Constructor
    public Main(){
        // Creating the main frame
        j = new JFrame("Welcome");
        j.setSize(1400, 900);
        j.setLayout(null);
        j.setBackground(Color.BLACK);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
                    
        ImageIcon gifIcon = new ImageIcon("images/BG.jpg");  
        Image bgImage = gifIcon.getImage().getScaledInstance(1400, 900, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(bgImage));
        backgroundLabel.setLayout(null);
        backgroundLabel.setBounds(0, 0, 1400, 900);
        j.setContentPane(backgroundLabel);
        
        // Creating food panels
        burgerPanel = createFoodPanel(1, "Burger","images/burger.jpg", "BDT 250/-", 100, 90);
        pizzaPanel = createFoodPanel(2, "Pizza", "images/pizza.jpg", "BDT 450/-", 450, 90);
        sandwichPanel = createFoodPanel(3, "Sandwich", "images/sandwich.jpg", "BDT 150/-", 850, 90);
        shawarmaPanel = createFoodPanel(4, "Shawarma", "images/shawarma.jpg", "BDT 200/-", 100, 440);
        pastaPanel = createFoodPanel(5, "Pasta", "images/pasta.jpg", "BDT 150/-", 450, 440);
        drinksPanel = createFoodPanel(6, "Soft Drinks", "images/drinks.jpg", "BDT 40/-", 850, 440);
        
        // Add MouseListener to each panel
        burgerPanel.addMouseListener(this);
        pizzaPanel.addMouseListener(this);
        sandwichPanel.addMouseListener(this);
        shawarmaPanel.addMouseListener(this);
        pastaPanel.addMouseListener(this);
        drinksPanel.addMouseListener(this);

        backgroundLabel.add(burgerPanel);
        backgroundLabel.add(pizzaPanel);
        backgroundLabel.add(sandwichPanel);
        backgroundLabel.add(shawarmaPanel);
        backgroundLabel.add(pastaPanel);
        backgroundLabel.add(drinksPanel);

        // Cart button
        viewCart = new JButton("Order Now");
        viewCart.setBackground(Color.LIGHT_GRAY);
        viewCart.setBounds(1200, 450, 100, 30);
        viewCart.addActionListener(this);
        backgroundLabel.add(viewCart);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewCart){
            new Cart();
            j.setVisible(false);
        }
    }

    public JPanel createFoodPanel(int serialNumber, String name, String imagePath, String price, int x, int y){
        JPanel foodPanel = new JPanel();
        foodPanel.setLayout(null);
        foodPanel.setBounds(x, y, 210, 210);
        foodPanel.setBackground(Color.LIGHT_GRAY);
        j.add(foodPanel);

        JLabel imageLabel = new JLabel();
        ImageIcon foodImage = new ImageIcon(imagePath);
        Image img = foodImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setBounds(15, 30, 180, 150);
        foodPanel.add(imageLabel);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(50, 1, 100, 30);
        foodPanel.add(nameLabel);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setBounds(120, 1, 100, 30);
        foodPanel.add(priceLabel);

        return foodPanel;
    }

    public void mouseClicked(MouseEvent e) {
        // No action on click
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(Color.LIGHT_GRAY.brighter());  // Highlight on hover
    }

    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(Color.LIGHT_GRAY);  // Reset color when mouse exits
    }
}
