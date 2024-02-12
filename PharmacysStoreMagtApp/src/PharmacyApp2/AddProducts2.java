package PharmacyApp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProducts2 extends JFrame implements ActionListener {


    protected String[] TryProduct= new String[100];
    private JPanel panel;

    JButton AddProductBtn ,AddPriceBtn;
    protected JTextField ProductText,PriceText;



    AddProducts2(){

//        Product.add("AddingProduct");

        ProductText = new JTextField();
        ProductText.setLayout(null);
        ProductText.setEditable(true);
//        ProductText.setFocusable(false);
        ProductText.setBounds(55,85,300,40);

        PriceText = new JTextField(30);
        PriceText.setLayout(null);
        PriceText.setEditable(true);
//        PriceText.setFocusable(false);
        PriceText.setBounds(55,215,300,40);

        AddProductBtn = new JButton("Add Product Name");
        AddProductBtn.setLayout(null);
        AddProductBtn.setFocusable(false);
        AddProductBtn.setBounds(130,130,150,40);
        AddProductBtn.addActionListener(this);

        AddPriceBtn = new JButton("Add Product Price");
        AddPriceBtn.setLayout(null);
        AddPriceBtn.setFocusable(false);
        AddPriceBtn.setBounds(130,260,150,40);
        AddPriceBtn.addActionListener(this);



        panel = new JPanel();
//        setPreferredSize(new Dimension(300,500));
        panel.setBackground(new Color(0x0AA1DD));
        panel.setLayout(null);
        panel.setBounds(0,0,420,420);

        panel.add(AddProductBtn);
        panel.add(AddPriceBtn);
        panel.add(ProductText);
        panel.add(PriceText);

        add(panel);
        setResizable(false);
        setSize(420,420);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);



//
    }

    public static void main(String[] args) {

        AddProducts2 add = new AddProducts2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==AddProductBtn){
//            AddingProduct=ProductText.getText();
//            Product.addElement(AddingProduct);
//            System.out.print(Product);
//
//        }

    }

}
