package com.hitaek.springboot.crudepractice.service;

import com.hitaek.springboot.crudepractice.dao.UserDAO;
import com.hitaek.springboot.crudepractice.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }

}
