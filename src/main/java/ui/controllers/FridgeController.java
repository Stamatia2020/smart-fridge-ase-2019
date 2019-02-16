package main.java.ui.controllers;

import main.java.controller.FoodController;
import main.java.dto.Food;
import main.java.ui.views.FridgeFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.EnumSet;

@Controller
public class FridgeController extends AbstractFrameController {

    private FridgeFrame fridgeFrame;
    private MainController mainController;
    private FoodFormController foodFormController;
    private FoodController foodController;

    public static final int NAME_COLUMN_ID = 0;
    public static final int QUANTITY_COLUMN_ID = 1;
    public static final int CALORIES_COLUMN_ID = 2;
    public static final int ACTIONS_COLUMN_ID = 3;
    public static final int MODEL_COLUMN_ID = 4;

    public static final String NAME_COLUMN_TITLE = "Name";
    public static final String QUANTITY_COLUMN_TITLE = "Quantity (g)";
    public static final String CALORIES_COLUMN_TITLE = "Calories (kCal)";
    public static final String ACTIONS_COLUMN_TITLE = "Actions";
    public static final String MODEL_COLUMN_TITLE = "";

    public static final String[] COLUMN_NAMES_ARRAY = {
            NAME_COLUMN_TITLE,
            QUANTITY_COLUMN_TITLE,
            CALORIES_COLUMN_TITLE,
            ACTIONS_COLUMN_TITLE,
            MODEL_COLUMN_TITLE
    };

    @Autowired
    public FridgeController(
            @Lazy FridgeFrame fridgeFrame,
            @Lazy FoodFormController foodFormController,
            @Lazy MainController mainController,
            FoodController foodController
    ) {
        this.fridgeFrame = fridgeFrame;
        this.mainController = mainController;
        this.foodFormController = foodFormController;
        this.foodController = foodController;
    }

    @Override
    public void prepareAndShowFrame() {
        // prepare food table model and trigger init
        fridgeFrame.initializeFoodTable(prepareFoodTableModel());

        // attach button listeners
        registerAction(fridgeFrame.getAddButton(), (e -> showAddFoodForm()));
        registerAction(fridgeFrame.getBackButton(), (e -> returnToMainFrame()));

        fridgeFrame.setVisible(true);
    }

    private DefaultTableModel prepareFoodTableModel() {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(COLUMN_NAMES_ARRAY);

        for (Food food : foodController.listFoods()) {
            Object[] o = new Object[5];
            o[NAME_COLUMN_ID] = food.getName();
            o[QUANTITY_COLUMN_ID] = food.getQuantity();
            o[CALORIES_COLUMN_ID] = food.getCalories();
            o[ACTIONS_COLUMN_ID] = EnumSet.allOf(FridgeFrame.Actions.class);
            o[MODEL_COLUMN_ID] = food;
            model.addRow(o);
        }
        return model;
    }

    public void editFoodAction(Food food) {
        foodFormController.setEditEntity(food);
        foodFormController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

    public void deleteFoodAction(Food food) {
        int answer = fridgeFrame.confirmationBox("Are you sure you want to delete " + food.getName() + "?");
        if(answer == JOptionPane.YES_OPTION){
            foodController.delete(food);
            fridgeFrame.initializeFoodTable(prepareFoodTableModel());
        }
    }

    private void showAddFoodForm() {
        foodFormController.setEditEntity(null);
        foodFormController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

}
