package com.example.demo.controllers;
import com.example.demo.CustomizedResponse;
import com.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController

{
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody UserModel user)
    {


        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            var response = new CustomizedResponse( "You login Successfully", null);

            return new ResponseEntity( response, HttpStatus.OK);

        }

        catch (BadCredentialsException ex)
        {

            var response = new CustomizedResponse( "You username/password were entered incorrectly..", null);

            return new ResponseEntity( response, HttpStatus.UNAUTHORIZED);
        }



    }



}