package com.example.demo.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String role;

    public UserModel(){

    }

    public UserModel(String id, String firstName, String lastName, String email, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




//    @Override
//    public String toString() {
//        return "UserModel{" +
//                "id: " + id +
//                "First Name: " + firstName +
//                "Last Name: " + lastName +
//                "Email: " + email +
//                "Password: " + password +
//                "}";
//    }

}

