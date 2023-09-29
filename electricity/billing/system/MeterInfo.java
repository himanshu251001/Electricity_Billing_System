
package electricity.billing.system;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.*;
public class MeterInfo extends JFrame implements ActionListener {
    

 
          JLabel lblmeter;
Choice meterlocation,metertype,phasecode,billtype;
  JButton Submit;
  String meternumber;
    MeterInfo(String meternumber)
    {
        this.meternumber=meternumber;
        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
        JPanel p =new JPanel(); 
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Meter Information ");
        heading.setBounds(180,10,240,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,25));
         p.add(heading);
         
          JLabel lblmetern=new JLabel("Meter Number");
        lblmetern.setBounds(100,80,100,20);
        p.add(lblmetern);
        
        
        
       lblmeter=new JLabel(meternumber);
        lblmeter.setBounds(240,80,100,20);
         p.add(lblmeter);
         
        JLabel lblname=new JLabel("Meter Location");
        lblname.setBounds(100,120,100,20);
        p.add(lblname);
        
        meterlocation=new Choice();
        meterlocation.add("Outside");
        meterlocation.add("Inside");
         meterlocation.setBounds(240,120,200,20);
        p.add(meterlocation);
         
      
        
        JLabel lbltype=new JLabel("Meter Type");
        lbltype.setBounds(100,160,100,20);
        p.add( lbltype);
        
       metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Smart Meter");
        metertype.add("Solar Meter");
         metertype.setBounds(240,160,200,20);
        p.add(metertype);
         
          JLabel lblphase=new JLabel("Phase Code");
      lblphase.setBounds(100,200,100,20);
        p.add(lblphase);
        
        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
       phasecode.add("033");
        phasecode.add("044");
         phasecode.add("055");
          phasecode.add("066");
           phasecode.add("077");
            phasecode.add("088");
             phasecode.add("099");
        phasecode.setBounds(240,200,200,20);
        p.add(phasecode);
         
         JLabel bill=new JLabel("Bill Type");
      bill.setBounds(100,240,100,20);
        p.add(bill);
        
         billtype=new Choice();
        billtype.add("Commercial");
        billtype.add("Domestic");
         billtype.setBounds(240,240,200,20);
         p.add(billtype);
         
         JLabel lblpicode=new JLabel("Days");
      lblpicode.setBounds(100,280,100,20);
        p.add(lblpicode);
        
       
         
         JLabel lblemail=new JLabel("30 Days");
      lblemail.setBounds(240,280,100,20);
        p.add(lblemail);
       
         
          JLabel lblnote=new JLabel("Note");
      lblnote.setBounds(100,320,100,20);
        p.add(lblnote);
        
        JLabel lblnotes=new JLabel("By Default Bill is calculated for 30 Days Only");
      lblnotes.setBounds(240,320,300,20);
        p.add(lblnotes);
        
       
        
       Submit=new JButton("Submit");
       Submit.setBounds(250,420,100,25);
      Submit.setBackground(Color.BLACK);
       Submit.setForeground(Color.WHITE);
       Submit.addActionListener(this);
       p.add(Submit);
       
      
       
       setLayout(new BorderLayout());
       add(p,"Center");
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
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
            //Choice meterlocation,metertype,phasecode,billtype;;
            String meter=meternumber;
            String location =meterlocation.getSelectedItem();
            String mtype=metertype.getSelectedItem();
            String code =phasecode.getSelectedItem();      
            String btype  = billtype.getSelectedItem();   
           String days="30";
            String query="insert into Meter_Info values('"+meter+"', '"+location+"', '"+mtype+"', '"+code+"', '"+btype+"', '"+days+"')";
           
            
            try{
                connect c=new connect();
                c.s.executeUpdate(query);
                
                    JOptionPane.showMessageDialog(null,"Meter Information Added Succesfully");
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
        new  MeterInfo("");
    }
    
}


