package com.first.mcb.service;

import com.first.mcb.model.UserModel;
import com.first.mcb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserModel> getAllUsers() {

        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with : "+ id));
    }

    public UserModel deleteUserById(Long id) {
        UserModel response =  userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found."));
         userRepository.delete(response);

         return response;
    }

    public UserModel updateUserById(Long id, UserModel user) {
        UserModel response = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Updated."));
        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());

       return userRepository.save(response);


    }
}
