import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class mainMenu {
    JFrame FrameMenu = new JFrame("Department Store IS");
    public mainMenu(){
        FrameMenu.setSize(300, 300);
        FrameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameMenu.setLocationRelativeTo(null);

        FrameMenu.setLayout(null);

        JButton buttonAccount = new JButton("Manage Accounts");
        buttonAccount.setBounds(50, 10, 200, 25);
        buttonAccount.addActionListener(new buttonAccountListener());
        FrameMenu.add(buttonAccount);
    
       
        JButton buttonCustomer = new JButton("Customer Information");
        buttonCustomer.setBounds(50, 50, 200, 25);
        buttonCustomer.addActionListener(new buttonCustomerListener());
        FrameMenu.add(buttonCustomer);

        JButton buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(50, 90, 200, 25);
        buttonLogout.addActionListener(new buttonLogoutListener());
        FrameMenu.add(buttonLogout);
        
        FrameMenu.setVisible(true);
        
    }

    class buttonAccountListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FrameMenu.dispose();
            new accountPage();
        }
    }
    class buttonCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FrameMenu.dispose();
            new customerPage();
            
            
        }
    }

    class buttonLogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FrameMenu.dispose();
            new loginForm();
        }
    }


}
