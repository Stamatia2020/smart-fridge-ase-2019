package main.java.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.java.controller.UserController;
import main.java.dao.UserDao;
import main.java.dto.User;

@Controller
public class UserControllerImpl implements UserController {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public User get(int userId) {
		return userDao.getById(userId);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}
}
