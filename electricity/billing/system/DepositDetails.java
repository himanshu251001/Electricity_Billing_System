package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
    Choice meternumber, month;
    JTable table;
    JButton search,print;
    DepositDetails()
    {
        super("Deposit Details");
        
        setSize(700,700);
        setLocation(400,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblmeternumber=new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20,20,150,20);
        add( lblmeternumber);
        setVisible(true);
        
       meternumber=new Choice();
          meternumber.setBounds(180,20,100,20);
        add(meternumber);
        
        try{
            connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                meternumber.add(rs.getString("meter_no"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel lblmonth=new JLabel("Search By Month");
       lblmonth.setBounds(380,20,100,20);
        add( lblmonth);
     
        
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
        month.setBounds(500,20,100,20);
        add( month);
        
        table=new JTable();
        try{
            connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
         print=new JButton("Print");
         print.addActionListener(this);
        print.setBounds(120,70,80,20);
        add(print);
        
           setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
           
           
            
            int totalbill=0;
        
            String query="Select * from bill where meter_no='"+meternumber.getSelectedItem()+"'and month='"+month.getSelectedItem()+"'";
           
            
            try{
                connect c=new connect();
          ResultSet rs= c.s.executeQuery(query);
          table.setModel(DbUtils.resultSetToTableModel(rs));
         
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try{
            table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
     public static void  main (String args[])
    {
        new  DepositDetails();
    }

}
