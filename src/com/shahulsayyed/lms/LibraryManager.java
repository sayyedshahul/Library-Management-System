package com.shahulsayyed.lms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void showMenu(){
        System.out.println("=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book (ISBN)");
        System.out.println("3. Search Books (Author/Title)");
        System.out.println("4. Show All Books");
        System.out.println("5. Available Books Count");
        System.out.println("6. Read book data from csv file");
        System.out.println("7. User Management");
        System.out.println("8. Exit");
        System.out.print("Your choice --> ");
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addBook(List<Book> books){
        this.books.addAll(books);
    }

    public void removeBook(String isbn){
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> searchBooks(String author, String title){
        List<Book> searchResults = new ArrayList<>();
        author = author.toLowerCase().strip();
        title = title.toLowerCase().strip();

        for(Book book: books){
            if((!title.isEmpty() && book.getTitle().toLowerCase().contains(title)) ||
                    (!author.isEmpty() && book.getAuthor().toLowerCase().contains(author))){
                searchResults.add(book);
            }
        }

        return searchResults;
    }

    public void showAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books to show.");
        }
        else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void showAllBooks(List<Book> books){
        if(books.isEmpty()){
            System.out.println("No books to show.");
        }
        else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public int getAvailableBooksCount(){
        return books.size();
    }

    public Book takeBookFromUser(){
        Scanner scn = new Scanner(System.in);
        Book book = new Book();
        String title;
        String isbn;
        String author;


        System.out.print("Enter the book title: ");
        title = scn.nextLine().strip();
        book.setTitle(title);

        System.out.print("Enter the book's author: ");
        author = scn.nextLine().strip();
        book.setAuthor(author);

        System.out.print("Enter the book's isbn: ");
        isbn = scn.nextLine().strip();
        book.setIsbn(isbn);

        return book;
    }

    public List<Book> readBooksDataFromCsvFile() throws IOException {
        String path;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter file path: ");
        path = scn.nextLine().strip();
        String line;
        String[] data;
        List<Book> books = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine();

        while((line = br.readLine()) != null){
            data = line.split(",");
            books.add(new Book(data[0], data[1], data[2]));
        }
        br.close();
        return books;
    }
}

