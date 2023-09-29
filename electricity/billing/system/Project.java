
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    String atype,meter1;
    Project(String atype,String meter1)
    {
        this.atype=atype;
        this.meter1=meter1;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/MainBoard.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,720,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        setLayout(new FlowLayout());
        
        JMenu master=new JMenu("Master");
        master.setForeground(Color.BLUE);
       
        
          JMenuItem newcustomer=new JMenuItem("New Customer");
          newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
          newcustomer.setBackground(Color.WHITE);
          ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
          Image image1 = icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
          newcustomer.setIcon(new ImageIcon(image1));
          newcustomer.setMnemonic('D');
          newcustomer.addActionListener(this);
          newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
          master.add(newcustomer);
        
        
        JMenuItem customerDetails=new JMenuItem("Customer Details");
         customerDetails.setFont(new Font("monospaced",Font.PLAIN,12));
         customerDetails.setBackground(Color.WHITE);
          ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
          Image image2 = icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
          customerDetails.setIcon(new ImageIcon(image2));
          customerDetails.setMnemonic('M');
           customerDetails.addActionListener(this);
          customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
            master.add( customerDetails);
      
       
         JMenuItem DepositDetails=new JMenuItem("Deposit Details");
          DepositDetails.setFont(new Font("monospaced",Font.PLAIN,12));
          DepositDetails.setBackground(Color.WHITE);
          ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
          Image image3 = icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
           DepositDetails.setIcon(new ImageIcon(image3));
           DepositDetails.setMnemonic('N');
            DepositDetails.addActionListener(this);
           DepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        master.add( DepositDetails);
       
          JMenuItem calculatebill=new JMenuItem("Calculate Bill");
          calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
          calculatebill.setBackground(Color.WHITE);
          ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
          Image image4 = icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
          calculatebill.setIcon(new ImageIcon(image4));
           calculatebill.setMnemonic('S');
            calculatebill.addActionListener(this);
          calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
       master.add( calculatebill);
       
    
        
        JMenu Info=new JMenu("Information");
        Info.setForeground(Color.BLUE);
      
        
         JMenuItem Update=new JMenuItem("Update Information");
         Update.setFont(new Font("monospaced",Font.PLAIN,12));
          Update.setBackground(Color.WHITE);
          ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
          Image image5 = icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         Update.setIcon(new ImageIcon(image5));
         Update.setMnemonic('A');
         Update.addActionListener(this);
          Update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        Info.add(Update);
        
        JMenuItem view=new JMenuItem("View Details");
          view.setFont(new Font("monospaced",Font.PLAIN,12));
          view.setBackground(Color.WHITE);
          ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
          Image image6 = icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
           view.setIcon(new ImageIcon(image6));
           view.setMnemonic('B');
           view.addActionListener(this);
          view.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
       Info.add(view);
       
       
         JMenu user=new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
         JMenuItem paybill=new JMenuItem("Pay Bill");
         paybill.setFont(new Font("monospaced",Font.PLAIN,12));
          paybill.setBackground(Color.WHITE);
          ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
          Image image7 = icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         paybill.setIcon(new ImageIcon(image7));
          paybill.setMnemonic('C');
           paybill.addActionListener(this);
           paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        user.add( paybill);
        
        JMenuItem billdetails=new JMenuItem("Bill Details");
          billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
          billdetails.setBackground(Color.WHITE);
          ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
          Image image8 = icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
           billdetails.setIcon(new ImageIcon(image8));
        billdetails.setMnemonic('F');
         billdetails.addActionListener(this);
          billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
       user.add(billdetails);
       
        
         JMenu report=new JMenu("Report");
     report.setForeground(Color.RED);
        
        
         JMenuItem generateBill=new JMenuItem("Generate Bill");
         generateBill.setFont(new Font("monospaced",Font.PLAIN,12));
          generateBill.setBackground(Color.WHITE);
          ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
          Image image9 = icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         generateBill.setIcon(new ImageIcon(image9));
         generateBill.setMnemonic('E');
          generateBill.addActionListener(this);
           generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        report.add( generateBill);
        
        
          JMenu Utility=new JMenu("Utility");
         Utility.setForeground(Color.RED);
       
        
         JMenuItem notepad=new JMenuItem("NotePad");
         notepad.setFont(new Font("monospaced",Font.PLAIN,12));
          notepad.setBackground(Color.WHITE);
          ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
          Image image10 = icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('G');
         notepad.addActionListener(this);
          notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
         Utility.add(notepad);
        
        JMenuItem calculator=new JMenuItem("Calculator");
         calculator.setFont(new Font("monospaced",Font.PLAIN,12));
          calculator.setBackground(Color.WHITE);
          ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
          Image image11 = icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
           calculator.setIcon(new ImageIcon(image11));
           calculator.setMnemonic('H');
            calculator.addActionListener(this);
          calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        Utility.add(calculator);
        
        
        JMenu exit=new JMenu("Exit");
     exit.setForeground(Color.BLUE);
      
        
        JMenuItem ex=new JMenuItem("Exit");
         ex.setFont(new Font("monospaced",Font.PLAIN,12));
         ex.setBackground(Color.WHITE);
          ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
          Image image12 = icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
           ex.setIcon(new ImageIcon(image12));
          ex.setMnemonic('Q');
          ex.addActionListener(this);
          ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
       exit.add(ex);
        
       if(atype.equals("Admin"))
         mb.add(master);
       else
       {
          mb.add(user);
          mb.add(report);
         
          mb.add(Info);
         
          
       
       }
        mb.add( Utility);
          mb.add(exit);
       setLayout(new FlowLayout());
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
          String msg=ae.getActionCommand();
        if(msg.equals("New Customer"))
        {
            new NewCustomer();
        }
        
        else  if(msg.equals("Deposit Details"))
        {
            new DepositDetails();
        }
        else  if(msg.equals("Calculate Bill"))
        {
           new CalculateBill();
            
        }
        else  if(msg.equals("Customer Details"))
        {
        new CustomerDetails();
            
        }
        else  if(msg.equals("Update Information"))
        {
            new UpdateDetails(meter1);
        }
         else  if(msg.equals("View Details"))
        {
            new ViewInformation(meter1);
        }
         else  if(msg.equals("Pay Bill"))
        {
            new PayBill(meter1);
        }
         else  if(msg.equals("Bill Details"))
        {
            new BillDetails(meter1);
        }
         else  if(msg.equals("Generate Bill"))
        {
          new GenerateBill(meter1);
        }
         else  if(msg.equals("NotePad"))
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
         else  if(msg.equals("Calculator"))
        {
             try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
         else  if(msg.equals("Exit"))
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[])
    {
        new Project("","");
    }
}
