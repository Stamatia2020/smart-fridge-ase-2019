package dao;

import java.util.List;

import dto.Category;

public interface CategoryDao {

	/**
	 * Add a category.
	 * 
	 * @param category the given category
	 */
	void add(Category category);

	/**
	 * Get all categories.
	 * 
	 * @return all categories
	 */
	List<Category> getAll();

	/**
	 * Get a category by an identifier.
	 * 
	 * @param id the given identifier
	 * @return a category by its identifier.
	 */
	Category get(int id);

	/**
	 * Update an existing category.
	 * 
	 * @param category the given category
	 */
	void update(Category category);

	/**
	 * Delete a category.
	 * 
	 * @param category the given category
	 */
	void delete(Category category);

}
