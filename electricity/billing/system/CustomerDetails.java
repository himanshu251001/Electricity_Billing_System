
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class CustomerDetails extends JFrame implements ActionListener {
      Choice meternumber, month;
    JTable table;
    JButton search,print;
    CustomerDetails()
    {
       super("Customer Details");
      setSize(1000,600);
      setLocation(200,100);
        table=new JTable();
        try{
            connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from Customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        add(sp);
       
         print=new JButton("Print");
         print.addActionListener(this);
        add(print,"South");
        
           setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        
            try{
            table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    
    
    public static void  main(String args[])
    {
        new  CustomerDetails();
    }
}
