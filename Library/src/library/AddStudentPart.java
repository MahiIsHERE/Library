package library; 

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddStudentPart {
    
    private JFrame frame;
    // a frame or windew for the program
    JPanel panel;
    // a JPanel to organize the components(parts)
    private Student student;
    // an object from student class
    JTextField textField_name , textField_stdNumber , textField_password;
    // name, student number & password fields
    JLabel label_name , label_stdNumber , label_title , label_password , label_level;
    // name, student number, password, title & level fields' label
    JComboBox<String> comboBox_level , comboBox_department;
    // comboBox for level & department

    
    // the main constructor
    public AddStudentPart(JFrame frame) {
        
        this.frame = frame;
        // represent the main frame in the class
        frame.setVisible(true);
        // the frame is visible (by default)

        methodPanel();
        // show the panel
        methodLabel();
        // show the fields' label
        buttons();
        // show the buttons
        methodTextField();
        // show the text field

        ComboBox();
        // show the ComboBox
        
    }

    
    public void buttons() {
        
        JButton btn_back = new JButton("بازگشت");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_back.addActionListener(e -> {
            new AdminPart(frame);
        });
        // button info:
        methodButton(btn_back , 250 , 370 , panel , Color.white , 80 , 30);

        
        JButton btn_save = new JButton("ذخیره");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_save.addActionListener(e -> {
            try {
                btn_save();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        // button info:
        methodButton(btn_save , 50 , 370 , panel , Color.white , 80 , 30);

    }
    

    // save button function
    public void btn_save() throws IOException {
        
        if (textField_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "نام دانشجو وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (textField_stdNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "شماره دانشجویی وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (textField_password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "کلمه عبور وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (isNumber(textField_stdNumber.getText())==false) {
            JOptionPane.showMessageDialog(frame , "شماره دانشجویی وارد شده نامعتبر است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else {
            // student object from student class
            student = new Student(textField_stdNumber.getText() , textField_name.getText() , getLevel(comboBox_level.getSelectedIndex())
                    , getDepartment(comboBox_department.getSelectedIndex()) , textField_password.getText());
            SaveInfo.addStudent(student);
            // append/add student to the file
            new AdminPart(frame);
            // return to librarian section
            JOptionPane.showMessageDialog(frame , "دانشجو با موفقیت اقزوده شد." , "پیام" , JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    
    public Department getDepartment(int i) {
        // 'i' is the index of comboBox items
        
        // with the comboBox order
        if (i==0) {
            return Department.Computer_Engineering;
        }
        else if (i==1) {
            return Department.Electrical_Engineering;
        }
        else {
            return Department.Science;
        }
        
    }
    

    public Level getLevel(int i) {
        // 'i' is the index of comboBox items
        
        // with the comboBox order
        if (i==0) {
            return Level.Bachelor;
        }
        else if (i==1) {
            return Level.Master;
        }
        else {
            return Level.PHD;
        }
        
    }

    
    // check if student number is numeric or not
    public boolean isNumber(String text) {
        
        if (text.isEmpty() || text.equals(null)) {
            return false;
        }
        
        try {
            int check = Integer.parseInt(text);
            return true;
            // if integer ---> true
        } catch(NumberFormatException e) {
            return false;
            // else ---> false
        }
        
    }

    
    public void ComboBox() {
        
        // level:
        String array1[] = {"Bachelor" , "Master" , "PHD"};
        comboBox_level = new JComboBox<>(array1);
        // a comboBox with array1 items
        methodComboBox(comboBox_level , panel , Color.white , 50 , 250 , 100 , 25);

        // department
        String array2[] = {"Computer" , "Electrical" , "Science"};
        comboBox_department = new JComboBox<>(array2);
        // a comboBox with array2 items
        methodComboBox(comboBox_department , panel , Color.white , 210 , 250 , 100 , 25);
        // appearance
        
    }

    
    // appearance
    public void methodComboBox(JComboBox<String> comboBox , JPanel panel , Color color , int x , int y , int i , int j) {
        
        comboBox.setBounds(x , y , i , j);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        // gave in the argument
        comboBox.setVisible(true);
        // is visible
        comboBox.setBackground(color);
        // background color of the text field
        panel.add(comboBox);
        // add label to the frame by panel
    }

    
    public void methodLabel() {
        
        label_title = new JLabel("افزودن دانشجو");
        // label is given at first
        label_title.setVisible(true);
        // is visible
        label_title.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        // font of the title
        methodLabel(label_title , 140 , 30, panel, Color.white, 230, 25);
        // apearance

        
        label_stdNumber = new JLabel("شماره دانشجویی: ");
        // label is given at first
        label_stdNumber.setVisible(true);
        // is visible
        methodLabel(label_stdNumber , 140 , 100 , panel , Color.white , 230 , 25);
        // apearance

        
        label_name = new JLabel("نام: ");
        // label is given at first
        label_name.setVisible(true);
        // is visible
        methodLabel(label_name , 340 , 100 , panel , Color.white , 230 , 25);
        // apearance

        
        label_password = new JLabel("کلمه عبور: ");
        // label is given at first
        label_password.setVisible(true);
        // is visible
        methodLabel(label_password , 215 , 170 , panel , Color.white , 230 , 25);
        // apearance

        
        label_level = new JLabel("مقطع: ");
        // label is given at first
        label_level.setVisible(true);
        // is visible
        methodLabel(label_level , 160 , 250 , panel , Color.white , 230 , 25);
        // apearance

        
        label_level = new JLabel("دانشکده: ");
        // label is given at first
        label_level.setVisible(true);
        // is visible
        methodLabel(label_level , 320 , 250 , panel , Color.white , 230 , 25);
        // apearance
        
    }

    
    // student number, name & password field
    public void methodTextField() {
        
        // student number field
        textField_stdNumber = new JTextField("");
        textField_stdNumber.setVisible(true);
        // is visible
        methodTextField(textField_stdNumber , 30 , 100 , panel , Color.white , 100 , 25);
        // apearance

        // student name field
        textField_name = new JTextField("");
        textField_name.setVisible(true);
        // is visible
        methodTextField(textField_name , 230 , 100 , panel , Color.white , 100 , 25);
        // apearance

        // password field
        textField_password = new JTextField("");
        textField_password.setVisible(true);
        // is visible
        methodTextField(textField_password , 110 , 170 , panel , Color.white , 100 , 25);
        // apearance
        
    }

    
    public void methodLabel(JLabel label , int x , int y , JPanel panel , Color color , int i , int j) {
        
        label.setBounds(x , y , i , j);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        // gave in the argument
        label.setVisible(true);
        // is visible
        label.setBackground(color);
        // background color of the text field
        panel.add(label);
        // add label to the frame by panel
        
    }

    
    public void methodTextField(JTextField textField , int x , int y , JPanel panel , Color color , int i , int j) {
        
        textField.setBounds(x , y , i , j);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        // gave in the argument
        textField.setVisible(true);
        // is visible
        textField.setBackground(color);
        // background color of the text field
        panel.add(textField);
        // add text field to the frame by panel
        
    }

    
    // a JPanel to organize the components(parts)
    public void methodPanel(){
        
        panel = new JPanel();
        // creat a new JPanel
        panel.setVisible(true);
        // is visible
        panel.setSize(400 , 500);
        // size of the panel
        panel.setLayout(null);
        // not yet
        frame.setContentPane(panel);
        // it will be added to the frame as a root pane(part) ---> it's kinda a child root
        
    }

    
    // the button appearance 
    public void methodButton(JButton btn , int x , int y , JPanel panel , Color color , int i , int  j) {
        
        btn.setBounds(x , y , i , j);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        // gave in the argument
        btn.setVisible(true);
        // is visible
        btn.setBackground(color);
        // background color of the button
        // gave the color in the argument
        panel.add(btn);
        // add button to the frame by panel
        
    }
    
}