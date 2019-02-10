package main.java.ui.controllers;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class AbstractFrameController {

    abstract public void prepareAndShowFrame();

    protected void registerAction(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

}
