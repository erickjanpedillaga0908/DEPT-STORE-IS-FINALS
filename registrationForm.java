import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import java.awt.Font;
public class registrationForm extends JFrame   {
  
    JFrame FrameReg = new JFrame("Registration Form");
    ImageIcon icon = new ImageIcon("logo.png");
    JTextField textUsername = new JTextField(20);
    JPasswordField textPassword = new JPasswordField(20);
    JTextField textEmail = new JTextField(20);
    Font font = new Font("Verdana", Font.BOLD, 15);
    Font font2 = new Font("Verdana", Font.BOLD, 12);
    public registrationForm() {
       
        FrameReg.setSize(300, 300);
        FrameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameReg.setLocationRelativeTo(null);
        
        FrameReg.setIconImage(icon.getImage());

        //FrameReg.getContentPane().setBackground(Color.decode("#fbbb3c"));
      
        FrameReg.setLayout(null);
        
        JLabel labelReg = new JLabel("Registration Form");
        labelReg.setBounds(75, 10, 170, 25);
        labelReg.setFont(font);
        FrameReg.add(labelReg);
        
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 50, 80, 25);
        FrameReg.add(labelUsername);
        labelUsername.setFont(font2);
       
        textUsername.setBounds(100, 50, 165, 25);
        FrameReg.add(textUsername);
        

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 80, 80, 25);
        FrameReg.add(labelPassword);
        labelPassword.setFont(font2);
        
        textPassword.setBounds(100, 80, 165, 25);
        FrameReg.add(textPassword);


        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 110, 80, 25);
        FrameReg.add(labelEmail);
        labelEmail.setFont(font2);
        
        textEmail.setBounds(100, 110, 165, 25);
        FrameReg.add(textEmail);

        //button for registration and login
        JButton buttonReg = new JButton("REGISTER");
        buttonReg.setBounds(10, 160, 120, 25);
        //buttonReg.setBackground(Color.GREEN);
        buttonReg.setFont(font2);
        
        FrameReg.add(buttonReg);
        

        JButton buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(150, 160, 120, 25);
        //buttonLogin.setBackground(Color.GREEN);
        buttonLogin.setFont(font2);
        FrameReg.add(buttonLogin);

        
        buttonReg.addActionListener(new ButtonRegListener());
        buttonLogin.addActionListener(new ButtonLoginListener());

        FrameReg.setVisible(true);
       

    }

  


    class ButtonRegListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String username = textUsername.getText();
            String password = textPassword.getText();
            String email = textEmail.getText();
            
        if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            try{
                File file = new File("account.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(username + " , " + password + " , " + email+ "\n");
                JOptionPane.showMessageDialog(null, "Registration Successful");
                fileWriter.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                    textUsername.setText("");
                    textPassword.setText("");
                    textEmail.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        }
        }
    }
    
    class ButtonLoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            FrameReg.dispose();
            new loginForm();
        }
    }

   


   
    
}
