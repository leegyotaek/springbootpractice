package com.hitaek.springboot.crudepractice.controller;

import com.hitaek.springboot.crudepractice.dao.UserDAO;
import com.hitaek.springboot.crudepractice.entity.User;
import com.hitaek.springboot.crudepractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User findOne(@PathVariable int userId){
        return userService.findById(userId);
    }

    @PutMapping("/users/")
    public void update(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public void delteById(@PathVariable int userId){
        userService.deleteById(userId);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

}
