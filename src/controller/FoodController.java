package controller;

import java.util.Set;

import dto.Food;

public interface FoodController {

	/**
	 * Add a food.
	 * 
	 * @param food
	 *            the food
	 */
	public void add(Food food);

	/**
	 * List foods by user.
	 * 
	 * @param userId
	 *            the user identifier
	 * @return A set of foods.
	 */
	public Set<Food> listFoods(int userId);

	/**
	 * Update a food.
	 * 
	 * @param food
	 *            the food
	 */
	public void update(Food food);

	/**
	 * Delete a food.
	 * 
	 * @param food
	 *            the food
	 */
	public void delete(Food food);
	
}
