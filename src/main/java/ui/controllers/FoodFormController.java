package main.java.ui.controllers;

import main.java.dao.CategoryDao;
import main.java.dao.impl.FoodDaoImpl;
import main.java.dto.Category;
import main.java.dto.Food;
import main.java.ui.views.AddFoodFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;


@Controller
public class FoodFormController extends AbstractFrameController {

    private AddFoodFrame addFoodFrame;
    private FridgeController fridgeController;
    private CategoryDao categoryDao;
    private FoodDaoImpl foodDao;
    private boolean isEditMode = false;

    @Autowired
    public FoodFormController(AddFoodFrame addFoodFrame, FridgeController fridgeController, CategoryDao categoryDao, FoodDaoImpl foodDao) {
        this.addFoodFrame = addFoodFrame;
        this.fridgeController = fridgeController;
        this.categoryDao = categoryDao;
        this.foodDao = foodDao;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void prepareAndShowFrame() {

        // initialize dropdown list with food categories
        addFoodFrame.getCategoryBox().setModel(new DefaultComboBoxModel(categoryDao.getAll().toArray()));

        // reset field for create
        if (!isEditMode) {
            addFoodFrame.getNameField().setText("");
            addFoodFrame.getCaloriesField().setText("");
            addFoodFrame.getQuantityField().setText("");
        }

        // attach button listeners
        registerAction(addFoodFrame.getDoneButton(), (e -> storeFood()));
        registerAction(addFoodFrame.getBackButton(), (e -> returnToFridgeFrame()));

        addFoodFrame.setVisible(true);
    }

    private void storeFood() {
        Food food = new Food();
        food.setCategory((Category) addFoodFrame.getCategoryBox().getSelectedItem());
        food.setName(addFoodFrame.getNameField().getText());
        food.setCalories(Double.parseDouble(addFoodFrame.getCaloriesField().getText()));
        food.setQuantity(Integer.parseInt(addFoodFrame.getQuantityField().getText()));
        foodDao.add(food);

        returnToFridgeFrame();
    }

    private void returnToFridgeFrame() {
        fridgeController.prepareAndShowFrame();
        addFoodFrame.dispose();
    }

    public void setEditMode(boolean editMode) {
        isEditMode = editMode;
    }
}
