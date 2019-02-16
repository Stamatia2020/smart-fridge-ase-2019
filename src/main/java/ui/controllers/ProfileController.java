package main.java.ui.controllers;

import main.java.controller.UserController;
import main.java.dto.User;
import main.java.ui.views.ProfileFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController extends AbstractFrameController {

    private ProfileFrame profileFrame;
    private MainController mainController;
    private UserController userController;
    private User user;

    @Autowired
    public ProfileController(ProfileFrame profileFrame, MainController mainController, UserController userController) {
        this.profileFrame = profileFrame;
        this.mainController = mainController;
        this.userController = userController;
        user = this.userController.get(1);
    }

    @Override
    public void prepareAndShowFrame() {
        // update text fields with database values
        if (userExists()) {
            profileFrame.getWeightField().setText(String.valueOf(user.getWeight()));
            profileFrame.getHeightField().setText(String.valueOf(user.getHeight()));
            profileFrame.getAgeField().setText(String.valueOf(user.getAge()));
        }

        // attach button listeners
        registerAction(profileFrame.getBtnDone(), (e -> saveProfile()));
        registerAction(profileFrame.getBtnBack(), (e -> returnToMainFrame()));

        // reveal frame
        profileFrame.setVisible(true);
    }

    private void saveProfile() {
        // fetch user profile details from form
        double weight = Double.parseDouble(profileFrame.getWeightField().getText().trim());
        double height = Double.parseDouble(profileFrame.getHeightField().getText().trim());
        int age = Integer.parseInt(profileFrame.getAgeField().getText().trim());

        // create a user if not exists
        if (!userExists()) {
            user = new User();
        }

        // set attributes
        user.setWeight(weight);
        user.setHeight(height);
        user.setAge(age);

        // insert/update
        if (!userExists()) {
            userController.add(user);
        } else {
            userController.update(user);
        }

        profileFrame.infoBox("Profile updated successfully!");
    }

    private void returnToMainFrame() {
        mainController.prepareAndShowFrame();
        profileFrame.dispose();
    }

    private boolean userExists() {
        return user != null;
    }

}
