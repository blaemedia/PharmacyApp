package Practise.GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slider extends JFrame implements ChangeListener {
    JSlider slider; JPanel panel; JButton btn; JTextArea display;
    JLabel Label; JProgressBar bar;






    Slider(){
        super("Testing JSlider");

        bar = new JProgressBar(0,100);
        bar.setBounds(15,45,50,300);
        bar.setStringPainted(true);
        bar.setForeground(Color.red);


        //Slider creation

        slider = new JSlider(0,100,50);

        slider.setBounds(20,45,400,300);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);

        slider.setOrientation(SwingConstants.VERTICAL);

        slider.addChangeListener(this);


        // Slider Value label
        Label = new JLabel();
        Label.setBounds(300,300,100,30);
        Label.setFont(new Font("Roboto",Font.PLAIN,30));

        //Adding Component to the Slider
        panel=new JPanel();
        panel.add(slider);
        panel.add(Label);
        panel.add(bar);



        panel.setLayout(null);
//        panel.setVisible(true);s
        panel.setBounds(50,100,500,400);

        add(panel);

//        combo.setBounds(50,100,100,30);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setSize(600,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String feel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(feel);

        Slider radio = new Slider();
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        Label.setText(""+slider.getValue()+"Degree");
    }
}




