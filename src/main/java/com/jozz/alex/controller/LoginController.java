package com.jozz.alex.controller;

import com.jozz.alex.entity.User;
import com.jozz.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController("/")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public List<User> login(){
        List<User> all = userService.findAll();
        return all;


    }
    @RequestMapping("/add")
    public void add(@RequestBody User user){
        userService.add(user);
    }


}
