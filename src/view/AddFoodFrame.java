package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Food;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddFoodFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField quantityField;
	private JTextField weightField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodFrame frame = new AddFoodFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddFoodFrame() {
		setTitle("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton backButton = new JButton("Back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		backButton.setBackground(new Color(30, 144, 255));
		
		JButton doneButton = new JButton("DONE");
		doneButton.setForeground(new Color(255, 255, 255));
		doneButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		doneButton.setBackground(new Color(30, 144, 255));
		
		JLabel lblAddFood = new JLabel("ADD FOOD");
		lblAddFood.setForeground(new Color(30, 144, 255));
		lblAddFood.setFont(new Font("Perpetua Titling MT", Font.BOLD, 31));
		
		nameField = new JTextField();
		nameField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		nameField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		quantityField.setColumns(10);
		
		weightField = new JTextField();
		weightField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		weightField.setColumns(10);
		
		JComboBox categoryBox = new JComboBox();
		categoryBox.setEditable(true);
		categoryBox.setBackground(new Color(255, 255, 255));
		categoryBox.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(399)
							.addComponent(doneButton)
							.addGap(18)
							.addComponent(backButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblAddFood)
							.addGap(164)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(weightField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(quantityField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
								.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddFood)
						.addComponent(categoryBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(weightField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(doneButton))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
