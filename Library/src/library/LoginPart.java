package library;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginPart {
    
    JFrame frame;
    // a frame or windew for the program
    JPanel panel;
    // a JPanel to organize the components(parts)
    JTextField textField_Username , textField_Password;
    // username & password fields
    JLabel label_username , label_password , label_title;
    // username & password fields' lable
    ArrayList<Student> students = new ArrayList<>(); // or JList<String>
    
    
    // the main constructor
    // sections info:
    public LoginPart(JFrame frame){
        
        this.frame = frame;
        // represent the main frame in the class
        frame.setVisible(true);
        // the frame is visible (by default)
        
        methodPanel();
        // show the panel
        methodTextField();
        // show the text field
        methodLabel();
        // show the fields' label
        
        buttons();
        // show the login button

    }
    
    
    public void buttons(){
        
        JButton btn_login = new JButton("ورود");
        // name of the button is given at first
        
        // the function which will run by pressing button
        btn_login.addActionListener((e) -> {
            // if the username and password is correct, go to sections
            // else, just show the message 
            if (textField_Username.getText().equals("admin") && textField_Password.getText().equals("library")) {
                JOptionPane.showMessageDialog(frame , ".مسئول کتابخانه با موفقیت وارد شد" , "پیام" , JOptionPane.INFORMATION_MESSAGE);
                new AdminPart(frame);
                // will go to libarian section
            }
            else{
                Student student = SaveInfo.loginStudent(textField_Username.getText(),textField_Password.getText());
                if (student==null){
                    JOptionPane.showMessageDialog(frame , "!اطلاعات وارد شده نادرست است" , "پیام" , JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(frame , ".دانشجو با موفقیت وارد شد" , "پیام" , JOptionPane.INFORMATION_MESSAGE);
                    new StudentPart(frame , student);
                    // will go to student section
                }
            }
        });
        
        // button info:
        methodButton(btn_login , 160 , 260 , panel , Color.white , 60 , 30);
        
    }
    
    
    // username & password fields
    public void methodTextField() {
        
        // username field
        textField_Username = new JTextField("");
        textField_Username.setVisible(true);
        // is visible
        textField_Username.setBounds(80 , 140 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width , heigth, the same as the setSize
        textField_Username.setBackground(Color.white);
        // background color of the field
        panel.add(textField_Username);
        // add username field to the frame by panel

        // password field
        textField_Password = new JTextField("");
        textField_Password.setVisible(true);
        // is visible
        textField_Password.setBounds(80 , 185 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        textField_Password.setBackground(Color.white);
        // background color of the field
        panel.add(textField_Password);
        // add password field to the frame by panel
        
    }
    
    
    // username & password fields' lable
    public void methodLabel(){
        
        // title label
        label_title = new JLabel("منوی ورود کاربر");
        label_title.setVisible(true);
        // is visible
        label_title.setBounds(130 , 40 , 200 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_title.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        // set fonts for the title
        label_title.setBackground(Color.white);
        // background color of the title
        panel.add(label_title);
        // add title label to the frame by panel

        // username label
        label_password = new JLabel("نام کاربری: ");
        label_password.setVisible(true);
        // is visible
        label_password.setBounds(260 , 140 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_password.setBackground(Color.white);
        // background color of the label
        panel.add(label_password);
        // add password label to the frame by panel

        // password label
        label_username = new JLabel("کلمه عبور: ");
        label_username.setVisible(true);
        // is visible
        label_username.setBounds(260 , 185 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_username.setBackground(Color.white);
        // background color of the label
        panel.add(label_username);
        // add username label to the frame by panel
        
    }
    
    
    // a JPanel to organize the components(parts)
    public void methodPanel() {
        
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
    public void methodButton(JButton btn , int x , int y , JPanel panel  , Color color , int i , int  j) {
        
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
        // add button label to the frame by panel
        
    }
    
}