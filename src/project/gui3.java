
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;

public class gui3 extends JFrame implements ActionListener{
    private JLabel label1 ;
    private JLabel label2;
    private JLabel label3 ;
    private JLabel label4,lb5;
    private JButton b1,b2;
    private JTextField textField1 ;
    private JTextField textField2;
    private JPasswordField pass; 
    
    gui3() {

        super("ATM");
        
        label1 = new JLabel("Welcome to ATM! New Account Page");
        label2 = new JLabel("Enter your First Name ");
        label3 = new JLabel("Enter your Last Name ");
        label4 = new JLabel("Enter your PIN from 4 digits ");
                         
        label1.setBounds(100, 30, 220, 40);
        label2.setBounds(40, 90, 180, 30);
        label3.setBounds(40, 130, 180, 30);  
        label4.setBounds(40, 170, 210, 30);
        lb5=new JLabel();
        lb5.setBounds(40, 260, 210, 30);
        
    
        textField1 = new JTextField();  
        textField1.setBounds(220, 90, 180, 30);
        
        textField2 = new JTextField();  
        textField2.setBounds(220, 130, 180, 30);
        
        pass = new JPasswordField();
        pass.setBounds(220,170, 180, 30);
        
        b1 =new JButton(" OK ");
        b1.setBounds(60,230 ,120 ,30 );
        b1.addActionListener(this);
        
        b2 =new JButton(" Cancel ");
        b2.setBounds(200,230 ,120 ,30 );
        b2.addActionListener(this);  
       
        add(label1); 
        add(label2); 
        add(label3); 
        add(label4);
        add(lb5);
       
        
        add(textField1); 
        add(textField2); 
        add(pass);
 
        add(b1);
        add(b2);
        
        setLayout(null);
        setSize(500, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
 @Override
     public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
             String passw = new String(pass.getPassword());
              Input n=new Input(textField1.getText(),textField2.getText(),passw);
              
              
              if (n.checkFLP()) {
                     aUser = theBank.addUser(textField1.getText(), textField2.getText(),passw);
                    this.dispose();
                    gui4 hh = new gui4(textField1.getText(), textField2.getText(),passw,aUser.getUUID());
                    hh.setVisible(true);
              }
              else{
                 lb5.setText("Invalid Name or PIN!");  
             
              }
        }
        if (e.getSource().equals(b2)) {
            this.dispose();
            gui1 hh = new gui1();
            hh.setVisible(true);

        }
    }
}
