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
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.Toolkit;

public class FridgeFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static ArrayList<Food> foods = new ArrayList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FridgeFrame frame = new FridgeFrame();
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
	public FridgeFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FridgeFrame.class.getResource("/view/fridge.png")));
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
		
		JButton addButton = new JButton("Add");
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		addButton.setBackground(new Color(30, 144, 255));
		
		JLabel lblFoodsList = new JLabel("Foods List");
		lblFoodsList.setForeground(new Color(30, 144, 255));
		lblFoodsList.setFont(new Font("Perpetua Titling MT", Font.BOLD, 31));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFoodsList)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(addButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(backButton))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(lblFoodsList)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(backButton))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 15));
		contentPane.setLayout(gl_contentPane);
	}
}
