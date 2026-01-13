package com.shahulsayyed.lms.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    List<User> users =  new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public void showMenu(){
        System.out.println();
        System.out.println("=== Library User Management System ===");
        System.out.println("1. Add user");
        System.out.println("2. Remove user (Mobile Number)");
        System.out.println("3. Search user (name/mobile-number/address)");
        System.out.println("4. Show All users");
        System.out.println("5. Available users Count");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Your choice --> ");
    }

    public void handleUserManagement(UserManager userManager){ // To navigate between different user management options.
        boolean exit = false;
        int userChoice;
        User user;

        while(!exit) {
            showMenu();
            userChoice = scn.nextInt();
            scn.nextLine();

            if(userChoice == 1){
                System.out.println();
                user = userManager.takeNewUserDetails();
                userManager.addUser(user);
                System.out.println();
                System.out.println("User added successfully.");
            }
            else if(userChoice == 2){
                System.out.println();
                System.out.print("Enter user's mobile number who is to be removed: ");
                String mobileNo = scn.nextLine().strip();
                userManager.removeUser(mobileNo);
                System.out.println();
                System.out.println("User removed successfully.");
            }
            else if(userChoice == 3){
                System.out.println();
                System.out.print("Enter the user's name: ");
                String userName = scn.nextLine().strip();

                System.out.print("Enter the user's mobile number(if you want to): ");
                String mobile = scn.nextLine().strip();

                System.out.print("Enter the user's address(if you want to): ");
                String address = scn.nextLine().strip();

                System.out.println();
                userManager.showAllusers(userManager.searchUser(userName, mobile, address));
            }
            else if(userChoice == 4){
                System.out.println();
                userManager.showAllusers();
            }
            else if(userChoice == 5){
                System.out.println();
                System.out.println("Total users = " + userManager.getAvailableusersCount());
            }
            else{
                exit = true;
            }
        }
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(String mobileNo){
        users.removeIf(user ->user.getMobileNo().equals(mobileNo));
    }

    public List<User> searchUser(String userName, String mobileNo, String address){
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

        return searchResults;
    }

    public User searchUser(String mobileNo){
        return users.stream()
                .filter(user -> user.getMobileNo().equals(mobileNo))
                .findFirst()
                .orElse(null);
    }

    public void showAllusers(){
        if(users.isEmpty()){
            System.out.println("No users to show.");
        }
        else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void showAllusers(List<User> users){
        if(users.isEmpty()){
            System.out.println("No users to show.");
        }
        else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public int getAvailableusersCount(){
        return users.size();
    }

    public User takeNewUserDetails(){
        User user = new User();
        String userName;
        String mobileNo;
        String address;

        System.out.print("Enter the user's name: ");
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
