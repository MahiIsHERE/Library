package library;

public class Book {
    
    // info:
    private int id;
    private String name;
    private BookCategory category;
    private boolean isBorrowing; // if 'true' ---> the book is borrowed  // if 'false' ---> not borrowed, available
    
    
    // the main constructor
    // book info:
    public Book(int id , String name , BookCategory category) {
        
        this.id = id;
        this.name = name;
        this.category = category;
        this.isBorrowing = false;
        // not borrowed yet
        
    }
    
    // reading txt:
    public Book(String line){
        
        String array[] = line.split(",");
        this.id = Integer.parseInt(array[0]);
        this.name = array[1];
        this.category = getCategory(array[2]);
        this.isBorrowing = Boolean.parseBoolean(array[3]);
        
    }
    
    
    // read category
    public BookCategory getCategory(String category) {
        
        if (category.equals("Computer")) {
            return BookCategory.Computer;
        }
        else if (category.equals("Math")) {
            return BookCategory.Math;
        }
        else if (category.equals("Physics")) {
            return BookCategory.Physics;
        }
        else if (category.equals("chemistry")) {
            return BookCategory.Chemistry;
        }
        else if (category.equals("Electricity")) {
            return BookCategory.Electricity;
        }
        else {
            return BookCategory.General;
        }
        
    }
    
    
    // book info:
    // ID:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // book name:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // book category
    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    // state: borrowed or not
    public boolean isBorrowing() {
        return isBorrowing;
    }

    public void setBorrowing(boolean borrowing) {
        isBorrowing = borrowing;
    }

    
    // store datas in String type in the file
    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + isBorrowing;
    }
    
    // Frame:
    public String[] toArray(){
        return new String[]{String.valueOf(id) , name , String.valueOf(category)};
    }
    
}