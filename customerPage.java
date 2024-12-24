import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.Font;

public class customerPage {
    JFrame FrameCustomer = new JFrame("Customer Information");
    
    JTextField textCustID = new JTextField(20);
    JTextField textCustName = new JTextField(20);
    JTextField textAge = new JTextField(20);
    
  
    
    JComboBox comboGender;
    JComboBox comboLevel;
    JComboBox comboVisit;
    JTextField textEmail = new JTextField(20);
    JTextField textAddress = new JTextField(20);
    JTextField textContactNumber = new JTextField(20);
    
    DefaultTableModel model;
    JTable table;


    public customerPage(){
        FrameCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        FrameCustomer.setLayout(null);
        FrameCustomer.setSize(1200, 500);
        Font font = new Font("Arial", Font.BOLD, 14);


        JLabel labelCustomer = new JLabel("Customer Information");
        labelCustomer.setBounds(100, 10, 160, 25);
        FrameCustomer.add(labelCustomer);
        labelCustomer.setFont(font);

      
        JLabel labelCustID = new JLabel("Customer ID");
        labelCustID.setBounds(10, 50, 80, 25);
        FrameCustomer.add(labelCustID);

       
        textCustID.setBounds(100, 50, 165, 25);
        FrameCustomer.add(textCustID);

     
        JLabel labelCustName = new JLabel("Name");
        labelCustName.setBounds(10, 80, 80, 25);
        FrameCustomer.add(labelCustName);

        textCustName.setBounds(100, 80, 165, 25);
        FrameCustomer.add(textCustName);

       
        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(10, 110, 80, 25);
        FrameCustomer.add(labelAge);

        
        textAge.setBounds(100, 110, 165, 25);
        FrameCustomer.add(textAge);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(10, 140, 80, 25);
        FrameCustomer.add(labelGender);

       
        String gender[] = {"Male","Female"};
        comboGender = new JComboBox(gender);
        comboGender.setBounds(100, 140, 165, 25);
        FrameCustomer.add(comboGender);

        JLabel labelCustLev = new JLabel("Level");
        labelCustLev.setBounds(10, 170, 80, 25);
        FrameCustomer.add(labelCustLev);
      
        String levels = "Regular, Member, VIP";
        String[] level = levels.split(",");
        comboLevel = new JComboBox(level);
       
        comboLevel.setBounds(100, 170, 165, 25);
        FrameCustomer.add(comboLevel);

        
        JLabel labelVisit = new JLabel("Time of Visit");
        labelVisit.setBounds(10, 200, 80, 25);
        FrameCustomer.add(labelVisit);

        String visitTime = "Between 7AM-12PM, Between 1PM-8PM, Between 9PM-11PM";
        String[] visit = visitTime.split(",");
        comboVisit = new JComboBox(visit);
        comboVisit.setBounds(100, 200, 165, 25);
        FrameCustomer.add(comboVisit);

      
        JLabel labelEmail = new JLabel("E-mail Address");
        labelEmail.setBounds(10, 230, 90, 25);
        FrameCustomer.add(labelEmail);

        textEmail.setBounds(100, 230, 165, 25);
        FrameCustomer.add(textEmail);

    
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(10, 260, 80, 25);
        FrameCustomer.add(labelAddress);

        textAddress.setBounds(100, 260, 165, 25);
        FrameCustomer.add(textAddress);


        JLabel labelContactNumber = new JLabel("Contact No.");
        labelContactNumber.setBounds(10, 290, 90, 25);
        FrameCustomer.add(labelContactNumber);

        textContactNumber.setBounds(100, 290, 165, 25);
        FrameCustomer.add(textContactNumber);
         
        JLabel labelTable = new JLabel("Customer Information Table");
        labelTable.setBounds(300, 10, 200, 30);
        FrameCustomer.add(labelTable);
        labelTable.setFont(font);


        int length = 0;
        try{
            Scanner sc = new Scanner(new File("customer.txt"));
            while(sc.hasNextLine()){
                length++;
                sc.nextLine();
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error");
        }

        String data[][] = new String[length][9];

        String column[] = {"Customer ID", "Name", "Age", "Gender", "Level","Time of Visit", "E-mail Address", "Address", "Contact Number"};

        int i = 0;
        try{
            Scanner sc = new Scanner(new File("customer.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data1 = line.split(",");
                data[i][0] = data1[0];
                data[i][1] = data1[1];
                data[i][2] = data1[2];
                data[i][3] = data1[3];
                data[i][4] = data1[4];
                data[i][5] = data1[5];
                data[i][6] = data1[6];
                data[i][7] = data1[7];
                data[i][8] = data1[8];
                i++;
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        model = new DefaultTableModel(data, column);
        table = new JTable(model);
        table.setBounds(300, 50, 800, 400);
        FrameCustomer.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 50, 800, 400);
        FrameCustomer.add(scrollPane);

        table.setRowSelectionAllowed(true);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(10, 320, 80, 25);
        FrameCustomer.add(buttonAdd);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(100, 320, 80, 25);
        FrameCustomer.add(buttonUpdate);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(190, 320, 80, 25);
        FrameCustomer.add(buttonDelete);

        JButton buttonClear = new JButton("Clear");
        buttonClear.setBounds(10, 350, 80, 25);
        FrameCustomer.add(buttonClear);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 350, 80, 25);
        FrameCustomer.add(buttonBack);

        FrameCustomer.setVisible(true);

        buttonAdd.addActionListener(new AddButton());
        buttonUpdate.addActionListener(new UpdateButton());
        buttonDelete.addActionListener(new DeleteButton());
        buttonClear.addActionListener(new ClearButton());
        buttonBack.addActionListener(new BackButton());
        
        
    }
    
    public class AddButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int x = table.getSelectedRow();
            String custID = textCustID.getText();
            String customerName = textCustName.getText();
            String age = textAge.getText();
            String sex = comboGender.getSelectedItem().toString();
            String level = comboLevel.getSelectedItem().toString();
            String visitTime = comboVisit.getSelectedItem().toString();
            String email = textEmail.getText();
            String address = textAddress.getText();
            String contactNumber = textContactNumber.getText();
            
            if(!custID.equals("") && !customerName.equals("") && !age.equals("")&& !textEmail.equals("") && !address.equals("") && !contactNumber.equals("")){
                                                    try{
                                                        File file = new File("customer.txt");
                                                        FileWriter fileWriter = new FileWriter(file,true);
                                                        fileWriter.write(custID + " , " +customerName+" , "+age+" , "+sex+" , "+level+" , " +visitTime+ " , "+email+" , " + address + " , " + contactNumber + "\n");
                                                        JOptionPane.showMessageDialog(null, "Added Successful");
                                                        fileWriter.close();
                                                    }catch(Exception ex){ex.printStackTrace();}
                                                        FrameCustomer.dispose();
                                                        new customerPage();
        
            }else{JOptionPane.showMessageDialog(null, "Please fill up all the fields");}

        }
    }

   
    public class UpdateButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int x = table.getSelectedRow();
            String custID = textCustID.getText();
            String customerName = textCustName.getText();
            String age = textAge.getText();
            String sex = comboGender.getSelectedItem().toString();
            String level = comboLevel.getSelectedItem().toString();
            String visitTime = comboVisit.getSelectedItem().toString();
            String email = textEmail.getText();
            String address = textAddress.getText();
            String contactNumber = textContactNumber.getText();
            if(x==-1){
                JOptionPane.showMessageDialog(null, "Please select a row to update");
            }
            else{
                if(!custID.equals("") && !customerName.equals("") && !age.equals("")&& !textEmail.equals("") && !address.equals("") && !contactNumber.equals("")){
                                                    if(x >= 0) {
                                                        model.setValueAt(custID, x, 0);
                                                        model.setValueAt(customerName, x, 1);
                                                        model.setValueAt(age, x, 2);
                                                        model.setValueAt(sex, x, 3);
                                                        model.setValueAt(level, x, 4);
                                                        model.setValueAt(visitTime, x, 5);
                                                        model.setValueAt(email, x, 6);
                                                        model.setValueAt(address, x, 7);
                                                        model.setValueAt(contactNumber, x, 8);
                                                        try {
                                                            FileWriter fileWriter = new FileWriter("customer.txt");
                                                            for(int j = 0; j < table.getRowCount(); j++) {
                                                                fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + " , " + model.getValueAt(j, 5).toString() + " , " + model.getValueAt(j, 6).toString() + " , " + model.getValueAt(j, 7).toString() + " , " + model.getValueAt(j, 8).toString() + "\n");
                                                            }
                                                            fileWriter.close();
                                                            JOptionPane.showMessageDialog(null, "Update Successful");
                                                           
                                                        } catch (IOException e1) {e1.printStackTrace();}
                                                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields");
                }

            }

        }
    }

    
    public class DeleteButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                        try {
                            FileWriter fileWriter = new FileWriter("customer.txt");
                            for(int j = 0; j < table.getRowCount(); j++) {
                                fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + " , " + model.getValueAt(j, 5).toString() + " , " + model.getValueAt(j, 6).toString() + " , " + model.getValueAt(j, 7).toString() + " , " + model.getValueAt(j, 8).toString() + "\n");
                            }
                            fileWriter.close();
                            JOptionPane.showMessageDialog(null, "Delete Successful");
                        } catch (IOException e1) {e1.printStackTrace();
                    }
                }
            }
        }
    }

    public class ClearButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            textCustID.setText("");
            textCustName.setText("");
            textAge.setText("");
            textEmail.setText("");
            textAddress.setText("");
            textContactNumber.setText("");
        }
    }

    
    public class BackButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            FrameCustomer.dispose();
            new mainMenu();
        }
    }
    


}
