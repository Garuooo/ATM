
package project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;

public class gui10 extends JFrame implements ActionListener{
       
    JButton b1;
    JLabel l1,l2;
    JPanel p1;



    gui10() {

        l1 = new JLabel("Welcome to National Bank of Egypt!");
        l1.setBounds(30, 40, 300, 30);
        
        l2 = new JLabel("Transaction history for account "+aUser.getAcctUUID(1));
        l2.setBounds(30, 80, 300, 30);

        add(l1);
        add(l2);

        b1 = new JButton("Quit");
        b1.setBounds(30, 500, 250, 30);
    
        
        
        b1.addActionListener(this); 
     
        p1=new JPanel();
        p1.setBounds(30, 120, 520, 400);
       
        
       
        String[] ss=newAtm.showTransHistory(aUser, 1);
        for(int i=0;i<ss.length;i++)
        {   
             JLabel dd=new JLabel(ss[i]);
             dd.setBounds(5, 10+i*40, 500, 30);
             p1.add(dd);
        }
        add(b1);
       
     
        
        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600, 600);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            this.dispose();
            gui2 hh = new gui2();
            hh.setVisible(true);
            }

        }
           
 
}