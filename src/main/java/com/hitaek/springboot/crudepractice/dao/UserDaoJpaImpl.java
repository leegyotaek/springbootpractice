package com.hitaek.springboot.crudepractice.dao;

import com.hitaek.springboot.crudepractice.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoJpaImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {

        Query query =
                entityManager.createQuery("from User");

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findById(int userId) {
        User user =
                entityManager.find(User.class, userId);

        return user;
    }

    @Override
    public void save(User user) {

        // save or update user
        User dbUser = entityManager.merge(user);

        user.setId(dbUser.getId());

    }

    @Override
    public void deleteById(int userId) {

        Query query = entityManager.createQuery(
                "delete  from User where id=:userId");

        query.setParameter("userId" , userId);

        query.executeUpdate();

    }
}
