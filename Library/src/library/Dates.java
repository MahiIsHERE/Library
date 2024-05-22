package library;

import java.text.SimpleDateFormat; // format: date ---> String // parse: String ---> date
import java.util.Date;

public class Dates {
    
    // the date:
    private int year;
    private int month;
    private int day;

    
    // get today's date
    public Dates (int year , int month , int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    
    // borrow date:
    public Dates (Date date) {
        this(new SimpleDateFormat("yyyy/MM/dd").format(date));
        // date to String
    }
    
    
    // reading txt:
    // String to integer
    public Dates (String line){
        
        String array[] = line.split("/");
        // finding the integer of the date info
        this.year = Integer.parseInt(array[0]);
        this.month =Integer.parseInt(array[1]);
        this.day = Integer.parseInt(array[2]);
        
    }
    
    
    // return date:
    public Dates (Dates date , int days){
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
        addDays(days);
        // addDays is for delivery date
    }
    
    
    // dates:
    // year:
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // month
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    // day
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    
    // to find the date that the book should be returned
    // it calculates the delivery date by the number of days the book was borrowed
    public void addDays(int n){
        
        day += n;
        if (day>30){
            day -= 30;
            month++;
            if (month>12){
                month -= 12;
                year++;
            }
        }
        
    }
    
    
    // store datas in String type in the file
    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

}