package main.java.ui.controllers;

import main.java.ui.views.ProfileFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController extends AbstractFrameController {

    private ProfileFrame profileFrame;
    private MainController mainController;

    @Autowired
    public ProfileController(ProfileFrame profileFrame, MainController mainController) {
        this.profileFrame = profileFrame;
        this.mainController = mainController;
    }

    @Override
    public void prepareAndShowFrame() {
        registerAction(profileFrame.getBtnDone(), (e -> saveProfile()));
        registerAction(profileFrame.getBtnBack(), (e -> returnToMainFrame()));
        profileFrame.setVisible(true);
    }

    private void saveProfile() {
        // TODO: validate & save form
    }

    private void returnToMainFrame() {
        profileFrame.dispose();
        mainController.prepareAndShowFrame();
    }
}
