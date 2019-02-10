package main.java.ui.controllers;

import main.java.dao.impl.UserDaoImpl;
import main.java.dto.User;
import main.java.ui.views.ProfileFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProfileController extends AbstractFrameController {

    private ProfileFrame profileFrame;
    private MainController mainController;
    private UserDaoImpl userDao;
    private User user;

    @Autowired
    public ProfileController(ProfileFrame profileFrame, MainController mainController, UserDaoImpl userDao) {
        this.profileFrame = profileFrame;
        this.mainController = mainController;
        this.userDao = userDao;
        user = userDao.getFirst();
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
            userDao.add(user);
        } else {
            userDao.update(user);
        }

        // TODO: fix this from appearing multiple times
        profileFrame.infoBox("Profile updated successfully!");
    }

    private void returnToMainFrame() {
        profileFrame.dispose();
        mainController.prepareAndShowFrame();
    }

    private boolean userExists() {
        return user != null;
    }

}
