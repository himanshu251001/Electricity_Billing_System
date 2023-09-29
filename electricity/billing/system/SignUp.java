
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener{
    JButton create,back;
    Choice Iplogginin;
    JLabel meter,lbtype,lbusername, username,lbuserpassword;
     JTextField Ipmeter,Ipusername,Ipuusername,Ippassword;
   SignUp()
    {
        super("SignUp Page");
        getContentPane().setBackground(Color.WHITE);  //getContentpane gives us the control whole panel
         setLayout(null);
         
          JPanel panel = new JPanel();
        panel.setBounds(0, 0, 624, 281);
        panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
       
       add(panel);
         
            
             
          lbtype=new JLabel("Create Account  as");
        lbtype.setBounds(70,20,150,20);
        panel.add(lbtype);
        
     Iplogginin=new Choice();
    Iplogginin.add("Admin");
    Iplogginin.add("Customer");
    Iplogginin.setBounds(220,20,150,20);
    panel.add(Iplogginin);
    
   
         
      meter=new JLabel("Meter Number");
        meter.setBounds(70,80,100,20);
        meter.setVisible(false);
        panel.add(meter);
        
         Ipmeter=new JTextField();
        Ipmeter.setBounds(220,80,150,20);
         Ipmeter.setVisible(false);
         panel.add(Ipmeter);
         
          
        
          lbusername=new JLabel("Username");
        lbusername.setBounds(70,120,100,20);
         panel.add(lbusername);
        
         Ipusername=new JTextField();
        Ipusername.setBounds(220,120,150,20);
         panel.add(Ipusername);
  
         
                  
         username=new JLabel("Name");
        username.setBounds(70,160,100,20);
         panel.add(username);
         
        
         Ipuusername=new JTextField();
        Ipuusername.setBounds(220,160,150,20);
         panel.add(Ipuusername);
         Ipmeter.addFocusListener(new FocusListener(){
               
               public void focusGained(FocusEvent fe)
               {
                   
               }
                public void focusLost(FocusEvent fe)
               {
                   try{
                       connect c=new connect();
                       ResultSet rs=c.s.executeQuery("select * from Login where meter_no='"+Ipmeter.getText()+"'");
                       while(rs.next())
                       {
                            Ipuusername.setText(rs.getString("name"));
                       }
                   }
                   catch(Exception e)
                   {
                       e.printStackTrace();
                   }
               }
           });

        
           lbuserpassword=new JLabel("Password");
        lbuserpassword.setBounds(70,200,100,20);
         panel.add(lbuserpassword);
        
         Ippassword=new JTextField();
       Ippassword.setBounds(220,200,150,20);
        panel.add(Ippassword);
        
        Iplogginin.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae)
            {
                String user=Iplogginin.getSelectedItem();
                if(user.equals("Customer"))
                {
                     meter.setVisible(true);
                      Ipmeter.setVisible(true);
                      Ipuusername.setEditable(false);
                }
                else
                {
                    meter.setVisible(false);
                      Ipmeter.setVisible(false);
                }
            }
            
        });
         
      
   
   create=new JButton("Create");
    create.setBackground(Color.BLACK);
    create.setForeground(Color.WHITE);
    create.setBounds(100,240,100,20);
    create.addActionListener(this);
     panel.add(create);
    
     
     back=new JButton("Back");
      back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(220,240,100,20);
    back.addActionListener(this);
     panel.add(back);
    
 
        
       ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));  //ImageIcon class is use to set image over the frame
    Image i11=i10.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
    ImageIcon i12=new ImageIcon(i11);
     JLabel image=new JLabel(i12);
     image.setBounds(420,30,200,200);
         panel.add(image);   
        
        setSize(640,320);
        setLocation(400,200);
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==create)
       {
           String atype=Iplogginin.getSelectedItem();
           String susername= Ipusername.getText();
           String sname=Ipuusername.getText();
           String spassword=Ippassword.getText();
           String smeter=Ipmeter.getText();
           
           try{
               connect c=new connect();
               String  query=null ;
                if(Iplogginin.equals("Admin"))
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                    else
                    query="Update login set User_Name='"+susername+"',Password='"+spassword+"',User='"+atype+"' where meter_no='"+smeter+"'";
              
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Account Created Succesfully");
               setVisible(false);
               new Login();
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
           
       }
       else if(ae.getSource()==back)
               {
                     setVisible(false);  
                   new Login();
               }
       
           
   }
    public static void main(String[] args)
    {
        new SignUp();
    }
    
}
