package main.java.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.dao.CategoryDao;
import main.java.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the category in the database.
     */
	@Override
	public void add(Category category) {
	    entityManager.persist(category);
	}

    /**
     * Return all the categories stored in the database.
     */
	@Override
    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        return entityManager.createQuery("from Category").getResultList();
	}

    /**
     * Return the category having the passed id.
     */
	@Override
	public Category getById(int id) {
        return entityManager.find(Category.class, id);
	}

    /**
     * Update the passed category in the database.
     */
    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    /**
     * Delete the category from the database.
     */
    @Override
    public void delete(Category category) {
        if (entityManager.contains(category))
            entityManager.remove(category);
        else
            entityManager.remove(entityManager.merge(category));
    }

}
