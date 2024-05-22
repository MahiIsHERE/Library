package library;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddBookPart {
    
    private JFrame frame;
    // a frame or windew for the program
    JPanel panel;
    // a JPanel to organize the components(parts)
    private Book book;
    // an object from book class
    JTextField textField_name, textField_ID;
    // book name & ID field
    JLabel label_name, label_ID, label_category, label_title;
    // book name, ID, category & title fields' label
    JComboBox<String> comboBox_category;
    // a comboBox for category
    
    
    // the main constructor
    public AddBookPart (JFrame frame) {
        
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
        methodButton(btn_back, 250, 370, panel, Color.white, 80, 30);

        
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
        methodButton(btn_save, 50, 370, panel, Color.white, 80, 30);

    }
    

    // save button function
    public void btn_save() throws IOException {
        
        if (textField_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "نام کتاب وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (textField_ID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame , "شناسه کتاب وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else if (isNumber(textField_ID.getText())==false) {
            JOptionPane.showMessageDialog(frame , "شناسه کتاب به درستی وارد نشده است!" , "پیام" , JOptionPane.WARNING_MESSAGE);
        } 
        else {
            book = new Book(Integer.parseInt(textField_ID.getText()), textField_name.getText()
                    , getCategory(comboBox_category.getSelectedIndex()));
            SaveInfo.addBook(book);
            // append/add book to the file
            new AdminPart(frame);
            // return to librarian section
            JOptionPane.showMessageDialog(frame , "کتاب با موفقیت اقزوده شد." , "پیام" , JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    public BookCategory getCategory(int i) {
        // 'i' is the index of comboBox items
        
        // with the comboBox order
        if (i==0) {
            return BookCategory.Computer;
        }
        else if (i==1) {
            return BookCategory.Math;
        }
        else if (i==2) {
            return BookCategory.Physics;
        }
        else if (i==3) {
            return BookCategory.Chemistry;
        }
        else if (i==4){
            return BookCategory.Electricity;
        }
        else{
            return BookCategory.General;
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

    
    public void ComboBox() {
        
        // book category
        String array[] = {"کامپیوتر" , "ریاضی" , "فیزیک" , "شیمی" , "برق" , "عمومی"};
        comboBox_category = new JComboBox<>(array);
        // a comboBox with array items
        methodComboBox(comboBox_category , panel , Color.white , 110 , 200 , 100 , 25);
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
        
        label_title = new JLabel("افزودن کتاب");
        // label is given at first
        label_title.setVisible(true);
        // is visible
        label_title.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        // font of the title
        methodLabel(label_title , 140 , 30 , panel , Color.white , 230 , 25);
        // apearance
        

        label_ID = new JLabel("نام: ");
        // label is given at first
        label_ID.setVisible(true);
        // is visible
        methodLabel(label_ID , 145 , 100 , panel , Color.white , 230 , 25);
        // apearance
        

        label_name = new JLabel("شناسه: ");
        // label is given at first
        label_name.setVisible(true);
        // is visible
        methodLabel(label_name , 330 , 100 , panel , Color.white , 230 , 25);
        // apearance
        

        label_category = new JLabel("دسته بندی: ");
        // label is given at first
        label_category.setVisible(true);
        // is visible
        methodLabel(label_category , 225 , 200 , panel , Color.white , 230 , 25);
        // apearance
        
    }

    
    // book ID & name field
    public void methodTextField() {
        
        // book ID field
        textField_ID = new JTextField("");
        textField_ID.setVisible(true);
        // is visible
        methodTextField(textField_ID , 220 , 100 , panel , Color.white , 100 , 25);
        // apearance
        

        // book name field
        textField_name = new JTextField("");
        textField_name.setVisible(true);
        // is visible
        methodTextField(textField_name , 35 , 100 , panel , Color.white , 100 , 25);
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
