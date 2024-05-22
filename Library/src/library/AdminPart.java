package library;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class AdminPart {
    
    private JFrame frame;
    // a frame or windew for the program
    private JPanel panel;
    // a JPanel to organize the components(parts)
    JLabel label_title;
    // title of the window
    ArrayList<Student> students = new ArrayList<>();
    // for "students.txt"
    ArrayList<Book> books = new ArrayList<>();
    // for "books.txt"
    
    
    // the main constructor
    public AdminPart(JFrame frame) {
        
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

        try {
            readStudents();
            readBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // goes for this class' methods
        
    }
    
    
    // read students from the ArrayList of file
    public void readStudents() throws IOException {
        
        FileReader fileReader = new FileReader("students.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        BufferedReader br = new BufferedReader(fileReader);
        // read the text ---> the text is in fileReader now
        
        String s = "";
        
        while ((s=br.readLine()) != null){
            // readLine ---> to read the lines in the file
            // gave the read line to the String s
            // till the the read line is not null, it adds students' info in lines to the file // by method "new Student(s)", it goes to be read in file
            students.add(new Student(s));
        }
        
        fileReader.close();
        // close the file
        
    }
    
    
    // read the books in ArrayList
    public void readBooks() throws IOException {
        
        FileReader fileReader = new FileReader("books.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        BufferedReader br = new BufferedReader(fileReader);
        // read the text ---> the text is in fileReader now
        
        String s = "";
        
        while ((s=br.readLine()) != null){
            // readLine ---> to read the lines in the file
            // gave the read line to the String s
            // till the the read line is not null, it adds books' info in lines to the file // by method "new Book(s)", it goes to be read in file
            books.add(new Book(s));
        }
        
        fileReader.close();
        // close the file
    }
    
    
    public void buttons(){
        
        JButton btn_addStudent = new JButton("افزودن دانشجو");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_addStudent.addActionListener(e -> {
            new AddStudentPart (frame);
            // will go to add student section
        });
        // button info:
        methodButton(btn_addStudent , 110 , 80 , panel , Color.white , 170 , 30);
        
        
        JButton btn_addBook = new JButton("افزودن کتاب");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_addBook.addActionListener(e -> {
            new AddBookPart(frame);
            // will go to add book section
        });
        // button info:
        methodButton(btn_addBook , 110 , 130 , panel , Color.white , 170 , 30);
        
        
        JButton btn_showBooks = new JButton("لیست کتاب ها");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_showBooks.addActionListener(e ->{
            new AllBookPart(frame , null);
            // will go to all book section
        });
        // button info:
        methodButton(btn_showBooks , 110 , 180 , panel , Color.white , 170 , 30);
        
        
        JButton btn_borrowedBooks = new JButton("کتاب های به امانت گرفته شده");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_borrowedBooks.addActionListener(e -> {
            new BorrowedBookPart(frame);
            // will go to borrowed book section
        });
        // button info:
        methodButton(btn_borrowedBooks , 110 , 230 , panel , Color.white , 170 , 30);
        
        
        JButton btn_borrowBook = new JButton("ثبت امانت کتاب");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_borrowBook.addActionListener(e -> {
            new BorrowingBookPart(frame);
            // will go to borrowing book section
        });
        // button info:
        methodButton(btn_borrowBook , 110 , 280 , panel , Color.white , 170 , 30);
        
        
        JButton btn_returnBook = new JButton("ثبت بازگرداندن کتاب");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_returnBook.addActionListener(e -> {
            new ReturnBookPart(frame);
            // will go to return book section
        });
        // button info:
        methodButton(btn_returnBook , 110 , 330 , panel , Color.white , 170 , 30);
        
        
        JButton btn_back = new JButton("بازگشت");
        // name of the button is given at first
        // the function which will run by pressing button:
        btn_back.addActionListener(e -> {
            new LoginPart(frame);
            // will go back to librarian section
        });
        // button info:
        methodButton(btn_back , 110 , 380 , panel , Color.white , 170 , 30);
        
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
    
    
    // username & password fields' lable
    public void methodLabel() {
        
        // title label
        label_title = new JLabel("منوی مسئول کتابخانه");
        label_title.setVisible(true);
        // is visible
        label_title.setBounds(125 , 20 , 230 , 30);
        // the first two parameters are x , y, the location in the window
        // the last two parameters are width & heigth, the same as the setSize
        label_title.setFont(new Font(Font.DIALOG , Font.BOLD , 20));
        // set fonts for the title
        label_title.setBackground(Color.white);
        // background color of the title
        panel.add(label_title);
        // add title label to the frame by panel
        
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
        // add button label to the frame by panel
        
    }
    
}