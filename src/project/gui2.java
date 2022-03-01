
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;

public class gui2 extends JFrame implements ActionListener{
       
   JButton b1,b2,b3,b4,b5,b6,b7;
    JLabel l1,l2,l6,l7,l8;
    JTextField s,c;
    
    ArrayList<Account> acc;
    
    gui2() {

        l1 = new JLabel("Welcome to National Bank of Egypt!");
        l1.setBounds(30, 40, 300, 30);
        
        l2 = new JLabel("What would you like to do?");
        l2.setBounds(30, 180, 300, 30);

        add(l1);
        add(l2);
        
        b1 = new JButton("Show Current account transaction history");
        b1.setBounds(30, 220, 300, 30);
        
        b7 = new JButton("Show Saving account transaction history");
        b7.setBounds(30, 260, 300, 30);
        
        b2 = new JButton("Withdraw from Current Account");
        b2.setBounds(30, 300, 300, 30);

        b6 = new JButton("Deposit in Current Account");
        b6.setBounds(30, 340, 300, 30);
        
        b4 = new JButton("Deposit in Saving Account");
        b4.setBounds(30, 380, 300, 30);
        
        b3 = new JButton("Transfer");
        b3.setBounds(30, 420, 300, 30);
        
        b5 = new JButton("Quit");
        b5.setBounds(30, 460, 300, 30);
        
        
        acc =aUser.getAccounts();
        l6 = new JLabel(aUser.getFirstName()+" accounts summary!");
        l6.setBounds(30, 80, 300, 30);
        l7 = new JLabel(acc.get(0).getSummaryLine());
        l7.setBounds(30, 120, 300, 30);
        l8 = new JLabel(acc.get(1).getSummaryLine());
        l8.setBounds(30, 140, 300, 30);
        
        add(l6);
        add(l7);
        add(l8);
        
        b1.addActionListener(this); 
        b2.addActionListener(this); 
        b3.addActionListener(this); 
        b4.addActionListener(this); 
        b5.addActionListener(this); 
        b6.addActionListener(this);
         b7.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
         add(b7);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(380, 580);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            this.dispose();
            gui9 hh = new gui9();
            hh.setVisible(true);
            }
        //Transfer
         if (e.getSource().equals(b3)) {
            this.dispose();
            gui8 hh = new gui8();
            hh.setVisible(true);

        }
        
        //Withdraw
        if (e.getSource().equals(b2)) {
            this.dispose();
            gui7 hh = new gui7();
            hh.setVisible(true);

        }

        //Deposit
       
         if (e.getSource().equals(b4)) {
            this.dispose();
            gui5 hh = new gui5();
            hh.setVisible(true);

        }
         //Deposit
         if (e.getSource().equals(b6)) {
            this.dispose();
            gui6 hh = new gui6();
            hh.setVisible(true);

        }
          
          //Quit
           if (e.getSource().equals(b5)) {
            this.dispose();
            gui1 hh = new gui1();
            hh.setVisible(true);

        }
           
           if (e.getSource().equals(b7)) {
            this.dispose();
            gui10 hh = new gui10();
            hh.setVisible(true);

        }
           
   
}
  
}

