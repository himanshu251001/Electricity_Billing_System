
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateDetails extends JFrame implements ActionListener  {
    JTextField address,city,state,tfpincode,tfemail,tfphone;
    JButton cancel,update;
    String meter1;
    UpdateDetails(String meter1)
    {
        this.meter1=meter1;
        setBounds(200,100,1000,600);
       
        getContentPane().setBackground(new Color(173,216,230));
        setLayout(null);
        
      JLabel heading=new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(325,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(70,80,100,20);
        add(lblname);
        
        JLabel name=new JLabel("");
      name.setBounds(170,80,300,20);
        add(name);
        
        JLabel lblmeter=new JLabel("Meter Number");
       lblmeter.setBounds(70,140,100,20);
        add(lblmeter);
        
         JLabel meter=new JLabel("");
       meter.setBounds(170,140,300,20);
        add(meter);
        
         JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(70,200,100,20);
        add(lbladdress);
        
         address=new JTextField();
     address.setBounds(170,200,300,20);
        add(address);
        
           JLabel lblcity=new JLabel("City");
       lblcity.setBounds(70,260,100,20);
        add(lblcity);
        
        city=new JTextField();
  city.setBounds(170,260,300,20);
        add(city);
        
           JLabel lblstate=new JLabel("State");
        lblstate.setBounds(520,80,80,20);
        add(lblstate);
        
         state=new JTextField();
      state.setBounds(600,80,300,20);
        add(state);
        
         JLabel lblpicode=new JLabel("Pincode");
      lblpicode.setBounds(520,140,80,20);
        add(lblpicode);
        
        tfpincode=new JTextField();
     tfpincode.setBounds(600,140,300,20);
         add(tfpincode);
         
         JLabel lblemail=new JLabel("Email");
      lblemail.setBounds(520,200,80,20);
        add(lblemail);
        
     tfemail=new JTextField();
tfemail.setBounds(600,200,300,20);
         add(tfemail);
         
          JLabel lblphone=new JLabel("Phone");
lblphone.setBounds(520,260,80,20);
        add(lblphone);
        
      tfphone=new JTextField();
tfphone.setBounds(600,260,300,20);
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
         
         update=new JButton("Update");
update.setBounds(370,320,100,25);
update.setBackground(Color.BLACK);
update.setForeground(Color.WHITE);
update.addActionListener(this);
add(update); 

        cancel=new JButton("Cancel");
cancel.setBounds(520,320,100,25);
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.addActionListener(this);
add(cancel);
       
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/software.png"));
Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel image=new JLabel(i3);
image.setBounds(100,350,200,200);
add(image);

ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/software2.png"));
Image i5=i4.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
ImageIcon i6=new ImageIcon(i5);
JLabel image1=new JLabel(i6);
image1.setBounds(700,350,300,200);

add(image1);

setVisible(true);
       
               
        
    }
    public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource() == update)  
    {
         String tfaddress = address.getText();
         String tfcity = city.getText();
        String tfstate = state.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();
        String pincode=tfpincode.getText();

      try
      {
       connect c = new connect();
       c.s.executeUpdate("update customer set address ='"+tfaddress+"',city ='"+tfcity+"',state ='"+tfstate+"',email ='"+email+"',pincode ='"+pincode+"',PhoneNo='"+phone+"' where meter_no ='"+meter1+"'");

       JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
       setVisible(false);
      }   
      catch (Exception e)
      {
      e.printStackTrace();
       }
    } 
    else {
    setVisible(false);
     }
}
    public static void main(String args[])
    {
        new UpdateDetails("");
    }
}
