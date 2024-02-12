package Practise.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioTesting extends JFrame implements ActionListener {
    JRadioButton radioSel; JRadioButton radioSel1; JRadioButton radioSel2; JRadioButton radioSel3;
    JPanel radioPanel;

    JButton Submit;

    ButtonGroup group;
    radioTesting(){
        super("Testing RadioButton");

        radioSel = new JRadioButton("MSC Holder");
        radioSel.setBackground(null);
//        radioSel.setBounds(0,0,500,100);
        add(radioSel);

        radioSel1 = new JRadioButton("Bsc Holder");
        radioSel1.setBackground(null);
//        radioSel1.setBounds(100,0,500,100);


        radioSel2 = new JRadioButton("HND Holder");
        radioSel2.setBackground(null);
//        radioSel2.setBounds(200,0,500,100);


        radioSel3 = new JRadioButton("SSCE Holder");
        radioSel3.setBackground(null);
//
        group = new ButtonGroup();
        group.add(radioSel);
        group.add(radioSel1);
        group.add(radioSel2);
        group.add(radioSel3);

        radioPanel = new JPanel();
//        radioPanel.setSize(500,50);

        radioPanel.setLayout(new FlowLayout());
        radioPanel.setBackground(new Color(0xBDF2D5));
        radioPanel.add(radioSel);
        radioPanel.add(radioSel1);
        radioPanel. add(radioSel2);
        radioPanel. add(radioSel3);

        add(radioPanel);
        radioPanel.setBounds(30,50,500,30);

        radioSel.addActionListener(this);
        radioSel1.addActionListener(this);
        radioSel2.addActionListener(this);
        radioSel3.addActionListener(this);

//        JLabel btnCaption = new JLabel("Submit");
//        Submit.addActionListener(this);
//        Submit.add(btnCaption);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setSize(600,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String feel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        UIManager.setLookAndFeel(feel);

        radioTesting radio = new radioTesting();
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == radioSel){

            if(JOptionPane.showConfirmDialog(null,"Are you saying you have finished your Masters!")==0){
                JOptionPane.showMessageDialog(null,"You have been Employed as our CEO");
            }else{
                JOptionPane.showMessageDialog(null,"Which other qualification do you have?");
            }
        }else if(event.getSource() == radioSel1){
            if(JOptionPane.showConfirmDialog(null,"Are you saying you have finished your BSc!")==0){
                JOptionPane.showMessageDialog(null,"You have been Employed as our Manager");
            }else{
                JOptionPane.showMessageDialog(null,"Which other qualification do you have?");
            }
        }else if(event.getSource() == radioSel2){
            if(JOptionPane.showConfirmDialog(null,"Are you saying you have finished your HND!")==0){
                JOptionPane.showMessageDialog(null,"You have been Employed as our Supervisor");
            }else{
                JOptionPane.showMessageDialog(null,"Which other qualification do you have?");
            }
        }else if(event.getSource() == radioSel3){
            if(JOptionPane.showConfirmDialog(null,"Are you saying you have finished your SSCE!")==0){
                JOptionPane.showMessageDialog(null,"You have been Employed as our Field officer");
            }else{
                JOptionPane.showMessageDialog(null,"We can only employ you as a Casual/Factory worker!");
            }
        }
    }
}
