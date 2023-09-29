
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable { //Runnable is multithreading
    Thread t;
    Splash()
    {   super("Welcome to Electricity Billing System");                                                                                     // ClassLoader,getsystemResourcce function  is use to get image from the device
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/splash1.jpg"));  //ImageIcon class is use to set image over the frame
        Image i2=i1.getImage().getScaledInstance(711,500,Image.SCALE_DEFAULT);         //it is used to upscale the image
        ImageIcon i3=new ImageIcon(i2);                                                   //we cannot pass Image object to Jlable so convert it into ImageIcon object
        JLabel image=new JLabel(i3);
        add(image);                                                                      //use to place image on frame;
        setVisible(true);                                                                // make the screen visible
        
        int x=195;
        for(int i=2;i<500;i+=4)
        {
        setSize(i+x,i);                                                                 //set the size of frame
        setLocation(600-((i+x-170)/2),350-(i/2));                                         //to set location dynamically
        try{
            Thread.sleep(2);
        }
        catch(Exception e){
           e.printStackTrace();
                    }
          
        }
        t=new Thread(this);
        t.start();
    }            //set opening position of frame 
       public void run(){
           try {
               Thread.sleep(5000);
                setVisible(false); 
                new Login();
        
                             //login frame
           }
           catch(Exception e){
           e.printStackTrace();
                    }
       }
    
    public static void main(String[] args)
{
        new Splash();
    }
}
