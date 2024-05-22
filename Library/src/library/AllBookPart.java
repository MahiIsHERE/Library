package library;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllBookPart {
    
    private JFrame frame;
    // a frame or windew for the program
    private JPanel panel;
    // a JPanel to organize the components(parts)
    private Student student;
    // an object from student class
    private JTable table;
    // a table for the program
    JLabel label_title;
    // title of the window
    ArrayList<Book> books = new ArrayList<>();
    // for "books.txt"
    
    
    // the main constructor
    public AllBookPart(JFrame frame , Student student) {
        
        this.frame = frame;
        // represent the main frame in the class
        frame.setVisible(true);
        // the frame is visible (by default)

        this.student = student;
        // refers to student object at the beginning

        methodPanel();
        // show the panel
        methodLabel();
        // show the fields' label

        try {
            readBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // goes for this class' methods

        tableAllBook();
        
        JButton btn_back = new JButton("بازگشت");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_back.addActionListener(e -> {
            if (student!=null) {
                new StudentPart(frame , student);
                // return to student section}
            }
            else {
                new AdminPart(frame);
                // return to librarian section
            }
        });
        // button info:
        methodButton(btn_back , 150, 410 , panel , Color.white , 100, 30);
        panel.add(btn_back);
        // button added to the panel
        
    }
    
    
    public void readBooks() throws IOException {
        FileReader fileReader = new FileReader("books.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String s = "";
        while ((s=br.readLine()) != null){
            books.add(new Book(s));
        }
        fileReader.close();
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
    
    public void methodLabel() {
        
        label_title = new JLabel("کتاب های موجود");
        // label is given at first
        label_title.setVisible(true);
        // is visible
        label_title.setBounds(140 , 20 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_title.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        // title font
        label_title.setBackground(Color.white);
        // background color of the title
        panel.add(label_title);
        // add label to the frame by panel
    }
    
    
    // enlist
    public void tableAllBook(){
        
        String[][] data = new String[books.size()][3];
        for (int i=0 ; i<books.size() ; i++) {
            data[i] = books.get(i).toArray();
        }
        String[] columnNames = {"شناسه کتاب" , "نام کتاب" , "دسته بندی"};

        table = new JTable(data , columnNames);
        // a table by array of books' info and column names
        table.setBounds(30 , 5 , 100 , 300);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        table.setEnabled(false);
        // no input!

        JScrollPane sp = new JScrollPane(table);
        // scroll option
        sp.setBounds(50 , 60 , 300 , 300);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        panel.add(sp);
        // add scrollPane of table

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