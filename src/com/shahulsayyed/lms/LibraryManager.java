package com.shahulsayyed.lms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shahulsayyed.lms.user.User;
import com.shahulsayyed.lms.user.UserManager;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public void showMenu(){
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

    public void addBook(){
        Book book = takeBookFromUser();
        books.add(book);
        System.out.println("\nBook added successfully");
    }

    public void addBook(List<Book> books){
        this.books.addAll(books);
    }

    public void removeBook(){
        System.out.print("\nEnter book's isbn which is to be removed: ");
        String isbn = scn.nextLine().strip();

        books.removeIf(book -> book.getIsbn().equals(isbn));

        System.out.println("\nBook removed successfully");
    }

    public void searchBooks(){
        System.out.print("\nEnter the book title: ");
        String title = scn.nextLine().toLowerCase().strip();

        System.out.print("Enter the book's author: ");
        String author = scn.nextLine().toLowerCase().strip();

        List<Book> searchResults = new ArrayList<>();
        for(Book book: books){
            if((!title.isEmpty() && book.getTitle().toLowerCase().contains(title)) ||
                    (!author.isEmpty() && book.getAuthor().toLowerCase().contains(author))){
                searchResults.add(book);
            }
        }

        showAllBooks(searchResults);
    }

    public Book searchBooks(String isbn){
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public void showAllBooks(){
        if(books.isEmpty()){
            System.out.println("\nNo books to show.");
        }
        else {
            for (Book book : books) {
                System.out.println("\n" + book);
            }
        }
    }

    public void showAllBooks(List<Book> books){
        if(books.isEmpty()){
            System.out.println("\nNo books to show.");
        }
        else {
            for (Book book : books) {
                System.out.println("\n" + book);
            }
        }
    }

    public void showAvailableBooksCount(){
        System.out.println("\nTotal books = " + books.size());
    }

    public Book takeBookFromUser(){
        Book book = new Book();
        String title;
        String isbn;
        String author;

        System.out.print("\nEnter the book title: ");
        title = scn.nextLine().strip();
        book.setTitle(title);

        System.out.print("Enter the book's author: ");
        author = scn.nextLine().strip();
        book.setAuthor(author);

        System.out.print("Enter the book's isbn: ");
        isbn = scn.nextLine().strip();
        book.setIsbn(isbn);

        book.setStatus("Available");
        return book;
    }

    public void readBooksDataFromCsvFile() {
        String path;

        System.out.print("\nEnter file path: ");
        path = scn.nextLine().strip();
        String line;
        String[] data;
        List<Book> books = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // To skip header.

            while ((line = br.readLine()) != null) {
                data = line.split(",");
                books.add(new Book(data[0], data[1], data[2]));
            }
            br.close();

            addBook(books);
            System.out.println("File read successfully");
        }
        catch(Exception e){
            System.out.println("Something went wrong. Unable to read your file.");
        }
    }

    public void issueBook(LibraryManager libraryManager, UserManager userManager){
       Book book;
       User user;
       String isbn;
       String mobileNo;

       System.out.print("Enter the book's isbn: ");
       isbn = scn.nextLine();
        while((book = libraryManager.searchBooks(isbn)) == null){ //Check repeatedly till you get a valid ISBN.
            System.out.print("No such ISBN. Please enter the correct isbn: ");
            isbn = scn.nextLine();
        }

       if(book.getStatus().equals("Available")) {
           System.out.print("Enter the user's mobile number: ");
           mobileNo = scn.nextLine();
           while ((user = userManager.searchUser(mobileNo)) == null) {//Check repeatedly till you get a valid mobile number.
               System.out.print("No such user. Please enter the correct mobile number: ");
               mobileNo = scn.nextLine();
           }

           if(!isOtherBookAlreadyIssued(mobileNo, userManager)) { // Check whether any other book is already issued to given user.
               book.setStatus("Issued");
               book.setIssuedTo(user);
               book.setIssueDate(LocalDate.now());
               book.setReturnDate(LocalDate.now().plusDays(7));
               System.out.println("Book issued successfully.");
           }
           else{
               System.out.println("Library users can only borrow one book at a time");
           }
       }
       else{
           System.out.println("Book already issued.");
       }
    }

    public boolean isBookAlreadyIssued(String mobileNo, UserManager userManager) {
        User user = userManager.searchUser(mobileNo);
        Book result = books.stream()
                .filter(book -> book.getIssuedTo() == user)
                .findFirst()
                .orElse(null); // Check whether any book is already issued to given user.
        return result != null;
    }

    public void processBookReturn(LibraryManager libraryManager){
        String isbn;

        System.out.print("Enter the book's isbn: ");
        isbn = scn.nextLine();
        Book book;

        while((book = libraryManager.searchBooks(isbn)) == null){
            System.out.print("No such ISBN. Please enter the correct isbn: ");
            isbn = scn.nextLine();
        }

        if(book.getStatus().equals("Issued")) {
            book.setStatus("Available");
            book.setIssuedTo(null);
            book.setIssueDate(null);
            book.setReturnDate(null);
            System.out.println("Book returned successfully.");
        }
        else{
            System.out.println("Book can't be returned as it is not issued already.");
        }
    }
}

