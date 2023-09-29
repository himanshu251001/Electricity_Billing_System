package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class CalculateBill extends JFrame implements ActionListener {
    
JTextField tfcity,tfstate,tfpincode,tfemail,tfphone,unit;
 
JLabel lblmetert,tfname,tfaddress;
Choice meterlocation,metertype,phasecode,billtype, meternumber,month;
  JButton Submit,cancel;

    CalculateBill()
    {
        
        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
        JPanel p =new JPanel(); 
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Calculate Electricity Bill ");
        heading.setBounds(180,10,400,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,25));
         p.add(heading);
         
          JLabel lblmetern=new JLabel("Meter Number");
        lblmetern.setBounds(100,80,100,25);
        p.add(lblmetern);
        
        
        meternumber=new Choice();
         meternumber.setBounds(240,80,200,20);
         p.add(meternumber);
       try{
           connect c=new connect();
          ResultSet rs= c.s.executeQuery("Select * from Customer ");
          while(rs.next())
          {
              meternumber.add(rs.getString("Meter_no"));
              
          }
       }
      catch(Exception e)
      {
          e.printStackTrace();
          
      }
         
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100,120,100,20);
        p.add(lblname);
        
         tfname=new JLabel();
        tfname.setBounds(240,120,200,20);
         p.add(tfname);
         
         
      
        
         JLabel lbladdress=new JLabel("Address");
       lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
         tfaddress=new JLabel();
        tfaddress.setBounds(240,160,200,20);
         p.add( tfaddress);
      
       
         meternumber.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent ie)
         {
               try{
           connect c=new connect();
          ResultSet rs= c.s.executeQuery("Select * from Customer where meter_no= '"+meternumber.getSelectedItem()+"'");
          while(rs.next())
          {
             tfname.setText(rs.getString("Name"));
                tfaddress.setText(rs.getString("Address"));
             
              
          }
       }
      catch(Exception e)
      {
          e.printStackTrace();
          
      }
         }
});
          JLabel lblunits=new JLabel("Units Consumed");
      lblunits.setBounds(100,200,100,20);
        p.add(lblunits);
        
        unit=new JTextField();
       
        unit.setBounds(240,200,200,20);
        p.add(unit);
         
         JLabel tmonth=new JLabel("Months");
      tmonth.setBounds(100,240,100,20);
        p.add(tmonth);
        
         month=new Choice();
     month.add("January");
        month.add("February");
         month.add("January");
        month.add("March");
         month.add("April");
        month.add("May");
         month.add("June");
        month.add("July"); 
        month.add("August");
        month.add("September");
        month.add("November");
        month.add("December");
       month.setBounds(240,240,200,20);
         p.add(month);
         
         
        
       
        
       Submit=new JButton("Submit");
       Submit.setBounds(150,350,100,25);
      Submit.setBackground(Color.BLACK);
       Submit.setForeground(Color.WHITE);
       Submit.addActionListener(this);
       p.add(Submit);
       
        cancel=new JButton("Cancel");
       cancel.setBounds(300,350,100,25);
      cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       p.add(cancel);
       
      
       
       setLayout(new BorderLayout());
       add(p,"Center");
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
       Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image,"West");
       
       getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Submit)
        {
           
      
            String meter =meternumber.getSelectedItem();
            String units=unit.getText();
            String months =month.getSelectedItem();      
            
            int totalbill=0;
        
            String query="Select * from tax";
           
            
            try{
                connect c=new connect();
          ResultSet rs= c.s.executeQuery(query);
          
          while(rs.next())
          {
             
              totalbill+=Integer.parseInt(units)*Integer.parseInt(rs.getString("cost_per_unit"));
               totalbill+=Integer.parseInt(rs.getString("meter_rent"));
               totalbill+=Integer.parseInt(rs.getString("service_charge"));
                totalbill+=Integer.parseInt(rs.getString("service_tax"));
               totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
          }
                
                    JOptionPane.showMessageDialog(null,"Meter Information Added Succesfully");
                    setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            String query1="Insert into bill values('"+meter+"','"+months+"','"+units+"','"+totalbill+"','Not Paid')";
             try{
                connect c=new connect();
                c.s.executeUpdate(query1);
                
                    JOptionPane.showMessageDialog(null,"Customer Bill Updated Succesfully");
                    setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            
        }
    }
    public static void  main (String args[])
    {
        new  CalculateBill();
    }
    
}


