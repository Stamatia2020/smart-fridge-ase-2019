package main.java.controller;

import main.java.dto.User;

public interface UserController {

	/**
	 * Add a user.
	 * 
	 * @param user
	 *            the user
	 */
	public void add(User user);

	/**
	 * Get the current user
	 * 
	 * @param userId
	 *            the user identifier
	 * @return A user by the given userId.
	 */
	public User get(int userId);

	/**
	 * Update a user.
	 * 
	 * @param user
	 *            the user
	 */
	public void update(User user);

	/**
	 * Delete a user.
	 * 
	 * @param user
	 *            the user
	 */
	public void delete(User user);

}
