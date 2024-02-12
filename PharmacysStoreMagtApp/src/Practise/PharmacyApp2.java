package Practise;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PharmacyApp2 extends JFrame implements ActionListener {
    JLabel outputLabel;
    PharmacyApp2(){
        super("New Pharmacy App");
        JPanel panel1 = new JPanel();
        ImageIcon logo = new ImageIcon("src/Pharmacy_Logo.png");



       
        JLabel name = new JLabel("Emmanuel");
        name.setFont(new Font("Roboto",Font.BOLD,30));
//        name.setHorizontalAlignment(JLabel.LEFT);
//        name.setVerticalAlignment(JLabel.CENTER);

        name.setBounds(110,10,1000,100);

        JLabel logoHold = new JLabel();
        logoHold.setIcon(logo);
        logoHold.setFont(new Font("Roboto",Font.BOLD,30));
//        name.setHorizontalAlignment(JLabel.LEFT);
//        name.setVerticalAlignment(JLabel.CENTER);

        logoHold.setBounds(10,20,100,100);

        JButton btn1   = new JButton("Button testing");
        btn1.setBorder(BorderFactory.createCompoundBorder());
        btn1.setFocusable(false);
        btn1.setBounds(800,50,150,50);
        btn1.addActionListener(this);


        panel1.setBackground(new Color(0xBDF2D5));
        panel1.setSize(1000,150);
        panel1.setLayout(null);
        panel1.add(name);
        panel1.add(logoHold);
        panel1.add(btn1);


//        panel1.setBounds(200,100,1000,100);
        outputLabel = new JLabel();
        outputLabel.setBounds(50,300,1000,100);
        outputLabel.setFont(new Font("Robot",Font.BOLD,50));


        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1000,720);
        getContentPane().setBackground(new Color(0x7AD9F5));
        add(panel1);
        add(outputLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent event){

            outputLabel.setText("Pressed!");
        outputLabel.setText("Pressed!");

    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String look="javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(look);
        PharmacyApp2 app = new PharmacyApp2();

    }


}
