package com.parkinglot.model;

import com.parkinglot.enums.VehicleType.UserType;

public class User {
    String userName;
    String email;
    UserType userType;

    public User(String userName, String email, UserType userType) {
        this.userName = userName;
        this.email = email;
        this.userType = userType;
    }

    // getters and setters
    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public UserType getUserType() {
        return this.userType;
    }


}
