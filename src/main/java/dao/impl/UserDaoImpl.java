package main.java.dao.impl;

import main.java.dao.UserDao;
import main.java.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the user in the database.
     */
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    /**
     * Get a user from the database.
     */
    @Override
    public User getById(int id) {
        return entityManager.find(User.class,id);
    }

    /**
     * Get the first user from the database.
     */
    @Override
    public User getFirst() {
        return entityManager.find(User.class,1);
    }

    /**
     * Update the user in the database.
     */
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
