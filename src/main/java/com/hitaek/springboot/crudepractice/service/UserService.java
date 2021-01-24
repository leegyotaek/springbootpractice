package com.hitaek.springboot.crudepractice.service;

import com.hitaek.springboot.crudepractice.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int userId);

    public void save(User user);

    public void deleteById(int userId);

}
