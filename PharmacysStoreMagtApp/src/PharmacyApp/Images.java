package PharmacyApp;

import javax.swing.*;
import java.awt.*;

public class Images extends JFrame {
    JLabel label, label2;

    Images(){
        ImageIcon myphoto= new ImageIcon("src/PharmacyApp/Assets/pic5.jpeg");

        System.out.print(myphoto);
        setVisible(true);
        setLayout(null);
        setSize(500,300);

        label = new JLabel("EMMANUEL");
        label.setFont(new Font("Roboto", Font.BOLD,30));

        label.setForeground(Color.red);
        label.setLayout(null);
        label.setBounds(10,0,300,200);

        label2 = new JLabel("EMMANUEL");
        label2.setIcon(myphoto);
        label2.setFont(new Font("Roboto", Font.BOLD,30));

        label2.setForeground(Color.red);
        label2.setLayout(null);
        label2.setBounds(10,100,myphoto.getIconWidth(),myphoto.getIconHeight()-400);


        add(label);
        add(label2);


    }

    public static void main(String[] args) {

        Images testing = new Images();
    }
}
