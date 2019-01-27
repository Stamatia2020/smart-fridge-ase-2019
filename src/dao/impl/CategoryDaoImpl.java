package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CategoryDao;
import dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession = sessionFactory.getCurrentSession();

	@Override
	public void add(Category category) {

		try {
			currentSession.persist(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> getAll() {

		List<Category> data = new ArrayList<>();
		try {
			CriteriaBuilder builder = currentSession.getCriteriaBuilder();

			CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
			criteriaQuery.from(Category.class);

			data = currentSession.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public Category get(int id) {
		return currentSession.get(Category.class, Integer.valueOf(id));
	}

	@Override
	public void update(Category category) {

		try {
			currentSession.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Category category) {

		try {
			currentSession.delete(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
