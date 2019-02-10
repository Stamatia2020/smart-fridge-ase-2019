package main.java.ui.controllers;

import main.java.ui.views.AddFoodFrame;
import main.java.ui.views.FridgeFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class FridgeController extends AbstractFrameController {

    private FridgeFrame fridgeFrame;
    private MainController mainController;
    private AddFoodFrame addFoodFrame;

    @Autowired
    public FridgeController(FridgeFrame fridgeFrame, AddFoodFrame addFoodFrame, @Lazy MainController mainController) {
        this.fridgeFrame = fridgeFrame;
        this.mainController = mainController;
        this.addFoodFrame = addFoodFrame;
    }

    @Override
    public void prepareAndShowFrame() {
        // attach button listeners
        registerAction(fridgeFrame.getAddButton(), (e -> showFoodForm()));
        registerAction(fridgeFrame.getBackButton(), (e -> returnToMainFrame()));

        fridgeFrame.setVisible(true);
    }

    private void showFoodForm() {

        // TODO: clear all text fields before revealing

        addFoodFrame.setVisible(true);
        fridgeFrame.dispose();
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }
}
