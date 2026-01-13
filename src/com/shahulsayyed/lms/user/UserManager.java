package com.shahulsayyed.lms.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    List<User> users =  new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public void showMenu(){
        System.out.println("\n=== Library User Management System ===");
        System.out.println("1. Add user");
        System.out.println("2. Remove user (Mobile Number)");
        System.out.println("3. Search user (name/mobile-number/address)");
        System.out.println("4. Show All users");
        System.out.println("5. Available users Count");
        System.out.println("6. Exit");
        System.out.print("\nYour choice --> ");
    }

    public void handleUserManagement(UserManager userManager){ // To navigate between different user management options.
        boolean exit = false;
        int userChoice;
        User user;

        while(!exit) {
            showMenu();
            userChoice = scn.nextInt();
            scn.nextLine();

            switch(userChoice){
                case 1 -> userManager.addUser();
                case 2 -> userManager.removeUser();
                case 3 -> userManager.searchUser();
                case 4 -> userManager.showAllusers();
                case 5 -> userManager.showAvailableusersCount();
                case 6 -> exit = true;
            }
        }
    }

    public void addUser(){
        User user = takeNewUserDetails();
        users.add(user);
        System.out.println("\nUser added successfully.");
    }

    public void removeUser(){
        System.out.print("\nEnter user's mobile number who is to be removed: ");
        String mobileNo = scn.nextLine().strip();
        users.removeIf(user ->user.getMobileNo().equals(mobileNo));
        System.out.println("\nUser removed successfully.");
    }

    public void searchUser(){
        System.out.print("\nEnter the user's name: ");
        String userName = scn.nextLine().strip();

        System.out.print("Enter the user's mobile number(if you want to): ");
        String mobileNo = scn.nextLine().strip();

        System.out.print("Enter the user's address(if you want to): ");
        String address = scn.nextLine().strip();

        List<User> searchResults = new ArrayList<>();
        userName = userName.toLowerCase().strip();
        mobileNo = mobileNo.toLowerCase().strip();
        address = address.toLowerCase().strip();

        for(User user: users){
            if((!userName.isEmpty() && user.getUserName().toLowerCase().contains(userName)) ||
                    (!mobileNo.isEmpty() && user.getMobileNo().toLowerCase().contains(mobileNo)) ||
                    (!address.isEmpty() && user.getAddress().toLowerCase().contains(address))){
                searchResults.add(user);
            }
        }

        showAllusers(searchResults);
    }

    public User searchUser(String mobileNo){
        return users.stream()
                .filter(user -> user.getMobileNo().equals(mobileNo))
                .findFirst()
                .orElse(null);
    }

    public void showAllusers(){
        if(users.isEmpty()){
            System.out.println("\nNo users to show.");
        }
        else {
            for (User user : users) {
                System.out.println("\n" + user);
            }
        }
    }

    public void showAllusers(List<User> users){
        if(users.isEmpty()){
            System.out.println("\nNo users to show.");
        }
        else {
            for (User user : users) {
                System.out.println("\n" + user);
            }
        }
    }

    public void showAvailableusersCount(){
        System.out.println("\nTotal users = " + users.size());
    }

    public User takeNewUserDetails(){
        User user = new User();
        String userName;
        String mobileNo;
        String address;

        System.out.print("\nEnter the user's name: ");
        userName = scn.nextLine().strip();
        user.setUserName(userName);

        System.out.print("Enter the user's mobile number: ");
        mobileNo = scn.nextLine().strip();
        user.setMobileNo(mobileNo);

        System.out.print("Enter the user's address: ");
        address = scn.nextLine().strip();
        user.setAddress(address);

        return user;
    }
}
