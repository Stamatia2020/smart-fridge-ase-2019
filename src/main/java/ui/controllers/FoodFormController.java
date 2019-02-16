package main.java.ui.controllers;

import main.java.controller.CategoryController;
import main.java.controller.FoodController;
import main.java.dto.Category;
import main.java.dto.Food;
import main.java.ui.views.AddFoodFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;

@Controller
public class FoodFormController extends AbstractFrameController {

    private static final String CREATE_BUTTON_LABEL = "Add";
    private static final String EDIT_BUTTON_LABEL = "Update";

    private AddFoodFrame addFoodFrame;
    private FridgeController fridgeController;
    private CategoryController categoryController;
    private FoodController foodController;
    private Food food = null;

    @Autowired
    public FoodFormController(AddFoodFrame addFoodFrame, FridgeController fridgeController, CategoryController categoryController, FoodController foodController) {
        this.addFoodFrame = addFoodFrame;
        this.fridgeController = fridgeController;
        this.categoryController = categoryController;
        this.foodController = foodController;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void prepareAndShowFrame() {
        // initialize dropdown list with food categories
        addFoodFrame.getCategoryBox().setModel(new DefaultComboBoxModel(categoryController.listCategories().toArray()));

        // reset fields for create or populate for edit
        if (food == null) {
            addFoodFrame.getCategoryBox().setSelectedIndex(0);
            addFoodFrame.getNameField().setText("");
            addFoodFrame.getCaloriesField().setText("");
            addFoodFrame.getQuantityField().setText("");
            addFoodFrame.getDoneButton().setText(CREATE_BUTTON_LABEL);
        } else {
            addFoodFrame.getCategoryBox().setSelectedIndex(food.getCategory().getId() - 1);
            addFoodFrame.getNameField().setText(food.getName());
            addFoodFrame.getCaloriesField().setText(String.valueOf(food.getCalories()));
            addFoodFrame.getQuantityField().setText(String.valueOf(food.getQuantity()));
            addFoodFrame.getDoneButton().setText(EDIT_BUTTON_LABEL);
        }

        // attach button listeners
        registerAction(addFoodFrame.getDoneButton(), (e -> storeFood()));
        registerAction(addFoodFrame.getBackButton(), (e -> returnToFridgeFrame()));

        addFoodFrame.setVisible(true);
    }

    private void storeFood() {
        // insert or update
        if (this.food == null) {
            Food food = new Food();
            food.setCategory((Category) addFoodFrame.getCategoryBox().getSelectedItem());
            food.setName(addFoodFrame.getNameField().getText());
            food.setCalories(Double.parseDouble(addFoodFrame.getCaloriesField().getText()));
            food.setQuantity(Integer.parseInt(addFoodFrame.getQuantityField().getText()));
            foodController.add(food);
        } else {
            this.food.setCategory((Category) addFoodFrame.getCategoryBox().getSelectedItem());
            this.food.setName(addFoodFrame.getNameField().getText());
            this.food.setCalories(Double.parseDouble(addFoodFrame.getCaloriesField().getText()));
            this.food.setQuantity(Integer.parseInt(addFoodFrame.getQuantityField().getText()));
            foodController.update(this.food);
        }

        returnToFridgeFrame();
    }

    private void returnToFridgeFrame() {
        fridgeController.prepareAndShowFrame();
        addFoodFrame.dispose();
    }

    public void setEditEntity(Food food) {
        this.food = food;
    }
}
