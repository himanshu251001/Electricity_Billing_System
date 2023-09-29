package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class Pay extends JFrame implements ActionListener{

String meter1;
JButton back;
Pay(String meter1) {
this.meter1 = meter1;

JEditorPane j = new JEditorPane();
j.setEditable(false);

try {
j.setPage("https://paytm.com/online-payments");
} catch (Exception e) {
j.setContentType("text/html");
j.setText("<html>Could not load<html>");

}

JScrollPane pane = new JScrollPane(j);
add(pane);

back = new JButton("Back");
back.setBounds(640, 20, 80, 30);
back.addActionListener(this);
j.add(back);

setSize(800, 600);
setLocation(400, 100);
setVisible(true);

}

public void actionPerformed(ActionEvent ae) {
setVisible(false);
new PayBill(meter1);
}

public static void main(String[] args) {
new Pay("");
}
}