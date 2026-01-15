package com.shahulsayyed.lms.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> users =  new ArrayList<>();
    private Scanner scn = new Scanner(System.in);

    void addUser(){
        User user = takeNewUserDetails();
        users.add(user);
        System.out.println("\nUser added successfully.");
    }

    void removeUser(){
        System.out.print("\nEnter user's mobile number who is to be removed: ");
        String mobileNo = scn.nextLine().strip();
        users.removeIf(user ->user.getMobileNo().equals(mobileNo));
        System.out.println("\nUser removed successfully.");
    }

    void searchUser(){
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

    void showAllusers(){
        if(users.isEmpty()){
            System.out.println("\nNo users to show.");
        }
        else {
            for (User user : users) {
                System.out.println("\n" + user);
            }
        }
    }

    void showAllusers(List<User> users){
        if(users.isEmpty()){
            System.out.println("\nNo users to show.");
        }
        else {
            for (User user : users) {
                System.out.println("\n" + user);
            }
        }
    }

    void showAvailableusersCount(){
        System.out.println("\nTotal users = " + users.size());
    }

    User takeNewUserDetails(){
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
