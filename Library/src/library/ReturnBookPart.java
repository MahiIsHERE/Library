package library;

import javax.swing.*;
import java.awt.*;

public class ReturnBookPart {
    
    private JFrame frame;
    // a frame or windew for the program
    private JPanel panel;
    // a JPanel to organize the components(parts)
    private JTextField BookID;
    // book ID field
    private JLabel label_title, label_BookID;
    // 

    
    // the main constructor
    public ReturnBookPart(JFrame frame) {
        
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

        
        JButton btn_save = new JButton("ثبت");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_save.addActionListener(e -> {
            returnBook();
        });
        // button info:
        methodButton(btn_save, 50, 370, panel, Color.white, 80, 30);
        
    }
    
    
    public void returnBook(){
        
        if (BookID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "شناسه کتاب وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (!isNumber(BookID.getText())) {
            JOptionPane.showMessageDialog(frame , "شناسه کتاب وارد شده نامتعبر است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        }
        else if(SaveInfo.checkBorrowBook(Integer.parseInt(BookID.getText()))==-1){
            JOptionPane.showMessageDialog(frame , "شناسه کتاب وارد شده در امانت نمی باشد!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        }
        else{
            int index = SaveInfo.returnCheck(Integer.parseInt(BookID.getText()));
            if (index==-1){
                JOptionPane.showMessageDialog(frame , "کتاب در امانت نمی باشد!" , "پیام" , JOptionPane.WARNING_MESSAGE);
            }
            else {
                SaveInfo.returnBook(index);
                JOptionPane.showMessageDialog(frame , "کتاب با موفقیت بازگردانده شد." , "پیام" , JOptionPane.INFORMATION_MESSAGE);
                new AdminPart(frame);
                // return to librarian section
            }
        }
        
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
    
    
    public void methodLabel() {
        
        label_title = new JLabel("ثبت بازگرداندن کتاب");
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
        

        label_BookID = new JLabel("شناسه کتاب: ");
        label_BookID.setBounds(260 , 140 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_BookID.setBackground(Color.white);
        // background color of the title
        panel.add(label_BookID);
        // add label to the frame by panel
        
    }
    
    
    // book ID field
    public void methodTextField() {
        
        BookID = new JTextField("");
        BookID.setVisible(true);
        // is visible
        BookID.setBounds(75 , 140 , 180 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        BookID.setBackground(Color.white);
        // background color of the title
        panel.add(BookID);
        // add field to frame by panel
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
    
}