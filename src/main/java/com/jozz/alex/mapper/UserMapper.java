package com.jozz.alex.mapper;

import com.jozz.alex.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();
    void add(User user);

}
