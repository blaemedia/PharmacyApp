package PharmacyApp2;

import javax.swing.*;
import java.awt.*;

public class NewOpen2 extends JFrame {
    private ImageIcon logoNew;
    private JPanel Bg;

    private JProgressBar barOne =new JProgressBar();
    NewOpen2(){
        setVisible(true);
//        setIconImage();
        setLayout(null);
        setBounds(0,0,1150,1000);
        this.setBackground(new Color(0x0AA1DD));

        setLocationRelativeTo(null);

//
//        logoNew  = new ImageIcon("src/PharmacyApp/Assets/Logo2.png");

        barOne.setLayout(null);
        barOne.setBounds(50,450,990,25);
        barOne.setBackground(new Color(0XE8F9FD));
        barOne.setForeground(new Color(0X2155CD));

        barOne.setStringPainted(true);

        Bg = new JPanel();
        Bg.setLayout(null);
        Bg.setBounds(0,0,1150,1000);
        Bg.setBackground(new Color(0x0AA1DD));
        Bg.add(barOne);

        add(Bg);

//        pack();
        fill();
    }
        public void fill(){
         int count = 0;
         while(count<=100){
             barOne.setValue(count);

             try{
                 Thread.sleep(500);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
             count+=5;
         }

        barOne.setString("ready");
        }
    public static void main(String[] args) {
        NewOpen2 pharmOpen = new NewOpen2();
    }
}
