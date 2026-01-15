package com.shahulsayyed.lms.user;

public class User {
    private String userName;
    private String mobileNo;
    private String address;

     String getUserName() {
        return userName;
    }

     void setUserName(String userName) {
        this.userName = userName;
    }

     String getMobileNo() {
        return mobileNo;
    }

     void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

     String getAddress() {
        return address;
    }

     void setAddress(String address) {
        this.address = address;
    }

    @Override
     public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
