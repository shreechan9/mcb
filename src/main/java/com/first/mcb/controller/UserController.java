package com.first.mcb.controller;

import com.first.mcb.model.UserModel;
import com.first.mcb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/name1")
    public String user1(){
     String userResponse   =userService.user1();
     return userResponse;
    }

    @PostMapping("/createUser")
    public String create(@RequestBody UserModel user){
        System.out.println(user.getUserName()+" "+ user.getPassword());
         return userService.createUser(user);
    }


    @GetMapping("/getUser")
    public List<UserModel> getUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public UserModel deleteUserById(@PathVariable Long id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUserById/{id}")
    public UserModel updateUserById(@PathVariable Long id, @RequestBody UserModel user ){
         return userService.updateUserById(id, user);
    }





}
