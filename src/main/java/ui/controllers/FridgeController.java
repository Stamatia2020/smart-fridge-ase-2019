package main.java.ui.controllers;

import main.java.ui.views.FridgeFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class FridgeController extends AbstractFrameController {

    private FridgeFrame fridgeFrame;
    private MainController mainController;

    @Autowired
    public FridgeController(FridgeFrame fridgeFrame, @Lazy MainController mainController) {
        this.fridgeFrame = fridgeFrame;
        this.mainController = mainController;
    }

    @Override
    public void prepareAndShowFrame() {
        // attach button listeners
        registerAction(fridgeFrame.getBackButton(), (e -> returnToMainFrame()));

        fridgeFrame.setVisible(true);
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        fridgeFrame.dispose();
    }
}
