package main.java.ui.controllers;

import main.java.ui.views.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class MainController extends AbstractFrameController {

    private MainFrame mainFrame;
    private ProfileController profileController;
    private FridgeController fridgeController;

    @Autowired
    public MainController(MainFrame mainFrame, @Lazy ProfileController profileController, @Lazy FridgeController fridgeController) {
        this.mainFrame = mainFrame;
        this.profileController = profileController;
        this.fridgeController = fridgeController;
    }

    @Override
    public void prepareAndShowFrame() {
        registerAction(mainFrame.getProfileButton(), (e -> showProfileFrame()));
        registerAction(mainFrame.getFridgeButton(), (e -> showFoodsFrame()));
        registerAction(mainFrame.getExitButton(), (e -> terminate()));
        mainFrame.setVisible(true);
    }

    private void showProfileFrame() {
        mainFrame.dispose();
        profileController.prepareAndShowFrame();
    }

    private void showFoodsFrame() {
        fridgeController.prepareAndShowFrame();
    }

    private void terminate() {
        mainFrame.dispose();
    }
}
