package main.java.dao.impl;

import main.java.dao.FoodDao;
import main.java.dto.Food;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("foodDao")
@Transactional
public class FoodDaoImpl implements FoodDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save the food in the database.
     */
    @Override
    public void add(Food food) {
        entityManager.persist(food);
    }

    /**
     * Return all the foods stored in the database.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Food> getAll() {
        return entityManager.createQuery("from Food").getResultList();
    }

    /**
     * Return the food having the passed id.
     */
    @Override
    public Food getById(int id) {
        return entityManager.find(Food.class, id);
    }

    /**
     * Return the food having the passed name.
     */
    @Override
    public Food getByName(String name) {
        return entityManager.find(Food.class, name);
    }

    /**
     * Update the passed food in the database.
     */
    @Override
    public void update(Food food) {
        entityManager.merge(food);
    }

    /**
     * Delete the food from the database.
     */
    @Override
    public void delete(Food food) {
        if (entityManager.contains(food))
            entityManager.remove(food);
        else
            entityManager.remove(entityManager.merge(food));
    }
}
