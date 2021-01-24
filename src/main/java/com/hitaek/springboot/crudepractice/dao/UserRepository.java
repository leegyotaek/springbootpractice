package com.hitaek.springboot.crudepractice.dao;

import com.hitaek.springboot.crudepractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
