package main.java.ui.controllers;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class AbstractFrameController {

    abstract public void prepareAndShowFrame();

    protected void registerAction(JButton button, ActionListener listener) {
        removeExistingListeners(button);
        button.addActionListener(listener);
    }

    private void removeExistingListeners(JButton button) {
        ActionListener[] listeners = button.getActionListeners();

        for (ActionListener l : listeners) {
            button.removeActionListener(l);
        }
    }

}
