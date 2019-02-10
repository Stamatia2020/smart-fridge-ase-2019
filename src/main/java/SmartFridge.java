package main.java;

import main.java.ui.controllers.MainController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SmartFridge {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SmartFridge.class)
                .headless(false)
                .web(false)
                .run();

        MainController mainController = ctx.getBean(MainController.class);
        mainController.prepareAndShowFrame();
    }

}