package Practise;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class PharmacyApp extends JFrame {
    PharmacyApp(){
        Border border = BorderFactory.createLineBorder(Color.RED,5);
        ImageIcon logo = new ImageIcon("src/Pharmacy_Logo.png");

        JLabel label1 = new JLabel("Emmanuel");
        label1.setForeground(new Color(0xFFFFFF));
        label1.setFont(new Font("Roboto",Font.BOLD,60));
        label1.setIcon(logo);
        label1.setBorder(border);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setBounds(0,0,200,200);



        this.add(label1);

        this.setVisible(true);
        this.setSize(1280,720);

        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x47B5FF));
        setLayout(null);
//        this.pack();


        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);



        this.setIconImage(logo.getImage());


    }


}
