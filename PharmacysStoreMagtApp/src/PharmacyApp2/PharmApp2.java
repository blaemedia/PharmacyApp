package PharmacyApp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class PharmApp2 extends JFrame implements ActionListener {
    private JLabel Cashier, MonitorHead, Header,FootageHolder, Header2,logo3Holder,logo3HolderText,closeMsg,OpenMsg,UserText,PassWText;
    private JPanel panel, panel2,ImageMonitor,OpeningPanel;
    private JTextField CustNameInput, userField;
    private JPasswordField UserPsswd;
    private JTextArea display;
    protected JList ProductList;
    private JMenuBar HealthMenu;
    private JMenu File;
    private JMenu Edit;
    private JMenu View;
    private JMenu Help;
    private JTabbedPane paneSwitch;
    private JSeparator Seperator;
    private JTable table;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    private Date obj = new Date();
    private String date = obj.toString();
    private int InvoiceNum = 500 + (int) (Math.random() * 1000);
    private String disInvoiceNum = String.valueOf(InvoiceNum);
    private String Title ="        INVOICE N0:" +"  "+ disInvoiceNum + "\n\n"+ "                   "
            +"  ++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "     "+"                                               "
            +
            " Health Plus(+) Pharmaceutical\n"
            +"                                              "
            +"  "+ date +
            "\n"+
            "                   "
            +"  ++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n\n\n\n"+"" +"       " +
             "Item"+"\t\t"+"Qty"+"\t"+"  "+" Unit"+"        "+"\t\t"+" Total "+"\n" +"\t\t\t"+ "  Price"+
            "\t\t"+" Price"+"\n"+"       -----------------------------------------------------------------------------------------------------------------"
            +"\n\n";

    ArrayList<String> drug2 = new ArrayList<>();
//    drug2 .
    private double total;
    private double Vat;
    private AddProducts2 RecentProduct;

    protected String AddingProduct="";
    protected String AddPrices="";

    protected Vector<String> Product = new Vector<>(100,1);
    protected Vector<ImageIcon>  ProductImage = new Vector<>(100,1);
    protected Vector<Double> Prices = new Vector<>(100,1);


    private double TotalPrice=0;
    private int QtyNum=0;
    JMenuItem Close,NewFile;

    PharmApp2() {
        //JFrame Setup:


        super("Health Plus(+) Product Purchase");

        ImageIcon logo2 = new ImageIcon("src/PharmacyApp/Assets/Logo2.png");
        setLayout(null);
        setSize(1150, 1000);
        setIconImage(logo2.getImage());
        setVisible(true);
        setLocation(400,10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        //Instantiating AddProductS Class
        RecentProduct = new AddProducts2();



        //Create Buttons

        btn1 = new JButton("Select Item & Qty");
        btn1.setFocusable(false);
        btn1.setBounds(415, 100, 150, 40);
        btn1.setEnabled(true);
        btn1.addActionListener(this);


        btn2 = new JButton("Add New Product");
        btn2.setFocusable(false);
        btn2.setBounds(10, 750, 150, 40);
        btn2.addActionListener(this);

        btn3 = new JButton("Calculate");
        btn3.setFocusable(false);
        btn3.setEnabled(false);
        btn3.setBounds(415, 200, 150, 40);
        btn3.addActionListener(this);


        btn4 = new JButton("Reset");
        btn4.setFocusable(false);
        btn4.setBounds(820, 750, 150, 40);
        btn4.addActionListener(this);

        btn5 = new JButton("Generate Invoice");
        btn5.setFocusable(false);
        btn5.setBounds(415, 750, 150, 40);
        btn5.setEnabled(false);
        btn5.addActionListener(this);

        btn6 = new JButton("Add 5% VAT");
        btn6.setFocusable(false);
        btn6.setEnabled(true);
        btn6.setBounds(415, 150, 150, 40);
        btn6.addActionListener(this);


        btn7 = new JButton("Sales Report");
        btn7.setFocusable(false);
        btn7.setBounds(970, 750, 150, 40);
        btn7.addActionListener(this);




        ImageIcon logo = new ImageIcon("src/PharmacyApp/Assets/Logo2.png");
        Header = new JLabel("HEALTH PLUS(+) PHARMACEUTICAL");
        Header.setFont(new Font("Roboto", Font.BOLD, 33));
        Header.setIcon(logo);
        Header.setIconTextGap(25);
        Header.setForeground(new Color(0x2155CD));
        Header.setBounds(50, 0, 1000, 100);

       String Address = "N0 30, Adenifuja Street, Ikosi Lagos,Tel:08062268921, Email:Healthplus@gmail.com";

        Header2 = new JLabel(Address);
        Header2.setFont(new Font("Roboto", Font.PLAIN, 15));
        Header2.setForeground(new Color(0x2155CD));
        Header2.setBounds(165, 32, 1000, 100);



//        String[] Drugs =  {"Paracetamol", "Amoxil Capsule", "Ampiclox         ", "Ampicillin          ",
//                "Septrin             ", "Ibuprofin         ", "Loratadine (Hovid)", "Shal'Artem(Malaria Drug)","bupivacaine  ","",};
//        for(int i=0;i<Drugs.length;i++){
//            Product.addElement(Drugs[i]);
//        }

        try{
            BufferedReader StoreDrugs = new BufferedReader(new FileReader("src/PharmacyApp2/Assets/DrugList.txt"));
            String line=null;
            System.out.print(line);

            while((line=StoreDrugs.readLine()) !=null){

                Product.addElement(line);

            }

        }catch(Exception v){

            System.out.print(v);
        }





//        Double[] ToPay = {600.00,1000.00, 350.00, 400.00,
//                100.00,500.00,700.00, 1500.00,1200.00,0.00};
//        for(int i=0;i<ToPay.length;i++){
//            Prices.addElement(ToPay[i]);
//        }

        try{
            BufferedReader PriceList = new BufferedReader(new FileReader("src/PharmacyApp2/Assets/PriceList.txt"));
            String Priceline=null;

            while((Priceline=PriceList.readLine()) !=null){

                double ToPay = Double.parseDouble(Priceline);
                Prices.addElement(ToPay);
            }

        }catch(Exception f){

            System.out.print(f);
        }




        ProductList = new JList();
        ProductList.setListData(Product);
        ProductList.setFixedCellWidth(100);
        ProductList.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, true));
        ProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ProductList.setBounds(10, 20, 400, 500);


        //Transaction Monitor
        display = new JTextArea();
        display.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, true));
        display.setText(Title);

        display.setEditable(false);
        display.setBounds(570, 20, 550, 500);


        //MenuBar Design:

        File = new JMenu("File");
        Edit = new JMenu("Edit");
        View = new JMenu("View");
        Help = new JMenu("Help");

        //MenuBar Design: File Items List
        NewFile = new JMenuItem("New File    Ctri+N");
        JMenuItem OpenFile = new JMenuItem("Open File Ctri+0");
        JMenuItem OpenRecent = new JMenuItem("Open Recent File");
        Close = new JMenuItem("Close Ctri+C");
        JMenuItem Save = new JMenuItem("Save File Ctri+s");
        JMenuItem Print = new JMenuItem("Print");
        JMenuItem Sendto = new JMenuItem("Send to email");
        JMenuItem Settings = new JMenuItem("Settings");

        //MenuBar Design: File Items List ----Change Font
        OpenFile.setFont(new Font("Roboto", Font.PLAIN, 12));
        NewFile.setFont(new Font("Roboto", Font.PLAIN, 12));
        OpenRecent.setFont(new Font("Roboto", Font.PLAIN, 12));
        Close.setFont(new Font("Roboto", Font.PLAIN, 12));
        Save.setFont(new Font("Roboto", Font.PLAIN, 12));
        Print.setFont(new Font("Roboto", Font.PLAIN, 12));
        Sendto.setFont(new Font("Roboto", Font.PLAIN, 12));
        Settings.setFont(new Font("Roboto", Font.PLAIN, 12));

        Close.addActionListener(this);
        NewFile.addActionListener(this);

        //MenuBar Design: Add Items List to File
        File.add(NewFile);
        File.add(OpenFile);
        File.add(OpenRecent);
        File.add(Close);
        File.add(Save);
        File.add(Print);
        File.add(Sendto);
        File.add(Settings);

        //MenuBar Design: Add Menus to the MenuBar
        HealthMenu = new JMenuBar();

        HealthMenu.add(File);
        HealthMenu.add(Edit);
        HealthMenu.add(View);
        HealthMenu.add(View);
        HealthMenu.add(Help);


        //Panels Setup

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0x0AA1DD));
        panel.setBounds(0, 105, 1150, 1000);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(0xE8F9FD));
        panel2.setBounds(0, 0, 1150, 100);



        logo3HolderText=new JLabel();
        logo3HolderText.setText("HealthPlus(+)Pharmaceutical");
        logo3HolderText.setFont(new Font("roboto",Font.PLAIN,30));
        logo3HolderText.setForeground(new Color(0x2155CD));
        logo3HolderText.setLayout(null);
        logo3HolderText.setBounds(370,200,1000,200);

        OpenMsg=new JLabel();
        OpenMsg.setText("Welcome");
        OpenMsg.setFont(new Font("roboto",Font.ITALIC,20));
        OpenMsg.setForeground(new Color(0x2155CD));
        OpenMsg.setLayout(null);
        OpenMsg.setBounds(510,800,1000,200);

        String credit=" A Project of IIHT Student - Semester II. (C)2023.";
        closeMsg=new JLabel();
        closeMsg.setText(credit);
        closeMsg.setFont(new Font("roboto",Font.ITALIC,20));
        closeMsg.setForeground(new Color(0x2155CD));
        closeMsg.setLayout(null);
        closeMsg.setBounds(350,800,1000,200);


//        adminText,PassWText;

        UserText=new JLabel();
        UserText.setText("UserID");
        UserText.setFont(new Font("roboto",Font.ITALIC,20));
        UserText.setForeground(new Color(0x2155CD));
        UserText.setLayout(null);
        UserText.setBounds(380,300,1000,200);

        PassWText=new JLabel();
        PassWText.setText("Password");
        PassWText.setFont(new Font("roboto",Font.ITALIC,20));
        PassWText.setForeground(new Color(0x2155CD));
        PassWText.setLayout(null);
        PassWText.setBounds(380,370,1000,200);

        userField=new JTextField();
        userField.setText("Enter your user Id");
        userField.setFont(new Font("roboto",Font.ITALIC,20));
        userField.setForeground(new Color(0x2155CD));
        userField.setLayout(null);
        userField.setBounds(480,385,250,35);

        UserPsswd=new JPasswordField();
//        UserPsswd.setText("Enter your password");
        UserPsswd.setFont(new Font("roboto",Font.ITALIC,20));
        UserPsswd.setForeground(new Color(0x2155CD));
        UserPsswd.setLayout(null);
        UserPsswd.setBounds(480,450,250,35);

        OpeningPanel= new JPanel();
        OpeningPanel.setLayout(null);
        OpeningPanel.setBackground(new Color(0xE8F9FD));
        OpeningPanel.setBounds(0, 0, 1150, 1000);



        String[] Images = {"src/PharmacyApp/Assets/ParacetamolImg.jpg","src/PharmacyApp/Assets/Amoxil.jpg","src/PharmacyApp/Assets/Ampiclox.jpg",
                            "src/PharmacyApp/Assets/Ampicillin.jpg","src/PharmacyApp/Assets/Septrin.jpg",
                            "src/PharmacyApp/Assets/Ibuprofen.jpg","src/PharmacyApp/Assets/Loratadine.jpg","src/PharmacyApp/Assets/Shal'Artem.jpg",
                            "src/PharmacyApp/Assets/bupivacaine.jpg","","",""};

        for (int i=0; i<Images.length;i++){
            ProductImage.add(new ImageIcon(Images[i]));
//            setLocationByPlatform(true);
        }



        FootageHolder=new JLabel("<<<<<  Medicine Description >>>>>");
        FootageHolder.setLayout(null);
        FootageHolder.setFont(new Font("Roboto",Font.TRUETYPE_FONT,20));
        FootageHolder.setForeground(Color.lightGray);
        FootageHolder.setBounds(400, 7, 800, 200);



        ImageMonitor = new JPanel();
        ImageMonitor.add(FootageHolder);
        ImageMonitor.setLayout(null);
        ImageMonitor.setBackground(new Color(0xE8F9FD));
        ImageMonitor.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
        ImageMonitor.setBounds(10, 525, 1110, 220);




//        ImageMonitor.add();


        ImageIcon logo3 = new ImageIcon("src/PharmacyApp/Assets/Logo2.png");
        logo3Holder = new JLabel();
        logo3Holder.setIcon(logo3);
        logo3Holder.setLayout(null);
        logo3Holder.setBounds(500,100,200,200);
        logo3Holder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panel2.setVisible(true);
                panel.setVisible(true);
                OpeningPanel.setVisible(false);
                try{
                    Thread.sleep(1000);
                }catch(Exception j){
                    j.printStackTrace();
                }
            }
        });




        //Adding Components to the Panel
        panel2.add(Header);
        panel2.add(Header2);
        panel.add(ProductList);
        panel.add(display);
        panel.add(ImageMonitor);
        panel.add(btn1);
//        panel2.add( FootageHolder);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);


        OpeningPanel.add(logo3Holder);
        OpeningPanel.add(logo3HolderText);
        OpeningPanel.add(UserText);
        OpeningPanel.add(userField);
        OpeningPanel.add(PassWText);
        OpeningPanel.add(UserPsswd);
        OpeningPanel.add(OpenMsg);



        //window setup
        setJMenuBar(HealthMenu);
        add(OpeningPanel);
        add(panel);
        add(panel2);



    }



    //Testing the Application
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String feel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        String feel2 = "com.seaglasslookandfeel.SeaGlassLookAndFeel";


        UIManager.setLookAndFeel(feel);
        PharmacyApp2.NewOpen2 open = new NewOpen2();

        open.setVisible(false);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        PharmApp2 app = new PharmApp2();


//        app.add(new OpeningBar());
        app.panel2.setVisible(false);
        app.panel.setVisible(false);

    }

    DecimalFormat twoDigit = new DecimalFormat("0.00");


    //Event Handling

    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource() == btn1) {

            if (ProductList.getSelectedValue() == null) {

                display.setEnabled(false);
            }  else {

                try{
                    int user=0;
                    user += Integer.parseInt(String.valueOf(JOptionPane.showInputDialog( "Enter the number of Quantity for the "

                            +ProductList.getSelectedValue())));
                    QtyNum=user;

                }

                catch(Exception exception){
                        int Re_use=JOptionPane.showConfirmDialog(null,"You must enter a value","",JOptionPane.ERROR_MESSAGE);
                if (Re_use==0){
                        int user=0;
                        user += Integer.parseInt(String.valueOf(JOptionPane.showInputDialog( "Enter the number of Quantity for the "

                                +ProductList.getSelectedValue())));
                        QtyNum=user;
                }else if(Re_use==1) {


                    btn1.setEnabled(false);
                    btn6.setEnabled(false);
                    }
                }


                }

            try {
                display.append("       "+   ProductList.getSelectedValue()+"\t"+"  "+QtyNum+"\t");


                TotalPrice=(Prices.get(ProductList.getSelectedIndex()))*QtyNum;
                display.append(Prices.get(ProductList.getSelectedIndex()) + "\t\t"+"  "+TotalPrice+"\n");

            }catch (Exception h){
                JOptionPane.showMessageDialog(null,"You have to make a product selection"+"\n"+"Press reset button to continue");
            }
//                total+=(Prices.get(ProductList.getSelectedIndex()));
                total+=TotalPrice;
                FootageHolder.setIcon(ProductImage.get(ProductList.getSelectedIndex()));
                FootageHolder.setBounds(7, 7, ProductImage.get(0).getIconWidth()-97, ProductImage.get(0).getIconHeight()-191);
                ImageMonitor.setBackground(Color.WHITE);


        } else if (e.getSource() == btn2) {
            int Decide = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to add new product to the Product list");

            if (Decide == 0) {
                RecentProduct = new AddProducts2();
                RecentProduct.setVisible(true);
                RecentProduct.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }

            RecentProduct.AddProductBtn.addActionListener(this);




        } else if (e.getSource() == btn3) {
            String TotalCal = String.valueOf(total + Vat);
            display.append("\n\n\n" +"       -----------------------------------------------------------------------------------------------------------------"+ "\n" + "       " +"Total:" + "   " + "\t\t\t\t\t" + "  " +
                    TotalCal + "\n\n\n\t\t" + "                   " + "THANK YOU!");
            btn5.setEnabled(true);
            btn3.setEnabled(false);
            btn6.setEnabled(false);
        } else if (e.getSource() == btn4) {

            display.setText("");
            total = 0;
            Vat = 0;
            btn3.setEnabled(false);
            display.setText(Title);
            btn5.setEnabled(false);
            btn1.setEnabled(true);
            btn6.setEnabled(true);
            FootageHolder.setIcon(null);

           FootageHolder.setBounds(400, 7, 800, 200);

           ImageMonitor.setBackground(new Color(0xE8F9FD));

           display.setEnabled(true);
        } else if (e.getSource() == btn5) {
            try {
                display.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == btn6) {
            btn3.setEnabled(true);
            Vat = (total * 5) / 100;
            String TotalCal = String.valueOf(total);
            display.append("\n" + "       " + "5% VAT: " + "\t\t\t\t\t" +"  "+  Vat);
            btn1.setEnabled(false);
            btn6.setEnabled(false);
        } else if (e.getSource() == btn7) {

        }
        else if (e.getSource()==RecentProduct.AddProductBtn) {

            try {
                AddingProduct = RecentProduct.ProductText.getText();
                BufferedWriter writeProduct = new BufferedWriter(new FileWriter("src/PharmacyApp2/Assets/DrugList.txt",true));
                writeProduct.write(AddingProduct);
                writeProduct.newLine();
                writeProduct.flush();
                writeProduct.close();

            }catch(Exception f){
                System.out.print(f);
            }



//           Product.addElement(AddingProduct);
//               ProductList.setListData(Product);

        }else if (e.getSource()==RecentProduct.AddPriceBtn) {
           AddPrices=RecentProduct.PriceText.getText();
           System.out.print(AddPrices);
//            AddPrices = Double.parseDouble(RecentProduct.PriceText.getText());
            try{
                BufferedWriter writePrice = new BufferedWriter(new FileWriter("src/PharmacyApp2/Assets/PriceList.txt",true));
                writePrice.write(AddPrices);
                writePrice.newLine();
                writePrice.flush();
                writePrice.close();




//                Prices.addElement(AddPrices);
//                display.append("   "+Prices.get(ProductList.getSelectedIndex()) + "\n");
            }catch(Exception u){
                System.out.print(u);
            }






        }else if (e.getSource()==Close) {
           OpeningPanel.add(closeMsg);
           OpenMsg.setText("");

           panel2.setVisible(false);
           panel.setVisible(false);
           OpeningPanel.setVisible(true);

           logo3Holder.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   super.mouseClicked(e);
                   System.exit(0);
                   OpeningPanel.setVisible(false);
                   try{
                       Thread.sleep(1000);
                   }catch(Exception j){
                       j.printStackTrace();
                   }
               }
           });

           try{
               Thread.sleep(1000);
           }catch(Exception d){
               d.printStackTrace();
           }

       }else if (e.getSource()==NewFile) {
           panel2.setVisible(true);
           panel.setVisible(true);
           OpeningPanel.setVisible(false);
           try{
               Thread.sleep(1000);
           }catch(Exception d){
               d.printStackTrace();
           }
       }

       }

    }






