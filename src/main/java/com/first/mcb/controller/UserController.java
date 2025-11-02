package com.first.mcb.controller;

import com.first.mcb.model.UserModel;
import com.first.mcb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
