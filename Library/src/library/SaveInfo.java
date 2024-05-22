package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;

public class SaveInfo {
    
    public static ArrayList<Student> students; 
    // for "students.txt"
    public static ArrayList<Book> books; 
    // for "books.txt"
    public static ArrayList<BorrowBook> borrowBooks; 
    // for "borrowBooks.txt"
    // or JList<String>
    

    // the main constructor
    // students, books & borrowedBooks:
    public SaveInfo() {
        
        students = new ArrayList<>();
        books = new ArrayList<>();
        borrowBooks = new ArrayList<>();
        try {
            readStudents();
            readBooks();
            readBorrowBooks();
            // goes for this class' methods
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    
    // just write the book in the file, no save option
    public static void writeBooks() throws IOException {
        
        FileWriter fileWriter = new FileWriter("books.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        StringBuilder stringBuilder = new StringBuilder();
        // creats a modifiable String
        
        for (int i=0 ; i<books.size() ; i++) {
            stringBuilder.append(books.get(i) + "\n");
            // appends books' info by the StringBuilder
        }
        
        fileWriter.write(stringBuilder.toString());
        // cast to the String type
        fileWriter.close();
        // close the file
        
    }
    
    
    // append/add the book to the file, it will be saved now
    public static void addBook(Book book) throws IOException {
        
        books.add(book);
        FileWriter fileWriter = new FileWriter("books.txt" , true);
        // FileWriter fileWriter = new FileWriter(file name , boolean append);
        fileWriter.append(book + "\n");
        // append the book to the file
        fileWriter.close();
        // close the file
        
    }

    
    // read the books in ArrayList
    public static void readBooks() throws IOException {
        
        FileReader fileReader = new FileReader("books.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        BufferedReader br = new BufferedReader(fileReader);
        // read the text ---> the text is in fileReader now
        String s = "";
        
        while ((s=br.readLine()) != null) {
            // readLine ---> to read the lines in the file
            // gave the read line to the String s
            // till the the read line is not null, it adds books' info in lines to the file // by method "new Book(s)", it goes to be read in file
            books.add(new Book(s));
        }
        
        fileReader.close();
        // close the file
        
    }
    
    
    // by getting a stdNumber ---> all of the borrowed books will appear
    public static ArrayList<BorrowBook> allBorrowedBooksForStudent(String ID){
        
        ArrayList<BorrowBook> borrowedBooks = new ArrayList<>();
        
        for (int i=0 ; i<borrowBooks.size() ; i++) {
            // goes for all of the borrowed books
            if (borrowBooks.get(i).getStdNumber().equals(ID))
                // if the ID of the student who borrowed the book equals the ID in the input, the book will be appended to the end of the ArrayList
                borrowedBooks.add(borrowBooks.get(i));
        }
        
        return borrowedBooks;
        // now we have the ArrayList of all borrowed books
        
    }
    
    
    
    // just write students in the file, no save option
    public static void writeStudents() throws IOException {
        
        FileWriter fileWriter = new FileWriter("students.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        StringBuilder stringBuilder = new StringBuilder();
        // creats a modifiable String
        
        for (int i=0 ; i<students.size() ; i++) {
            stringBuilder.append(students.get(i) + "\n");
            // appends students' info by the StringBuilder
        }
        
        fileWriter.write(stringBuilder.toString());
        // cast to the String type
        fileWriter.close();
        // close the file
        
    }
    
    
    // append/add student to the file
    public static void addStudent(Student student) throws IOException {
        
        students.add(student);
        FileWriter fileWriter = new FileWriter("students.txt" , true);
        // FileWriter fileWriter = new FileWriter(file name , boolean append);
        fileWriter.append(student + "\n");
        // append the book to the file ---> it is saved in it
        fileWriter.close();
        // close the file
        
    }
    
    
    // student login part
    public static Student loginStudent(String username , String password){
        
        for (int i=0 ; i<students.size() ; i++) {
            // check all students' info in the ArrayList
            if (students.get(i).getStdNumber().equals(username) && students.get(i).getPassword().equals(password)) {
                /* if the stdNumber equals to the username/stdNumber in the input
                   and the password of the student equals the password in the input,
                   it will return student info
                */
                return students.get(i);
            }
        }
        
        return null;
        // else, it will return nothing
        
    }
    
    
    // read students from the ArrayList of file
    public static void readStudents() throws IOException {
        
        FileReader fileReader = new FileReader("students.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        BufferedReader br = new BufferedReader(fileReader);
        // read the text ---> the text is in fileReader now
        String s = "";
        
        while ((s=br.readLine()) != null) {
            // readLine ---> to read the lines in the file
            // gave the read line to the String s
            // till the the read line is not null, it adds students' info in lines to the file // by method "new Student(s)", it goes to be read in file
            students.add(new Student(s));
        }
        
        fileReader.close();
        // close the file
        
    }
    
    
    // just write borrowed books in the file, no save option
    public static void writeBorrowBooks() throws IOException {
        
        FileWriter fileWriter = new FileWriter("borrowBooks.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        StringBuilder stringBuilder = new StringBuilder();
        // creats a modifiable String
        
        for (int i=0 ; i<borrowBooks.size() ; i++) {
            stringBuilder.append(borrowBooks.get(i) + "\n");
        }
        
        fileWriter.write(stringBuilder.toString());
        // cast to the String type
        fileWriter.close();
        // close the file
        
    }

    
    // append/add borrowed book to the file
    public static void addBorrowBook(BorrowBook book) throws IOException {
        
        borrowBooks.add(book);
        FileWriter fileWriter = new FileWriter("borrowBooks.txt", true);
        // FileWriter fileWriter = new FileWriter(file name , boolean append);
        fileWriter.append(book + "\n");
        // append the borrowed book to the file ---> it is saved in it
        fileWriter.close();
        // close the file
        
    }
    
    
    // read borrowed books from the ArrayList of file
    public static void readBorrowBooks() throws IOException {
        
        FileReader fileReader = new FileReader("borrowBooks.txt");
        // FileWriter fileWriter = new FileWriter(file name);
        BufferedReader br = new BufferedReader(fileReader);
        String s = "";
        
        while ((s = br.readLine()) != null) {
            // readLine ---> to read the lines in the file
            // gave the read line to the String s
            // till the the read line is not null, it adds borrowed books' info in lines to the file // by method "new BorrowBook(s)", it goes to be read in file
            borrowBooks.add(new BorrowBook(s));
        }
        
        fileReader.close();
        // close the file
        
    }
    

    // check if any book with this ID is available or not
    public static int checkBook(int ID) {
        
        for (int i=0 ; i<books.size() ; i++) {
            // goes for all of the books
            if (books.get(i).getId()==ID) {
                // if the book ID equals the ID in the input, will check the state and probably return the ID
                if (books.get(i).isBorrowing()) {
                    return -2;
                    // the book is borrowed
                }
                return i;
                // the book is available
            }
        }
        
        return -1;
        // the book is not available
        
    }

    
    // check if any student with this ID is available or not
    public static int checkStudent(String ID) {
        
        for (int i=0 ; i<students.size() ; i++) {
            // goes for all of the students
            if (students.get(i).getStdNumber().equals(ID)) {
                // if the student ID equals the ID in the input, will return the ID
                return i;
            }
        }
        return -1;
        // the student ID is not available
        
    }
    
    
    // check if any book with this ID is borrowed or not
    public static int returnCheck(int ID){
        
        for (int i=0 ; i<borrowBooks.size() ; i++) {
            // goes for all of the borrowed books
            if (borrowBooks.get(i).getCode()==ID) {
                // if the book ID equals the ID in the input, will return the ID
                return i;
            }
        }
        
        return -1;
        // the book is not borrowed
        
    }
    
    
    // return book and remove it from file by the book ID
    public static void returnBook(int index){
        
        int ID = borrowBooks.get(index).getCode();
        // put the borrowed book ID in the int Id
        borrowBooks.remove(index);
        // remove the book with that ID
        // index refers to the book ID
        
        // change the state in the file
        for (int i=0 ; i<books.size() ; i++) {
            // goes for all of the books
            if (books.get(i).getId()==ID){
                // if the book ID equals the ID in the input, will set the borrowing state of that book 'false'
                books.get(i).setBorrowing(false);
                break;
            }
        }
        
        // Exception for borrowed books
        try {
            writeBorrowBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Excption for all books
        try {
            writeBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    // total check state for 'else' in class 'ReturnBookPart'
    // check if any book with this ID is borrowed or not
    public static int checkBorrowBook(int ID) {
        
        for (int i=0 ; i<borrowBooks.size() ; i++) {
            // goes for all of the borrowed books
            if (borrowBooks.get(i).getCode()==ID) {
                // if the book ID equals the ID in the input, will return the ID
                return i;
            }
        }
        
        return -1;
        // the book is not borrowed
        
    }

}