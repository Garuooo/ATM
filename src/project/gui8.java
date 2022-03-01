
package project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;

public class gui8 extends JFrame implements ActionListener{
       
       
   JButton b1,b2,b3;
    JLabel l1,l2,l3,l7;
    JTextField d;
    
    ArrayList<Account> acc =aUser.getAccounts();;
    
    gui8() {

        l1 = new JLabel("Welcome to National Bank of Egypt!");
        l1.setBounds(30, 40, 300, 30);
        
        l2 = new JLabel("Transfer! Page");
        l2.setBounds(30, 80, 300, 30);

        add(l1);
        add(l2);

       l3 = new JLabel("Enter the amount to transfer");
       l3.setBounds(30, 120, 300, 30);
        
       
        add(l3);
       
       
        
        d=new JTextField();
        d.setBounds(30, 160, 300, 30);
 
        add(d);
        
        
        
        b1 = new JButton("transfer from Saving to Current");
        b1.setBounds(30, 200, 300, 30);
 
        b1.addActionListener(this); 
     
        
        b2 = new JButton("transfer from Current to Saving ");
        b2.setBounds(30, 240, 300, 30);
 
        b2.addActionListener(this); 
        
        b3 = new JButton("Cancel");
        b3.setBounds(30, 280, 300, 30);
 
        b3.addActionListener(this); 
        
        
        add(b1);
        add(b2);
        add(b3);
        
         l7 = new JLabel();
        l7.setBounds(30, 320, 360, 30);
        

        add(l7);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 460);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {


      

         if (e.getSource().equals(b1)) {
             Input s = new Input(d.getText());
             if(s.checkA())
             {double dd=Double.parseDouble(d.getText());
                 if((acc.get(1).getBalance())>=dd){
                    newAtm.transferFunds(aUser,0,1,dd);
                    this.dispose();
                     gui2 hh = new gui2();
                     hh.setVisible(true);
                 }
                 else{
                 l7.setText("Invalid input!max "+acc.get(0).getBalance());
                 }
            
             }else{
             l7.setText("Invalid input!");
             
             }
         }
             
             
             if (e.getSource().equals(b2)) {
             Input n = new Input(d.getText());
             if(n.checkA())
             {double dd=Double.parseDouble(d.getText());
                 if((acc.get(0).getBalance())>=dd){
                    newAtm.transferFunds(aUser,1,0,dd);
                    this.dispose();
                     gui2 hh = new gui2();
                     hh.setVisible(true);
                 }
                 else{
                 l7.setText("Invalid input!max "+acc.get(1).getBalance());
                 }
            
             }else{
             l7.setText("Invalid input!");
             
             }
             }
             
             
             if (e.getSource().equals(b3)) {
             
                     this.dispose();
                     gui2 hh = new gui2();
                     hh.setVisible(true);
             
             }

   //"Enter the amount to Withdraw (max"+acc.get(0).getBalance()+")" 
}}
