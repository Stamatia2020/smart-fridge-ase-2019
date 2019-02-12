package main.java.dao;

import main.java.dto.Food;

import java.util.List;

public interface FoodDao {

    /**
     * Add a food.
     *
     * @param food the given food
     */
    void add(Food food);

    /**
     * Get all foods.
     *
     * @return all foods
     */
    List<Food> getAll();

    /**
     * Get a food by an identifier.
     *
     * @param id the given identifier
     * @return a food by its identifier.
     */
    Food getById(int id);

    /**
     * Get a food by its name.
     *
     * @param name the given name
     * @return a food by its identifier.
     */
    Food getByName(String name);

    /**
     * Update an existing food.
     *
     * @param food the given food
     */
    void update(Food food);

    /**
     * Delete a food.
     *
     * @param food the given food
     */
    void delete(Food food);

}
