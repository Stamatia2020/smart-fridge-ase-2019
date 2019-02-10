package main.java.dao;

import main.java.dto.User;

public interface UserDao {

    /**
     * Add a user.
     *
     * @param user the given category
     */
    void add(User user);

    /**
     * Get a user by an identifier.
     *
     * @param id the given identifier
     * @return a user by its identifier.
     */
    User getById(int id);

    /**
     * Get first user.
     *
     * @return a user by its identifier.
     */
    User getFirst();

    /**
     * Update an existing category.
     *
     * @param user the given category
     */
    void update(User user);

}
