
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class PayBill extends JFrame implements ActionListener{
    String meter1;
    Choice month;
    JButton pay,back;
    PayBill(String meter1)
    {
        this.meter1=meter1;
        
        setBounds(300,150,900,600);
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Electricity Bill");
        heading.setBounds(350,5,400,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(heading);
        
         
        
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(50,80,200,20);
        add(lblmeter);
        
         JLabel meter=new JLabel("");
        meter.setBounds(300,80,200,20);
        add(meter);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,140,200,20);
        add(lblname);
        
        JLabel name=new JLabel("");
      name.setBounds(300,140,200,20);
        add(name);
        
         JLabel lblmonth=new JLabel("Month");
        lblmonth.setBounds(50,200,200,20);
        add(lblmonth);
        
          month=new Choice();
        month.add("January");
        month.add("February");
        
        month.add("March");
         month.add("April");
        month.add("May");
         month.add("June");
        month.add("July"); 
        month.add("August");
        month.add("September");
        month.add("November");
        month.add("December");
       month.setBounds(300,200,200,20);
        add(month);
        
           JLabel lblunits=new JLabel("Units");
        lblunits.setBounds(50,260,200,20);
        add(lblunits);
        
         JLabel units=new JLabel("");
        units.setBounds(300,260,200,20);
        add(units);
        
        JLabel lbltotalbill=new JLabel("Total Bill");
      lbltotalbill.setBounds(50,320,200,20);
        add(lbltotalbill);
        
       JLabel totalbill=new JLabel();
      totalbill.setBounds(300,320,200,20);
         add(totalbill);
         
         JLabel lblstatus=new JLabel("Status");
      lblstatus.setBounds(50,380,200,20);
        add(lblstatus);
        
       JLabel status=new JLabel();
      status.setBounds(300,380,200,20);
      status.setForeground(Color.RED);
         add(status);
        
        try
         {
                connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from Customer where meter_no='"+meter1+"'");
        
             while(rs.next())
               {
                   name.setText(rs.getString("name"));
                  meter.setText(rs.getString("meter_no"));
                
                 
               }
             ResultSet rs1=c.s.executeQuery("select * from Bill where meter_no='"+meter1+"' and month='January'");
        
             while(rs1.next())
               {
                   units.setText(rs1.getString("units"));
                  totalbill.setText(rs1.getString("totalbill"));
                   status.setText(rs1.getString("status"));
                
                 
               }
           
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        month.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae)
            {
                   try
         {
                connect c=new connect();
          
             ResultSet rs1=c.s.executeQuery("select * from Bill where meter_no='"+meter1+"' and month='"+month.getSelectedItem()+"'");
        
             while(rs1.next())
               {
                   units.setText(rs1.getString("units"));
                  totalbill.setText(rs1.getString("totalbill"));
                   status.setText(rs1.getString("status"));
                
                 
               }
           
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
            }
            
        });
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100, 460, 100, 25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
    
        image.setBounds(400, 120, 600, 300);
        add(image);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                connect c = new connect();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no ='"+meter1+"' AND month='"+month.getSelectedItem()+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Pay(meter1);
        } else {
            setVisible(false);
        }
    }
     public static void main(String args[])
    {
        new PayBill("");
    }

}
