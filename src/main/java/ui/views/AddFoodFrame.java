package main.java.ui.views;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;

@Component
public class AddFoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField quantityField;
	private JTextField caloriesField;
	private JLabel lblCategoty;
	private JLabel lblName;
	private JLabel lblQuantity;
	private JLabel lblCalories;
	private JLabel lblNewLabel;
	private JButton backButton;

	/**
	 * Create the frame.
	 */
	public AddFoodFrame() {

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(new ClassPathResource("/images/fridge.png").getURL()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        setTitle("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		backButton = new JButton("Back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		backButton.setBackground(new Color(30, 144, 255));
		
		JButton doneButton = new JButton("DONE");
		doneButton.setForeground(new Color(255, 255, 255));
		doneButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		doneButton.setBackground(new Color(30, 144, 255));
		
		JLabel lblAddFood = new JLabel("ADD FOOD");
		lblAddFood.setForeground(new Color(255, 255, 255));
		lblAddFood.setFont(new Font("Perpetua Titling MT", Font.BOLD, 31));
		
		nameField = new JTextField();
		nameField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		nameField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setToolTipText("");
		quantityField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		quantityField.setColumns(10);
		
		caloriesField = new JTextField();
		caloriesField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		caloriesField.setColumns(10);
		
		JComboBox categoryBox = new JComboBox();
		categoryBox.setEditable(true);
		categoryBox.setBackground(new Color(255, 255, 255));
		categoryBox.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		
		lblCategoty = new JLabel("Category");
		lblCategoty.setForeground(new Color(255, 255, 255));
		lblCategoty.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblCategoty.setLabelFor(categoryBox);
		
		lblName = new JLabel("NAME");
		lblName.setLabelFor(nameField);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		
		lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblQuantity.setForeground(new Color(255, 255, 255));
		
		lblCalories = new JLabel("Calories");
		lblCalories.setForeground(new Color(255, 255, 255));
		lblCalories.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		
		lblNewLabel = new JLabel("");
        try {
            lblNewLabel.setIcon(new ImageIcon(new ClassPathResource("/images/foods.png").getURL()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblAddFood))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(lblNewLabel)
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblQuantity)
								.addComponent(lblName)
								.addComponent(lblCalories)
								.addComponent(lblCategoty))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
								.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(caloriesField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(quantityField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(doneButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(backButton)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(lblAddFood)
							.addGap(16)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoty))
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(caloriesField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCalories))
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(backButton)
								.addComponent(doneButton))))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

    public JButton getBackButton() {
        return backButton;
    }
}
