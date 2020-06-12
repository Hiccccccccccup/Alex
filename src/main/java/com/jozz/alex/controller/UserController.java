package com.jozz.alex.controller;

import com.jozz.alex.entity.User;
import com.jozz.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping("/detail/{id}")
    public User detail(@PathVariable Long id){
        return userService.detail(id);
    }

}
