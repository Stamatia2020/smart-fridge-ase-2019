package main.java.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.java.controller.FoodController;
import main.java.dao.FoodDao;
import main.java.dto.Food;

@Controller
public class FoodControllerImpl implements FoodController {

	@Autowired
	private FoodDao foodDao;
	
	@Override
	public void add(Food food) {
		foodDao.add(food);
	}

	@Override
	public List<Food> listFoods() {
		return foodDao.getAll();
	}

	@Override
	public void update(Food food) {
		foodDao.update(food);
	}

	@Override
	public void delete(Food food) {
		foodDao.delete(food);
	}

}
