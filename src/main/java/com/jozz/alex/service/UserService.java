package com.jozz.alex.service;


import com.jozz.alex.entity.User;
import com.jozz.alex.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        List<User> all = userMapper.findAll();
        return all;
    }
    public void add(User user){
        userMapper.add(user);
    }



}
