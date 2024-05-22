package library;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Formatter;

public class BorrowingBookPart {
    
    private JFrame frame;
    // a frame or windew for the program
    private JPanel panel;
    // a JPanel to organize the components(parts)
    private JTextField stdNumber , BookID , days;
    // student number, book ID & borrowed days field
    private JLabel label_username , label_password , label_title , label_days;
    // username, password, title & borrowed days fields' lable

    
    // the main constructor
    public BorrowingBookPart(JFrame frame) {
        
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
            save();
        });
        // button info:
        methodButton(btn_save , 50 , 370 , panel , Color.white , 80 , 30);
        
    }

    
    // check if book ID is numeric or not
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

    
    public void save() {
        
        if (stdNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "!شماره دانشجویی وارد نشده است" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (BookID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "!کد کتاب وارد نشده است", "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (isNumber(stdNumber.getText())==false) {
            JOptionPane.showMessageDialog(frame , "!شماره دانشجویی وارد شده نامعتبر است" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (isNumber(BookID.getText())==false) {
            JOptionPane.showMessageDialog(frame , "!شماره دانشجویی وارد شده نامعتبر است" , "پیام" , JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (isNumber(days.getText())==false) {
            JOptionPane.showMessageDialog(frame , "!تعداد روز وارد شده نامعتبر است" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else {
            int indexBook = SaveInfo.checkBook(Integer.parseInt(BookID.getText()));
            if (indexBook == -1) {
                JOptionPane.showMessageDialog(frame , "!کتاب مورد نظر موجود نمی باشد" , "پیام", JOptionPane.WARNING_MESSAGE);
            }
            else if (indexBook == -2){
                JOptionPane.showMessageDialog(frame , "!کتاب مورد نظر در امانت می باشد" , "پیام", JOptionPane.WARNING_MESSAGE);
            }
            else {
                int indexStudent = SaveInfo.checkStudent(stdNumber.getText());
                ;
                if (indexStudent == -1) {
                    JOptionPane.showMessageDialog(frame , "!دانشجوی مورد نظر موجود نمی باشد" , "پیام", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    try {
                        Dates date1 = new Dates(new Date());
                        SaveInfo.addBorrowBook(new BorrowBook(SaveInfo.books.get(indexBook).getId() , SaveInfo.students.get(indexStudent).getStdNumber()
                                , date1 , new Dates(date1 , Integer.parseInt(days.getText()))));
                        buttons();
                        SaveInfo.books.get(indexBook).setBorrowing(true);
                        JOptionPane.showMessageDialog(frame , ".امانت کتاب با موفقیت ثبت شد" , "پیام", JOptionPane.INFORMATION_MESSAGE);
                        new AdminPart(frame);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
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

    
    public void methodTextField() {
        
        // student number field
        stdNumber = new JTextField("");
        stdNumber.setVisible(true);
        // is visible
        stdNumber.setBounds(70 , 140 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        stdNumber.setBackground(Color.white);
        // background color of the title
        panel.add(stdNumber);

        // book ID field
        BookID = new JTextField("");
        BookID.setVisible(true);
        // is visible
        BookID.setBounds(70 , 185 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        BookID.setBackground(Color.white);
        // background color of the title
        panel.add(BookID);

        // borrowed days field
        days = new JTextField("");
        days.setVisible(true);
        // is visible
        days.setBounds(70 , 285 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        days.setBackground(Color.white);
        // background color of the title
        panel.add(days);
        
    }

    
    public void methodLabel() {
        
        label_title = new JLabel("ثبت امانت کتاب");
        // label is given at first
        label_title.setBounds(140 , 40 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_title.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        // title font
        label_title.setBackground(Color.white);
        // background color of the title
        panel.add(label_title);
        // add title to the frame by panel

        
        label_password = new JLabel("شماره دانشجویی: ");
        // label is given at first
        label_password.setBounds(260 , 140 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_password.setBackground(Color.white);
        // background color of the title
        panel.add(label_password);
        // add label to the frame by panel

        
        label_username = new JLabel("شناسه کتاب: ");
        // label is given at first
        label_username.setBounds(260 , 185 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_username.setBackground(Color.white);
        // background color of the title
        panel.add(label_username);
        // add label to the frame by panel

        
        label_days = new JLabel("تعداد روز در امانت: ");
        // label is given at first
        label_days.setBounds(260 , 285 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_days.setBackground(Color.white);
        // background color of the title
        panel.add(label_days);
        // add label to the frame by panel
        
    }
    
}