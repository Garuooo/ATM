
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;

public class gui7 extends JFrame implements ActionListener{
       
   JButton b1,b2,b3,b4,b5;
    JLabel l1,l2,l7,l8,l3;
    JTextField d,m;
    
    ArrayList<Account> acc;
    
    gui7() {

        l1 = new JLabel("Welcome to National Bank of Egypt!");
        l1.setBounds(30, 40, 300, 30);
        
        l2 = new JLabel("Withdraw! Page");
        l2.setBounds(30, 80, 300, 30);

        add(l1);
        add(l2);

       
       acc =aUser.getAccounts();
        l7 = new JLabel("Enter the amount to Withdraw (max"+acc.get(0).getBalance()+")" );
        l7.setBounds(30, 120, 360, 30);
        
        l8 = new JLabel("Enter a memo ");
        l8.setBounds(30, 200, 300, 30);
        
        
        l3 = new JLabel();
        l3.setBounds(30, 300, 300, 30);
        
        add(l7);
        add(l8);
        add(l3);
        
        d=new JTextField();
        d.setBounds(30, 160, 300, 30);
        m=new JTextField();
        m.setBounds(30, 240, 300, 30);
        
        
        add(m);
        add(d);
        
        
        
        b3 = new JButton("ok");
        b3.setBounds(180, 280, 100, 30);
 
        b3.addActionListener(this); 
     
        
        add(b3);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 460);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {


         //Enter the amount to withdraw (max $10.00): $7.25

         if (e.getSource().equals(b3)) {
             Input s = new Input(d.getText(),m.getText());
             if(s.checkAM())
             {double dd=Double.parseDouble(d.getText());
                 if((acc.get(0).getBalance())>=dd){
                    aUser.addAcctTransaction(0, -1*dd, m.getText());
                    this.dispose();
                     gui2 hh = new gui2();
                     hh.setVisible(true);
                 }
                 else{
                 l3.setText("Invalid input!");
                 }
            
             }else{
             l3.setText("Invalid input!");
             
             }

   
}}
}