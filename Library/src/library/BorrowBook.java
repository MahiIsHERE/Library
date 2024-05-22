package library;

public class BorrowBook {
    
    // information of the book, student & the borrow & delivery date for borrowing book
    private int ID;
    private String stdNumber;
    private Dates dateBorrow;
    private Dates dateDelivery;

    
    // the main constructor
    // info for borrowing book:
    public BorrowBook(int code , String stdNumber , Dates dateBorrow , Dates dateDelivery) {
        
        this.ID = ID;
        this.stdNumber = stdNumber;
        this.dateBorrow = dateBorrow;
        this.dateDelivery = dateDelivery;
        
    }
    
    
    // in "borrowBooks.txt", we can read these datas by array 
    public BorrowBook(String line){
        
        String array[] = line.split(",");
        this.ID = Integer.parseInt(array[0]);
        this.stdNumber = array[1];
        this.dateBorrow = new Dates (array[2]);
        this.dateDelivery = new Dates (array[3]);
        
    }
    
    
    // borrowing info:
    //book Id:
    public int getCode() {
        return ID;
    }

    public void setCode(int ID) {
        this.ID = ID;
    }

    // student number:
    public String getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(String stdNumber) {
        this.stdNumber = stdNumber;
    }

    // dates:
    // borrow
    public Dates getDateBorrow() {
        return dateBorrow;
    }
    // by the Dates.class 

    public void setDateBorrow(Dates dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    // delivery
    public Dates getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Dates dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    
    // store datas in String type in the file
    @Override
    public String toString() {
        return ID + "," + stdNumber + "," + dateBorrow + "," + dateDelivery;
    }
    
    
    // Frame:
    public String[] toArray(){
        return new String[]{String.valueOf(ID) , stdNumber , dateBorrow.toString() , dateDelivery.toString()};
    }
    
}