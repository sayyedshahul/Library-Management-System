package com.shahulsayyed.lms;

import com.shahulsayyed.lms.user.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean exit = false;
        int userChoice;
        Book book;
        LibraryManager libraryManager = new LibraryManager();
        UserManager userManager = new UserManager();
        Scanner scn = new Scanner(System.in);

        while(!exit){
            libraryManager.showMenu();
            userChoice = scn.nextInt();
            scn.nextLine(); // To clear the remaining new line character after last read.

            if(userChoice == 1){
                book = libraryManager.takeBookFromUser();
                libraryManager.addBook(book);
                System.out.println("Book added successfully");
            }
            else if(userChoice == 2){
                System.out.print("Enter book's isbn which is to be removed: ");
                String isbn = scn.nextLine().strip();
                libraryManager.removeBook(isbn);
                System.out.println("Book removed successfully");
            }
            else if(userChoice == 3){
                System.out.print("Enter the book title: ");
                String title = scn.nextLine().strip();

                System.out.print("Enter the book's author: ");
                String author = scn.nextLine().strip();

                libraryManager.showAllBooks(libraryManager.searchBooks(author, title));
            }
            else if(userChoice == 4){
                libraryManager.showAllBooks();
            }
            else if(userChoice == 5){
                System.out.println("Total books = " + libraryManager.getAvailableBooksCount());
            }
            else if(userChoice == 6){
                try {
                    libraryManager.addBook(libraryManager.readBooksDataFromCsvFile());
                    System.out.println("File read successfully");
                }
                catch(IOException e){
                    System.out.println("Something went wrong. Unable to read your file.");
                }
            }
            else if(userChoice == 7){
                userManager.handleUserManagement();
            }
            else if(userChoice == 8){
                exit = true;
            }
        }
    }
}

