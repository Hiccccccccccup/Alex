package com.jozz.alex.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jozz.alex.entity.User;
import com.jozz.alex.entity.UserExample;
import com.jozz.alex.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> find(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(user.getName())) {
            criteria.andNameLike(user.getName().concat("%"));
        }
        List<User> all = userMapper.selectByExample(example);
        return all;
    }
    public PageInfo<User> findByPage(User user, Integer pageSize, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = this.find(user);
        return new PageInfo<User>(users);
    }

    public void add(User user){
        userMapper.insert(user);
    }
    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    public User detail(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    public void delete(Integer id){
        int num = userMapper.deleteByPrimaryKey(id);
    }



}
