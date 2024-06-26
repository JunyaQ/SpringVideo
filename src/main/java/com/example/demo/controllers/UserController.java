package com.example.demo.controllers;


import com.example.demo.CustomizedResponse;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers()
    {

        var response = new CustomizedResponse( " A list of all users ", userService.getUsers());

        return new ResponseEntity( response, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getAUsers(@PathVariable("id") String id)
    {

        var response = new CustomizedResponse( " UserModel with id  : " + id, Collections.singletonList(userService.getAUser(id)));

        return new ResponseEntity( response, HttpStatus.OK);

    }

    @PostMapping(value = "/users", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createUsers(@RequestBody UserModel user)
    {


        var response = new CustomizedResponse( " User created successfully", Collections.singletonList(userService.addUser(user)));

        return new ResponseEntity( response, HttpStatus.OK);

    }


}
