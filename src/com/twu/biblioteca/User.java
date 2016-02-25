package com.twu.biblioteca;

public class User {

    private String name;
    private String email;
    private String phone;
    private String libraryNo;
    private String password;

    public User(String newName, String newEmail, String newPhone, String newLibraryNo, String newPassword) {
        name = newName;
        email = newEmail;
        phone = newPhone;
        libraryNo = newLibraryNo;
        password = newPassword;
    }

    public String getLibraryNo() {
        return libraryNo;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
