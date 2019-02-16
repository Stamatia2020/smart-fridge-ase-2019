package main.java.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.java.controller.CategoryController;
import main.java.dao.CategoryDao;
import main.java.dto.Category;

@Controller
public class CategoryControllerImpl implements CategoryController {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void add(Category category) {
		categoryDao.add(category);

	}

	@Override
	public List<Category> listCategories() {
		return categoryDao.getAll();
	}

}
