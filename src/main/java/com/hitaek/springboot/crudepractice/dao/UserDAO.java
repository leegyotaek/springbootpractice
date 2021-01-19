package com.hitaek.springboot.crudepractice.dao;

import com.hitaek.springboot.crudepractice.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findById(int userId);

    public User save(User user);

    public void deleteById(int userId);

}
