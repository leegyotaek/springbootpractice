package com.hitaek.springboot.crudepractice.dao;

import com.hitaek.springboot.crudepractice.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {

        // get current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();

        // execute the query and get result list
        return users;
    }

    @Override
    public User findById(int userId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        User user =
                currentSession.get(User.class, userId);

        if(user==null)
            throw new RuntimeException("User is not found - " + userId);

        return user;

    }

    @Override
    public User save(User user) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);  // if id==0이면 save if not 일 경우 update

        return user;

    }

    @Override
    public void deleteById(int userId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query query =
                currentSession.createQuery(
                        "delete from User where id=:userId");

        query.setParameter("userId", userId);

        query.executeUpdate();

    }

}
