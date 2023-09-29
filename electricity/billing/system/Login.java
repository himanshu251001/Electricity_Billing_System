
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
   JButton login,SignUp,Cancel;
   JTextField Ipusername,Ippassword;
   Choice Iplogginin;
    Login()
    {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);  //getContentpane gives us the control whole panel
         setLayout(null);
         
         JLabel lbusername=new JLabel("Username");
        lbusername.setBounds(300,20,100,20);
        add(lbusername);
        
         Ipusername=new JTextField();
        Ipusername.setBounds(400,20,150,20);
        add(Ipusername);
        
          JLabel lbuserpassword=new JLabel("Password");
        lbuserpassword.setBounds(300,70,100,20);
        add(lbuserpassword);
        
         Ippassword=new JTextField();
       Ippassword.setBounds(400,70,150,20);
        add(Ippassword);
        
        
         JLabel lbtype=new JLabel("Log in as");
        lbtype.setBounds(300,120,100,20);
        add(lbtype);
        
  Iplogginin=new Choice();
    Iplogginin.add("Admin");
    Iplogginin.add("Customer");
    Iplogginin.setBounds(400,120,150,20);
    add(Iplogginin);
      
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));  //ImageIcon class is use to set image over the frame
    Image i2=i1.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
     login=new JButton("Login",i3);
    login.addActionListener(this);
    login.setBounds(330,170,100,20);
    add(login);
    
      ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));  //ImageIcon class is use to set image over the frame
    Image i5=i4.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    ImageIcon i6=new ImageIcon(i5);
     SignUp=new JButton("SignUp",i6);
    SignUp.setBounds(450,170,100,20);
     SignUp.addActionListener(this);
    add(SignUp);
    
      ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));  //ImageIcon class is use to set image over the frame
    Image i8=i7.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
    ImageIcon i9=new ImageIcon(i8);
       Cancel=new JButton("Cancel",i9);
    Cancel.setBounds(390,210,100,20);
     Cancel.addActionListener(this);
    add(Cancel);
        
       ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));  //ImageIcon class is use to set image over the frame
    Image i11=i10.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
    ImageIcon i12=new ImageIcon(i11);
     JLabel image=new JLabel(i12);
     image.setBounds(0,0,250,250);
        add(image);   
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==login)
       {
           String susername=Ipusername.getText();
           String spassword=Ippassword.getText();
           String user=Iplogginin.getSelectedItem();
           
           try{
               connect c=new connect();
               String query="select * from Login where User_Name= '"+susername+"'and Password='"+spassword+"' and User='"+user+"'";
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next())
               {
                   String meter1=rs.getString("Meter_No");
                   setVisible(false);
                   new Project(user,meter1);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid Credentials");
                   Ipusername.setText("");
                   Ippassword.setText("");
                   
                   
               }
                
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
           
       }
       else if(ae.getSource()==SignUp)
               {
                   new SignUp();
               }
       else
          setVisible(false);
           
   }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
