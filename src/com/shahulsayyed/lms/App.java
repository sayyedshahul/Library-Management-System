package com.shahulsayyed.lms;

import com.shahulsayyed.lms.user.UserManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean exit = false;
        int userChoice;
        LibraryManager libraryManager = new LibraryManager();
        UserManager userManager = new UserManager();
        Scanner scn = new Scanner(System.in);

        while(!exit){
            libraryManager.showMenu();
            userChoice = scn.nextInt();
            scn.nextLine(); // To clear the remaining new line character after last read.

            switch(userChoice){
                case 1 -> libraryManager.addBook();
                case 2 -> libraryManager.removeBook();
                case 3 -> libraryManager.searchBooks();
                case 4 -> libraryManager.showAllBooks();
                case 5 -> libraryManager.showAvailableBooksCount();
                case 6 -> libraryManager.readBooksDataFromCsvFile();
                case 7 -> userManager.handleUserManagement(userManager);
                case 8 -> libraryManager.issueBook(libraryManager, userManager);
                case 9 -> libraryManager.processBookReturn(libraryManager);
                case 10 -> exit = true;
            }
        }
    }
}

