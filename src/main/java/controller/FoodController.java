package main.java.controller;

import java.util.List;

import main.java.dto.Food;

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
	 * @return A set of foods.
	 */
	public List<Food> listFoods();

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
