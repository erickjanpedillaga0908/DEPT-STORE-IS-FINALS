
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class accountPage{
    DefaultTableModel model;
    JTable table;
    String[][] data;
    String[] columnNames = {"Username", "Password", "Email"};
    JFrame FrameAccount = new JFrame("Account");

    JTextField usernameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JTextField emailText = new JTextField();
    
    public accountPage() {
      
        
        FrameAccount.setSize(700, 600);
        FrameAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameAccount.setLocationRelativeTo(null);
        
        FrameAccount.setLayout(null);
        
        JLabel label = new JLabel("Manage Accounts");
        label.setBounds(280, 50, 200, 40);
        //set font 
        Font font = new Font("Arial", Font.BOLD, 20);
        label.setFont(font);

        FrameAccount.add(label);
        

        //length of file
        int length = 0;
        try {
            Scanner sc = new Scanner(new File("account.txt"));
            while(sc.hasNextLine()) {
                length++;
                sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        data = new String[length][3];
        
        int i = 0;
        try {
            Scanner sc = new Scanner(new File("account.txt"));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" , ");
                //username password email
                data[i][0] = parts[0];
                data[i][1] = parts[1];
                data[i][2] = parts[2];
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       //default Table model
         model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setBounds(50, 100, 600, 200);
        FrameAccount.add(table);
        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 600, 200);
        FrameAccount.add(scrollPane);
        //clickable row but not editable
        table.setRowSelectionAllowed(true);

        
        JLabel addAccount = new JLabel("Add Account");
        addAccount.setBounds(50, 300, 200, 40);
        FrameAccount.add(addAccount);
        addAccount.setFont(font);
       
        JLabel username = new JLabel("Username");
        username.setBounds(50, 350, 100, 40);
        FrameAccount.add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(50, 400, 100, 40);
        FrameAccount.add(password);
      
        JLabel email = new JLabel("Email");
        email.setBounds(50, 450, 100, 40);
        FrameAccount.add(email);

       
        
        usernameText.setBounds(150, 350, 200, 40);
        FrameAccount.add(usernameText);

        passwordText.setBounds(150, 400, 200, 40);
        FrameAccount.add(passwordText);

        emailText.setBounds(150, 450, 200, 40);
        FrameAccount.add(emailText);


        //back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 500, 100, 40);
        FrameAccount.add(btnBack);
        btnBack.addActionListener(new back());

        //update button
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(250, 500, 100, 40);
        FrameAccount.add(btnUpdate);
        btnUpdate.addActionListener(new update());
        



        //add button
        JButton add = new JButton("Add");
        add.setBounds(400, 500, 100, 40);
        FrameAccount.add(add);
        add.addActionListener(new add());



        //delete button
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(550, 500, 100, 40);
        FrameAccount.add(btnDelete);
        btnDelete.addActionListener(new delete());
    

        FrameAccount.setVisible(true);

        



        
    }
    //back button
    class back implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            FrameAccount.dispose();
            new mainMenu();
        }
    }

    class update implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int i = table.getSelectedRow();
            String username = usernameText.getText();
            String password = passwordText.getText();
            String email = emailText.getText();
            if(i == -1 ){
                JOptionPane.showMessageDialog(null, "Please select a row to update");
            }
            else{
                if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                                if(i >= 0) {
                                    model.setValueAt(username, i, 0);
                                    model.setValueAt(password, i, 1);
                                    model.setValueAt(email, i, 2);
                                    try {
                                        FileWriter fileWriter = new FileWriter("account.txt");
                                        for(int j = 0; j < table.getRowCount(); j++) {
                                            fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + "\n");
                                        }
                                        fileWriter.close();
                                        JOptionPane.showMessageDialog(null, "Update Successful");
                                      
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                }

                }else{
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                }
            }
            

            

        }
    }

    class add implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            String username = usernameText.getText();
            String password = passwordText.getText();
            String email = emailText.getText();
            
        if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            
                        try{
                        File file = new File("account.txt");
                        FileWriter fileWriter = new FileWriter(file,true);
                        fileWriter.write(username + " , " + password + " , " + email+ "\n");
                        JOptionPane.showMessageDialog(null, "Add account Successful");
                        fileWriter.close();
                        FrameAccount.dispose();
                        new accountPage();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    usernameText.setText("");
                    passwordText.setText("");
                    emailText.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        }

        }
    }
  
    class delete implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("account.txt"));
                            for(int i = 0; i < table.getRowCount(); i++) {
                                for(int j = 0; j < table.getColumnCount(); j++) {
                                    bw.write(table.getValueAt(i, j).toString() + " , ");
                                }
                                bw.newLine();
                            }
                            bw.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
        }
    }



    
    
}

