package com.hitaek.springboot.crudepractice.service;

import com.hitaek.springboot.crudepractice.dao.UserDAO;
import com.hitaek.springboot.crudepractice.dao.UserRepository;
import com.hitaek.springboot.crudepractice.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //private UserDAO userDao;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int userId) {
        Optional<User> result = userRepository.findById(userId);

        User user = null;

        if(result.isPresent()){
            user = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + userId);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    /*

    change to user JpaRepository

    public UserServiceImpl(@Qualifier("userDaoJpaImpl") UserDAO userDao) {
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
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }*/

}
