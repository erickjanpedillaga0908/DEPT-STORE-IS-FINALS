import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;

public class loginForm extends JFrame  {
    JFrame FrameLogin = new JFrame("Login Form");
    ImageIcon icon = new ImageIcon("logo.png");
    
    Font font = new Font("Verdana", Font.BOLD, 15);
    Font font2 = new Font("Verdana", Font.BOLD, 12);

    JTextField textUsername = new JTextField(20);
    JPasswordField textPassword = new JPasswordField(20);

    public loginForm(){
        FrameLogin.setSize(300, 280);
        FrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameLogin.setLocationRelativeTo(null);
        FrameLogin.setIconImage(icon.getImage());
        JLabel labelLogin = new JLabel("Login Form");
        labelLogin.setBounds(95, 10, 120, 25);
        labelLogin.setFont(font);
        FrameLogin.add(labelLogin);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 50, 80, 25);
        labelUsername.setFont(font2);
        FrameLogin.add(labelUsername);
        
        textUsername.setBounds(100, 50, 165, 25);
        FrameLogin.add(textUsername);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 90, 80, 25);
        labelPassword.setFont(font2);
        FrameLogin.add(labelPassword);
        
        textPassword.setBounds(100, 90, 165, 25);
        FrameLogin.add(textPassword);

        JButton buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(10, 160, 120, 25);
        FrameLogin.add(buttonLogin);

        JButton buttonReg = new JButton("REGISTER");
        buttonReg.setBounds(150, 160, 120, 25);
        FrameLogin.add(buttonReg);

        buttonLogin.addActionListener(new buttonLoginListener());
        buttonReg.addActionListener(new buttonRegListener());


        FrameLogin.setLayout(null);
        FrameLogin.setVisible(true);

    }

   public void authentication(){
        String username= textUsername.getText();
        String password = textPassword.getText();
        String line = "";
        
        File file = new File("account.txt");
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill up the form");
            }
            try (Scanner scan = new Scanner(file)) { // di nagana pag walang try catch
                while(scan.hasNextLine()){
                    line = scan.nextLine();
                    String[] datasplit = line.split(" , ");
                    if(username.equals(datasplit[0]) && password.equals(datasplit[1])){
                        FrameLogin.dispose();
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        new mainMenu();

                       
                    }
                }
            }catch (FileNotFoundException e){ e.printStackTrace();}
            
            textUsername.setText("");
            textPassword.setText("");

           
            
        
    }
    class buttonLoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
          authentication();
          

        }
    }

    class buttonRegListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            FrameLogin.dispose();
            new registrationForm();
        }
    }

    
    

}
