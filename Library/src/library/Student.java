package library;

import java.util.ArrayList;
import javax.swing.JList;

public class Student {
    
    // info:
    private String stdNumber;
    private String name;
    private Level level;
    private Department department;
    private String password;
    ArrayList<BorrowBook> borrowBooks; // or JList<String>

    
    // the main constructor
    // student info:
    public Student(String stdNumber , String name , Level level , Department department , String password) {
        
        this.stdNumber = stdNumber;
        this.name = name;
        this.level = level;
        this.department = department;
        this.password = password;
        borrowBooks = new ArrayList<>();
        
    }
    
    
    // in "student.txt", we can read these datas by array 
    public Student(String line){
        
        String array[] = line.split(",");
        this.stdNumber = array[0];
        this.name = array[1];
        this.level = getLevel(array[2]);
        this.department = getDepartment(array[3]);
        this.password = array[4];
        borrowBooks = new ArrayList<>();
        
    }
    
    
    // read level from file
    public Level getLevel(String level){
        
        if (level.equals("Bachelor")) {
            return Level.Bachelor;
        }
        
        else if(level.equals("Master")) {
            return Level.Master;
        }
        
        else {
            return Level.PHD;
        }
        
    }
    
    // read department from file
    public Department getDepartment(String department){ 
        
        if (department.equals("Computer_Engineering")) {
            return Department.Computer_Engineering;
        }
        
        else if (department.equals("Electrical_Engineering")) {
            return Department.Electrical_Engineering;
        }
        
        else {
            return Department.Science;
        }
        
    }
    
    // student info:
    //student number:
    public String getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(String stdNumber) {
        this.stdNumber = stdNumber;
    }

    // sudent name:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // student level:
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    // student department:
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // student paassword:
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // borrow book for student:
    public void addBook(BorrowBook borrowBook) {
        borrowBooks.add(borrowBook);
    }

    
    // store datas in String type in the file
    @Override
    public String toString() {
        return stdNumber + "," + name + "," + level + "," + department + "," + password;
    }
    
}