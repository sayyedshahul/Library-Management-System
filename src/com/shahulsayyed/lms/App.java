package com.shahulsayyed.lms;

import com.shahulsayyed.lms.library.LibraryManager;
import com.shahulsayyed.lms.library.MenuHandler;
import com.shahulsayyed.lms.user.UserManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        LibraryManager libraryManager = new LibraryManager();
        UserManager userManager = new UserManager();
        new MenuHandler(libraryManager, userManager).run();
    }
}

