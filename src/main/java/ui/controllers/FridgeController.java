package main.java.ui.controllers;

import main.java.dao.CategoryDao;
import main.java.dao.impl.FoodDaoImpl;
import main.java.dto.Category;
import main.java.dto.Food;
import main.java.ui.views.AddFoodFrame;
import main.java.ui.views.FridgeFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller
public class FridgeController extends AbstractFrameController {

    private FridgeFrame fridgeFrame;
    private MainController mainController;
    private AddFoodFrame addFoodFrame;
    private CategoryDao categoryDao;
    private FoodDaoImpl foodDao;

    @Autowired
    public FridgeController(
            FridgeFrame fridgeFrame,
            AddFoodFrame addFoodFrame,
            @Lazy MainController mainController,
            CategoryDao categoryDao,
            FoodDaoImpl foodDao) {
        this.fridgeFrame = fridgeFrame;
        this.mainController = mainController;
        this.addFoodFrame = addFoodFrame;
        this.categoryDao = categoryDao;
        this.foodDao = foodDao;
    }

    @Override
    public void prepareAndShowFrame() {
        // attach button listeners
        registerAction(fridgeFrame.getAddButton(), (e -> showAddFoodForm()));
        registerAction(fridgeFrame.getBackButton(), (e -> returnToMainFrame()));

        fridgeFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void showAddFoodForm() {
        // initialize dropdown list with food categories
        addFoodFrame.getCategoryBox().setModel(new DefaultComboBoxModel(categoryDao.getAll().toArray()));

        // attach button listeners
        registerAction(addFoodFrame.getDoneButton(), (e -> storeFood()));
        registerAction(addFoodFrame.getBackButton(), (e -> returnToFridgeFrame()));

        addFoodFrame.setVisible(true);
        fridgeFrame.dispose();
    }

    private void storeFood() {
        Food food = new Food();
        food.setCategory((Category) addFoodFrame.getCategoryBox().getSelectedItem());
        food.setName(addFoodFrame.getNameField().getText());
        food.setCalories(Double.parseDouble(addFoodFrame.getCaloriesField().getText()));
        food.setQuantity(Integer.parseInt(addFoodFrame.getQuantityField().getText()));
        foodDao.add(food);

        fridgeFrame.setVisible(true);
        addFoodFrame.dispose();
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

    private void returnToFridgeFrame() {
        fridgeFrame.setVisible(true);
        addFoodFrame.dispose();
    }
}
