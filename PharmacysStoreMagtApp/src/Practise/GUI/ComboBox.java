package Practise.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ComboBox extends JFrame implements ActionListener {
    JComboBox combo;
    JPanel panel;
    JButton btn;
    JTextArea display;



    String[]  Courses = {"Agriculture","Mathematic","English","Economics","Account","Chemistry"};

    ComboBox(){
        super("Testing Combo");


        combo = new JComboBox(Courses);
        combo.setBounds(50,20,100,30);
        combo.addActionListener(this);
        combo.setMaximumRowCount(5);

        btn = new JButton("Add Courses");
        btn.setBounds(50,300,150,40);
        btn.addActionListener(this);

       display = new JTextArea();
       display.setSize(200,100);
       display.setBounds(50,100,300,100);

        panel=new JPanel();
        panel.add(combo);
        panel.add(display);
        panel.add(btn);


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

        ComboBox radio = new ComboBox();
    }

        public void actionPerformed(ActionEvent event) {
        if (event.getSource()==combo){
        display.append((String) combo.getSelectedItem() +"\n");
        }else if(event.getSource()==btn){
        String course=JOptionPane.showInputDialog("Add your favourite course");
        combo.insertItemAt(course,0);
        display.append("You just added one course "+course+"\n");


        }
}



}
