package com.shahulsayyed.lms.user;

import java.util.Scanner;

public class UserManagementMenuHandler {
    private UserManager userManager;

    public UserManagementMenuHandler(UserManager userManager){
        this.userManager = userManager;
    }

    private void showMenu(){
        System.out.println("\n=== Library User Management System ===");
        System.out.println("1. Add user");
        System.out.println("2. Remove user (Mobile Number)");
        System.out.println("3. Search user (name/mobile-number/address)");
        System.out.println("4. Show All users");
        System.out.println("5. Available users Count");
        System.out.println("6. Exit");
        System.out.print("\nYour choice --> ");
    }

    public void run(){ // To navigate between different user management options.
        boolean exit = false;
        int userChoice;
        Scanner scn = new Scanner(System.in);

        while(!exit) {
            showMenu();
            userChoice = scn.nextInt();
            scn.nextLine();
            if(userChoice == 6){
                exit = true;
            }
            else{
                performMenuChoice(userChoice);
            }
        }
    }

    private void performMenuChoice(int userChoice){
        switch(userChoice){
            case 1 -> userManager.addUser();
            case 2 -> userManager.removeUser();
            case 3 -> userManager.searchUser();
            case 4 -> userManager.showAllusers();
            case 5 -> userManager.showAvailableusersCount();
        }
    }
}
