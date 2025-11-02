package com.first.mcb.service;

import com.first.mcb.model.UserModel;
import com.first.mcb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String user1(){

        return "User is Created.";
    }

    public String createUser(UserModel user){
        UserModel userResponse =  userRepository.save(user);
        System.out.println(userResponse);
        return "Created";
    }
}
