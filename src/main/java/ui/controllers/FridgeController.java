package main.java.ui.controllers;

import main.java.dao.FoodDao;
import main.java.dto.Food;
import main.java.ui.views.FridgeFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.swing.table.DefaultTableModel;
import java.util.EnumSet;

@Controller
public class FridgeController extends AbstractFrameController {

    private FridgeFrame fridgeFrame;
    private MainController mainController;
    private FoodFormController foodFormController;
    private FoodDao foodDao;

    @Autowired
    public FridgeController(FridgeFrame fridgeFrame, @Lazy FoodFormController foodFormController, @Lazy MainController mainController, FoodDao foodDao) {
        this.fridgeFrame = fridgeFrame;
        this.mainController = mainController;
        this.foodFormController = foodFormController;
        this.foodDao = foodDao;
    }

    @Override
    public void prepareAndShowFrame() {
        // prepare table model and initialize JTable
        fridgeFrame.initializeFoodTable(prepareFoodTableModel());

        // attach button listeners
        registerAction(fridgeFrame.getAddButton(), (e -> showAddFoodForm()));
        registerAction(fridgeFrame.getBackButton(), (e -> returnToMainFrame()));

        fridgeFrame.setVisible(true);
    }

    private DefaultTableModel prepareFoodTableModel() {
        String[] columnNames = {"Name", "Quantity (g)", "Calories (kCal)", "Actions"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (Food food : foodDao.getAll()) {
            Object[] o = new Object[5];
            o[0] = food.getName();
            o[1] = food.getQuantity();
            o[2] = food.getCalories();
            o[3] = EnumSet.allOf(FridgeFrame.Actions.class);
            model.addRow(o);
        }
        return model;
    }

    private void showAddFoodForm() {
        foodFormController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }

}
