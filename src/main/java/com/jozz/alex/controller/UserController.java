package com.jozz.alex.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jozz.alex.entity.User;
import com.jozz.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/queryList")
    public PageInfo<User> queryList(@RequestBody User user, Integer pageSize, Integer pageNum){
        PageInfo<User> all = userService.findByPage(user, pageSize, pageNum);
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
    public User detail(@PathVariable Integer id){
        return userService.detail(id);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
}
