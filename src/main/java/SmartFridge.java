package main.java;

import main.java.dao.impl.CategoryDaoImpl;
import main.java.dto.Category;
import main.java.ui.controllers.MainController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SmartFridge {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SmartFridge.class)
                .headless(false)
                .web(false)
                .run();

        // this is a workaround to the resources/sql/h2-data.sql approach
        populateDatabaseCategories(ctx.getBean(CategoryDaoImpl.class));

        EventQueue.invokeLater(() -> {
            MainController mainController = ctx.getBean(MainController.class);
            mainController.prepareAndShowFrame();
        });
    }

    /**
     * Populates the database with some predefined food categories.
     * If the database already contains categories no action is taken.
     *
     * @param categoryDao, the categories DAO object
     */
    private static void populateDatabaseCategories(CategoryDaoImpl categoryDao) {

        if (categoryDao.getAll().size() == 0) {

            System.out.print("Populating database with food categories... ");
            categoryDao.add(Category.COOKED);
            categoryDao.add(Category.DAIRY);
            categoryDao.add(Category.FRUITS);
            categoryDao.add(Category.VEGETABLES);
            categoryDao.add(Category.SWEETS);
            System.out.println("done.");

        }

    }
}