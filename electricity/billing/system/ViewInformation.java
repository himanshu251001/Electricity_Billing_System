
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewInformation extends JFrame implements ActionListener  {
    JButton cancel;
    String meter1;
    ViewInformation(String meter1)
    {
        this.meter1=meter1;
        setBounds(350,80,850,650);
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("VIEW CUSTOMER");
        heading.setBounds(325,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(70,60,100,20);
        add(lblname);
        
        JLabel name=new JLabel("");
      name.setBounds(170,60,200,20);
        add(name);
        
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(70,120,100,20);
        add(lblmeter);
        
         JLabel meter=new JLabel("");
        meter.setBounds(170,120,200,20);
        add(meter);
        
         JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(70,180,100,20);
        add(lbladdress);
        
         JLabel address=new JLabel("");
       address.setBounds(170,180,200,20);
        add(address);
        
           JLabel lblcity=new JLabel("City");
        lblcity.setBounds(70,240,100,20);
        add(lblcity);
        
         JLabel city=new JLabel("");
       city.setBounds(170,240,200,20);
        add(city);
        
           JLabel lblstate=new JLabel("State");
        lblstate.setBounds(470,60,100,20);
        add(lblstate);
        
         JLabel state=new JLabel("");
       state.setBounds(570,60,200,20);
        add(state);
        
         JLabel lblpicode=new JLabel("Pincode");
      lblpicode.setBounds(470,120,100,20);
        add(lblpicode);
        
        JLabel tfpincode=new JLabel();
       tfpincode.setBounds(570,120,200,20);
         add(tfpincode);
         
         JLabel lblemail=new JLabel("Email");
      lblemail.setBounds(470,180,100,20);
        add(lblemail);
        
       JLabel tfemail=new JLabel();
      tfemail.setBounds(570,180,200,20);
         add(tfemail);
         
          JLabel lblphone=new JLabel("Phone");
      lblphone.setBounds(470,240,100,20);
        add(lblphone);
        
       JLabel tfphone=new JLabel();
       tfphone.setBounds(570,240,200,20);
         add(tfphone);
         setVisible(true);
        
         try
         {
                connect c=new connect();
            ResultSet rs=c.s.executeQuery("select * from Customer where meter_no='"+meter1+"'");
             while(rs.next())
               {
                   name.setText(rs.getString("name"));
                 address.setText(rs.getString("address"));
                  city.setText(rs.getString("city"));
                   state.setText(rs.getString("state"));
                 
                   tfemail.setText(rs.getString("email"));
                    tfpincode.setText(rs.getString("pincode"));
                     tfphone.setText(rs.getString("phoneno"));
                  meter.setText(rs.getString("meter_no"));
                
                 
               }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
          cancel=new JButton("Cancel");
       cancel.setBounds(330,300,100,25);
        cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
      cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
       Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(20,350,600,300);
       add(image);
       
               
        
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            
        }
    }
    public static void main(String args[])
    {
        new ViewInformation("");
    }
}
