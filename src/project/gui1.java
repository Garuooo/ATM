
package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static project.NewMain.newAtm;
import static project.NewMain.theBank;
import static project.NewMain.aUser;


public class gui1 extends JFrame implements ActionListener{
  
    private JTextField textField ;
    private JPasswordField pass;       
    private JLabel label1 ;
    private JLabel label2;
    private JLabel label3,lb5 ;
    private JButton b1,b2;
   /* ATM newAtm = new ATM();
    Bank theBank = new Bank();
    User aUser;
   public gui1(String textField1, String text2,String passw){ 
   this.aUser = new User(textField1, text2,passw,theBank);
    
    }*/
   public gui1() {
        super("ATM");
        
        label1 = new JLabel("Welcome to ATM!");
        label2 = new JLabel("Enter ID ");
        label3 = new JLabel("Enter PIN ");
                         
        label1.setBounds(120, 30, 100, 40);
        label2.setBounds(40, 90, 80, 30);
        label3.setBounds(40, 130, 80, 30);  
       
         lb5=new JLabel();
        lb5.setBounds(80, 210, 210, 30);
        
        textField = new JTextField();  
        textField.setBounds(140, 90, 180, 30);
        
        pass = new JPasswordField();
        pass.setBounds(140,130, 180, 30);
        
        b1 =new JButton(" Login ");
        b1.setBounds(40,180 ,120 ,30 );
        b1.addActionListener(this);
        
        b2 =new JButton("New Account");
        b2.setBounds(180,180 ,120 ,30 );
        b2.addActionListener(this);  
       
        add(label1); 
        add(label2); 
        add(label3); 
        add(lb5);
        
        add(textField); 
        add(pass);
        
        add(b1);
        add(b2);
        
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    @Override
     public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {

            String passw = new String(pass.getPassword());
            
             aUser = newAtm.mainMenuPrompt(theBank, textField.getText(),passw);
            if (aUser == null) {
               lb5.setText("Invalid ID or PIN!");
            }else{
            this.dispose();
            gui2 hh = new gui2();
            hh.setVisible(true);
            }
        }
        if (e.getSource().equals(b2)) {
            this.dispose();
            gui3 hh = new gui3();
            hh.setVisible(true);

        }
    }
  
}
   
