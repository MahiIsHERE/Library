package library;

import javax.swing.*;

public class Library {

    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        // creat a new JFrame window
        
        window.setVisible(true);
        // the window is visible
        
        window.setTitle("Library");
        // title of the window
        
        window.setSize(400 , 500);
        // size of the window
        window.setResizable(false);
        // not resizable
        
        window.setLayout(null);
        // not yet
        
        window.setLocationRelativeTo(null);
        // place the window to the center of the screen
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // close the program by closing the window
        
        new SaveInfo();
        // save information in the ".txt" file
        new LoginPart(window);
        // start the program by logging in
        
    }
    
}