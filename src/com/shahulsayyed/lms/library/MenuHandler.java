package com.shahulsayyed.lms.library;

import com.shahulsayyed.lms.user.UserManagementMenuHandler;
import com.shahulsayyed.lms.user.UserManager;

import java.util.Scanner;

public class MenuHandler {
    private LibraryManager libraryManager;
    private UserManager userManager;

    public MenuHandler(LibraryManager libraryManager, UserManager userManager){
        this.libraryManager = libraryManager;
        this.userManager = userManager;
    }

    private void showMenu(){
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book (ISBN)");
        System.out.println("3. Search Books (Author/Title)");
        System.out.println("4. Show All Books");
        System.out.println("5. Available Books Count");
        System.out.println("6. Read book data from csv file");
        System.out.println("7. User Management");
        System.out.println("8. Issue book");
        System.out.println("9. Process book return");
        System.out.println("10. Exit");
        System.out.print("\nYour choice --> ");
    }

    public void run(){
        boolean exit = false;
        int userChoice;
        Scanner scn = new Scanner(System.in);

        while(!exit){
            showMenu();
            userChoice = scn.nextInt();
            scn.nextLine(); // To clear the remaining new line character after last read.
            if(userChoice == 10){
                exit = true;
            }
            else{
                performMenuChoice(userChoice);
            }
        }
    }

    private void performMenuChoice(int userChoice){ // To map user choice to specific action.
        switch(userChoice){
            case 1 -> libraryManager.addBook();
            case 2 -> libraryManager.removeBook();
            case 3 -> libraryManager.searchBooks();
            case 4 -> libraryManager.showAllBooks();
            case 5 -> libraryManager.showAvailableBooksCount();
            case 6 -> libraryManager.readBooksDataFromCsvFile();
            case 7 -> new UserManagementMenuHandler(userManager).run();
            case 8 -> libraryManager.issueBook(userManager);
            case 9 -> libraryManager.processBookReturn();
        }
    }
}
