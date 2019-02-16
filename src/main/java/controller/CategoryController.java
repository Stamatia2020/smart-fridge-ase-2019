package main.java.controller;

import main.java.dto.Category;

import java.util.List;

public interface CategoryController {

    /**
     * Add a category.
     *
     * @param category the category
     */
    public void add(Category category);

    /**
     * List categories.
     *
     * @return A set of categories.
     */
    public List<Category> listCategories();

    /**
     * Update a category.
     *
     * @param category the category
     */
    public void update(Category category);

    /**
     * Delete a category.
     *
     * @param category the category
     */
    public void delete(Category category);

}
