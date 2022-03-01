
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui4 extends JFrame implements ActionListener {
    private JLabel label1 ;
    private JLabel label2;
    private JLabel label3 ;
    private JLabel label4 ;
    private JButton b2;
 
    
    gui4(String first,String last,String pin,String id) {

        super("ATM");
        
        label1 = new JLabel("Welcome to ATM! Information of your Account");
        label2 = new JLabel("your First Name "+first);
        label3 = new JLabel("your Last Name "+last);
        label4 = new JLabel("your ID "+id);
                         
        label1.setBounds(100, 30, 260, 40);
        label2.setBounds(80, 90, 180, 30);
        label3.setBounds(80, 130, 180, 30);  
        label4.setBounds(80, 170, 210, 30);
        
  
        b2 =new JButton(" OK ");
        b2.setBounds(180,230 ,120 ,30 );
        b2.addActionListener(this);  
       
        add(label1); 
        add(label2); 
        add(label3); 
        add(label4);
        
        add(b2);
        
        setLayout(null);
        setSize(500, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
 @Override
     public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(b2)) {
            this.dispose();
            gui1 hh = new gui1();
            hh.setVisible(true);

        }
    }
}
