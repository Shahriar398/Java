package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
 
public class Cart implements ActionListener{
    JFrame J;
    JLabel L,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,L17,L18,L19,L20,L21,L22,L23,L24,L25,L26;
    JButton B,B1,B2,B3,B4,B5,B6,B7,B22,B33,B44,B55,B66,B77,BB;
    JPanel P,P1,P2,P3,P4,P5;
    ImageIcon img,img1;
    JLabel IL,IL1,IL2,IL3,IL4,IL5,IL6;
 
    //cart frame creation
 
    public Cart(){
        J=new JFrame("Your Cart");
        J.setSize(1800,1000);
        J.setVisible(true);
        J.setLayout(null);
		J.setLocationRelativeTo(null); // Center the frame
        J.setVisible(true);

       
        L=new JLabel("Please Confirm Your Order");
        L.setBounds(850,10,180,90);
        J.add(L);
 
       /* BB=new JButton("Total Order Price");
        BB.setBounds(900,820,140,60);
        J.add(BB);*/
 
        B=new JButton("Make Payment");
        B.setBounds(1000,720,120,60);
        B.addActionListener(this);
        J.add(B);
 
        B1=new JButton("GO Back");
        B1.setBounds(850,720,120,60);
        B1.addActionListener(this);
        J.add(B1);
 
        //panel creation
 
        P=new JPanel();
        P.setLayout(null);
        P.setVisible(true);
        P.setBounds(150,150,225,162);
        P.setBackground(Color.LIGHT_GRAY);
        J.add(P);
 
        P1=new JPanel();
        P1.setLayout(null);
        P1.setVisible(true);
        P1.setBounds(150,350,225,150);
        P1.setBackground(Color.LIGHT_GRAY);
        J.add(P1);
 
        P2=new JPanel();
        P2.setLayout(null);
        P2.setVisible(true);
        P2.setBounds(150,550,225,150);
        P2.setBackground(Color.LIGHT_GRAY);
        J.add(P2);
 
        P3=new JPanel();
        P3.setLayout(null);
        P3.setVisible(true);
        P3.setBounds(1000,150,225,150);
        P3.setBackground(Color.LIGHT_GRAY);
        J.add(P3);
 
        P4=new JPanel();
        P4.setLayout(null);
        P4.setVisible(true);
        P4.setBounds(1000,350,225,150);
        P4.setBackground(Color.LIGHT_GRAY);
        J.add(P4);
 
        P5=new JPanel();
        P5.setLayout(null);
        P5.setVisible(true);
        P5.setBounds(1000,550,225,150);
        P5.setBackground(Color.LIGHT_GRAY);
        J.add(P5);
 
 
        //ImageLabel creation
 
    
        ImageIcon img;

        // For Burger
        img = new ImageIcon("images/burger.jpg");
        Image burgerImage = img.getImage().getScaledInstance(225, 162, Image.SCALE_SMOOTH);
        IL = new JLabel(new ImageIcon(burgerImage));
        IL.setBounds(0, 0, 225, 162);
        P.add(IL);

        // For Pizza
        img = new ImageIcon("images/pizza.jpg");
        Image pizzaImage = img.getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        IL1 = new JLabel(new ImageIcon(pizzaImage));
        IL1.setBounds(0, 0, 225, 150);
        P1.add(IL1);

        // For Sandwich
        img = new ImageIcon("images/sandwich.jpg");
        Image sandwichImage = img.getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        IL2 = new JLabel(new ImageIcon(sandwichImage));
        IL2.setBounds(0, 0, 225, 150);
        P2.add(IL2);

        // For Shawarma
        img = new ImageIcon("images/shawarma.jpg");
        Image shawarmaImage = img.getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        IL3 = new JLabel(new ImageIcon(shawarmaImage));
        IL3.setBounds(0, 0, 225, 150);
        P3.add(IL3);

        // For Pasta
        img = new ImageIcon("images/pasta.jpg");
        Image pastaImage = img.getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        IL4 = new JLabel(new ImageIcon(pastaImage));
        IL4.setBounds(0, 0, 225, 150);
        P4.add(IL4);

        // For Drinks
        img = new ImageIcon("images/drinks.jpg");
        Image drinksImage = img.getImage().getScaledInstance(225, 150, Image.SCALE_SMOOTH);
        IL5 = new JLabel(new ImageIcon(drinksImage));
        IL5.setBounds(0, 0, 225, 150);
        P5.add(IL5);
        
        //Label creation
 
        L1=new JLabel("Burger :BDT 250");
        L1.setBounds(400,150,180,90);
        J.add(L1);
 
        L2=new JLabel("Pizza :BDT 450");
        L2.setBounds(400,350,180,90);
        J.add(L2);
 
        L3=new JLabel("Sandwich :BDT 150");
        L3.setBounds(400,550,180,90);
        J.add(L3);
 
        L4=new JLabel("Shawarma :BDT 200");
        L4.setBounds(1250,150,180,90);
        J.add(L4);
 
        L5=new JLabel("Pasta :BDT 150");
        L5.setBounds(1250,350,180,90);
        J.add(L5);
 
        L6=new JLabel("Soft Drinks :BDT 40");
        L6.setBounds(1250,550,180,90);
        J.add(L6);
 
        //Button creation
 
        B2=new JButton("-");
        B2.setBounds(512,180,40,40);
        B2.setBackground(Color.GRAY);
        B2.setFont(new Font("Arial",Font.PLAIN,10));
        B2.addActionListener(this);
        J.add(B2);
 
        B22=new JButton("+");
        B22.setBounds(590,180,40,40);
        B22.setBackground(Color.GRAY);
        B22.setFont(new Font("Arial",Font.PLAIN,10));
        B22.addActionListener(this);
        J.add(B22);
 
        B3=new JButton("-");
        B3.setBounds(512,380,40,40);
        B3.setBackground(Color.GRAY);
        B3.setFont(new Font("Arial",Font.PLAIN,10));
        B3.addActionListener(this);
        J.add(B3);
 
        B33=new JButton("+");
        B33.setBounds(590,380,40,40);
        B33.setBackground(Color.GRAY);
        B33.setFont(new Font("Arial",Font.PLAIN,10));
        B33.addActionListener(this);
        J.add(B33);
 
        B4=new JButton("-");
        B4.setBounds(512,580,40,40);
        B4.setBackground(Color.GRAY);
        B4.setFont(new Font("Arial",Font.PLAIN,10));
        B4.addActionListener(this);
        J.add(B4);
 
        B44=new JButton("+");
        B44.setBounds(590,580,40,40);
        B44.setBackground(Color.GRAY);
        B44.setFont(new Font("Arial",Font.PLAIN,10));
        B44.addActionListener(this);
        J.add(B44);
 
        B5=new JButton("-");
        B5.setBounds(1368,180,40,40);
        B5.setBackground(Color.GRAY);
        B5.setFont(new Font("Arial",Font.PLAIN,10));
        B5.addActionListener(this);
        J.add(B5);
 
        B55=new JButton("+");
        B55.setBounds(1446,180,40,40);
        B55.setBackground(Color.GRAY);
        B55.setFont(new Font("Arial",Font.PLAIN,10));
        B55.addActionListener(this);
        J.add(B55);
 
        B6=new JButton("-");
        B6.setBounds(1368,380,40,40);
        B6.setBackground(Color.GRAY);
        B6.setFont(new Font("Arial",Font.PLAIN,10));
        B6.addActionListener(this);
        J.add(B6);
 
        B66=new JButton("+");
        B66.setBounds(1446,380,40,40);
        B66.setBackground(Color.GRAY);
        B66.setFont(new Font("Arial",Font.PLAIN,10));
        B66.addActionListener(this);
        J.add(B66);
 
        B7=new JButton("-");
        B7.setBounds(1368,580,40,40);
        B7.setBackground(Color.GRAY);
        B7.setFont(new Font("Arial",Font.PLAIN,10));
        B7.addActionListener(this);
        J.add(B7);
 
        B77=new JButton("+");
        B77.setBounds(1446,580,40,40);
        B77.setBackground(Color.GRAY);
        B77.setFont(new Font("Arial", Font.PLAIN, 10));
        B77.addActionListener(this);
        J.add(B77);
 
        //Label creation
 
        L7=new JLabel("0");
        L7.setBounds(568,180,30,40);
        L7.setBackground(Color.YELLOW);
        J.add(L7);
 
        L8=new JLabel("0");
        L8.setBounds(568,380,30,40);
        J.add(L8);
 
        L9=new JLabel("0");
        L9.setBounds(568,580,30,40);
        J.add(L9);
 
        L10=new JLabel("0");
        L10.setBounds(1424,180,30,40);
        J.add(L10);
 
        L11=new JLabel("0");
        L11.setBounds(1424,380,30,40);
        J.add(L11);
 
        L12=new JLabel("0");
        L12.setBounds(1424,580,30,40);
        J.add(L12);
 
        L13=new JLabel("Price= BDT");
        L13.setBounds(700,180,100,40);
        J.add(L13);
 
        L14=new JLabel("Price= BDT");
        L14.setBounds(700,380,100,40);
        J.add(L14);
 
        L15=new JLabel("Price= BDT");
        L15.setBounds(700,580,100,40);
        J.add(L15);
 
        L16=new JLabel("Price= BDT");
        L16.setBounds(1550,180,100,40);
        J.add(L16);
 
        L17=new JLabel("Price= BDT");
        L17.setBounds(1550,380,100,40);
        J.add(L17);
 
        L18=new JLabel("Price= BDT");
        L18.setBounds(1550,580,100,40);
        J.add(L18);
 
        L19=new JLabel("");
        L19.setBounds(800,180,100,40);
        J.add(L19);
 
        L20=new JLabel("");
        L20.setBounds(800,380,100,40);
        J.add(L20);
 
        L21=new JLabel("");
        L21.setBounds(800,580,100,40);
        J.add(L21);
 
        L22=new JLabel("");
        L22.setBounds(1650,180,100,40);
        J.add(L22);
 
        L23=new JLabel("");
        L23.setBounds(1650,380,100,40);
        J.add(L23);
 
        L24=new JLabel("");
        L24.setBounds(1650,580,100,40);
        J.add(L24);
 
        L25=new JLabel("Total order Price BDT :");
        L25.setBounds(900,820,180,40);
        J.add(L25);
 
        L26=new JLabel("");
        L26.setBounds(1050,820,100,40);
        J.add(L26);
 
       
 
    }
 
    int Total_Price=0;
 
    //Action Listener Addition
 
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == B){
            
            new Order();
            J.setVisible(false);
        }
        
        
        if(e.getSource()==B1){
 
            new Main();
            J.setVisible(false);
        }
        
 
       /*
        if(e.getSource()==B){
 
            J1.setVisible(true);
        J.setVisible(false);
        }
        */
 
        // Getting food item quantity & price
 
        if(e.getSource()==B2){
            int value=Integer.parseInt(L7.getText());
            if(value!=0){
                value--; //decrement
                int price=value*250;
                Total_Price-=250;
                L19.setText(String.valueOf(price));
                L7.setText(String.valueOf(value));
               
            }
        }
 
        if(e.getSource()==B22){
            int value=Integer.parseInt(L7.getText());
            value++; //increment
            int price=value*250;
            Total_Price+=250;
                L19.setText(String.valueOf(price));
                L7.setText(String.valueOf(value));
               
 
            }
 
            if(e.getSource()==B3){
            int value=Integer.parseInt(L8.getText());
            if(value!=0){
                value--;
                int price=value*450;
                Total_Price-=450;
                L20.setText(String.valueOf(price));
                L8.setText(String.valueOf(value));
            }
        }
 
        if(e.getSource()==B33){
            int value=Integer.parseInt(L8.getText());
            value++;
            int price=value*450;
            Total_Price+=450;
                L20.setText(String.valueOf(price));
                L8.setText(String.valueOf(value));
            }
 
            if(e.getSource()==B4){
            int value=Integer.parseInt(L9.getText());
            if(value!=0){
                value--;
                int price=value*150;
                Total_Price-=150;
                L21.setText(String.valueOf(price));
                L9.setText(String.valueOf(value));
            }
        }
 
        if(e.getSource()==B44){
            int value=Integer.parseInt(L9.getText());
            value++;
            int price=value*150;
            Total_Price+=150;
                L21.setText(String.valueOf(price));
                L9.setText(String.valueOf(value));
            }
 
            if(e.getSource()==B5){
            int value=Integer.parseInt(L10.getText());
            if(value!=0){
                value--;
                int price=value*200;
                Total_Price-=200;
                L22.setText(String.valueOf(price));
                L10.setText(String.valueOf(value));
            }
        }
 
        if(e.getSource()==B55){
            int value=Integer.parseInt(L10.getText());
            value++;
            int price=value*200;
            Total_Price+=200;;
                L22.setText(String.valueOf(price));
                L10.setText(String.valueOf(value));
            }
 
            if(e.getSource()==B6){
            int value=Integer.parseInt(L11.getText());
            if(value!=0){
                value--;
                int price=value*150;
                Total_Price-=150;
                L23.setText(String.valueOf(price));
                L11.setText(String.valueOf(value));
            }
        }
 
        if(e.getSource()==B66){
            int value=Integer.parseInt(L11.getText());
            value++;
            int price=value*150;
            Total_Price+=150;
                L23.setText(String.valueOf(price));
                L11.setText(String.valueOf(value));
            }
 
            if(e.getSource()==B7){
                int value=Integer.parseInt(L12.getText());
                if(value!=0){
                    value--;
                    int price=value*40;
                    Total_Price-=40;
                L24.setText(String.valueOf(price));
                    L12.setText(String.valueOf(value));
                }
            }
 
            if(e.getSource()==B77){
                int value=Integer.parseInt(L12.getText());
                value++;
                int price=value*40;
                Total_Price+=40;
                L24.setText(String.valueOf(price));
                L12.setText(String.valueOf(value));
            }
 
            L26.setText(String.valueOf(Total_Price)); //setting total price
 
    }
}



