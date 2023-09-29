
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GenerateBill extends JFrame implements ActionListener {
    JButton bill;
    Choice month;
    String meter2;
     JTextArea area;
    GenerateBill(String meter2)
    {
         
        this.meter2=meter2;
        setSize(500,735);
        setLocation(550,0);
        setLayout(new BorderLayout());
        JPanel panel=new JPanel();
        JLabel heading=new JLabel("Generate Bill");
        JLabel meter=new JLabel(meter2);
        panel.add(heading);
        panel.add(meter);
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
        panel.add(month);
        
         area=new JTextArea(50,15);
        area.setText("\n\t==========Click On the==========\t\t\n\t   Generate Bill Button to get  \n\t the bill of the selected Month");
        area.setFont(new Font("Senserif",Font.ITALIC,14));
        JScrollPane pane=new JScrollPane(area);
        
         bill=new JButton("Generate Bill");
         bill.addActionListener(this);
         
        add(panel,"North");
        add(pane,"Center");
        add(bill,"South");
        
        
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
 try
         {
                connect c=new connect();
            String months=month.getSelectedItem();
            area.setText("\n\tHM Power Limited\n ELECTRICITY BILL GENERATED FOR THE MONTH \n\t OF "+months+",2023\n ");
           
             ResultSet rs=c.s.executeQuery("select * from Customer where meter_no= '"+meter2+"'");
             if(rs.next())
               {
                   area.append("\n  Customer Name : "+rs.getString("name"));
                   area.append("\n  Meter No      : "+rs.getString("meter_no"));
                   area.append("\n  Address       : "+rs.getString("address"));
                   area.append("\n  City          : "+rs.getString("city"));
                   area.append("\n  State         : "+rs.getString("state"));
                   area.append("\n  Pincode       : "+rs.getString("pincode"));
                   area.append("\n  Email         : "+rs.getString("email"));
                   area.append("\n  PhoneNo       : "+rs.getString("PhoneNo"));
                   area.append("\n  ----------------------------------------------");
                 
               }
           rs=c.s.executeQuery("select * from meter_info where meter_no= '"+meter2+"'");
             if(rs.next())
               {
                   area.append("\n  Meter Location : "+rs.getString("location"));
                   area.append("\n  Meter Type     : "+rs.getString("Meter_Type"));
                   area.append("\n  Phase Code     : "+rs.getString("PhaseCode"));
                   area.append("\n  Bill Type      : "+rs.getString("Bill_type"));
                   area.append("\n  Days           : "+rs.getString("Days"));
                   area.append("\n  ----------------------------------------------");
                
                 
               }
                rs=c.s.executeQuery("select * from tax");
                 if(rs.next())
               {
                   area.append("\n  Cost Per Unit : "+rs.getString("cost_per_unit"));
                   area.append("\n  Meter Rent     : "+rs.getString("meter_rent"));
                   area.append("\n  Service Charge     : "+rs.getString("service_charge"));
                   area.append("\n  Service Tax      : "+rs.getString("service_tax"));
                   area.append("\n  Swachh Bharat Cess         : "+rs.getString("swacch_bharat_cess"));
                   area.append("\n  Fixed Tax         : "+rs.getString("fixed_tax"));
                   area.append("\n  ----------------------------------------------");
                
                 
               }
                       rs=c.s.executeQuery("select * from bill where meter_no= '"+meter2+"' and month='"+months+"'");
             if(rs.next())
               {
                    area.append("\n");
                area.append("\n    Current Month: " + rs.getString("month"));
                area.append("\n    Units Consumed:     " + rs.getString("units"));
                area.append("\n    Total Charges:        " + rs.getString("totalbill"));
                area.append("\n-------------------------------------------------------");
                area.append("\n  Total Payable        :"+rs.getString("totalbill"));
                 area.append("\n-------------------------------------------------------");
               }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }

}
    public static void main(String[] args) {
new GenerateBill("");
}
}
