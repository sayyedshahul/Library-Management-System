package com.shahulsayyed.lms;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        boolean exit = false;
        int userChoice;
        Book book = null;
        LibraryManager libraryManager = new LibraryManager();
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
                System.out.println(libraryManager.getAvailableBooksCount());
            }
            else if(userChoice == 6){
                exit = true;
            }
        }
    }
}

