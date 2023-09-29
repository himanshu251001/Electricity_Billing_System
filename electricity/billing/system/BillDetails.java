
package electricity.billing.system;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class BillDetails extends JFrame {
    String meter1;
    JTable table;
    BillDetails(String meter1)
{
    super("Bill Details");
     this.meter1=meter1;
    
   
 setSize(700,650);
setLocation(400,150);
 getContentPane().setBackground(Color.WHITE);
  table=new JTable();
   
 
   try
         {
                connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from bill where meter_no='"+meter1+"'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
           
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);
         
setVisible(true);
}
      public static void main(String args[])
    {
        new BillDetails("");
    }
}
