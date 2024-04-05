package com.example.demo.services;


import com.example.demo.models.UserModel;
import com.example.demo.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    //lazy fix circular dependency issues
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel addUser(UserModel user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        UserModel insertedUser = userRepository.insert(user);

        return insertedUser;
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getAUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel findUser = userRepository.findByEmail(email);
        String userN = findUser.getEmail();
        String userP = findUser.getPassword();
        return new User(userN, userP, new ArrayList<>());
    }

}