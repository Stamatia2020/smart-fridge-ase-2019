package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame frame = new ProfileFrame();
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
	public ProfileFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProfileFrame.class.getResource("/view/fridge.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setTitle("Smart Fridge");
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		ageField = new JTextField();
		ageField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		ageField.setColumns(10);

		heightField = new JTextField();
		heightField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		heightField.setColumns(10);

		weightField = new JTextField();
		weightField.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 14));
		weightField.setColumns(10);

		JLabel lblMakeYourProfile = new JLabel("Make your Profile");
		lblMakeYourProfile.setForeground(new Color(30, 144, 255));
		lblMakeYourProfile.setFont(new Font("Perpetua Titling MT", Font.BOLD, 23));

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));

		JLabel lblHeight = new JLabel("HEIGHT (cm)");
		lblHeight.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));

		JButton btnDone = new JButton("DONE");
		btnDone.setBackground(new Color(30, 144, 255));
		btnDone.setForeground(new Color(255, 255, 255));
		btnDone.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));

		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));
		btnBack.setBackground(new Color(30, 144, 255));
		btnBack.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProfileFrame.class.getResource("/view/iconprofile.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addComponent(lblMakeYourProfile, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHeight)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblWeight)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAge)
									.addGap(18)))))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addComponent(weightField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(heightField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
					.addGap(70))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addComponent(lblMakeYourProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(150))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(heightField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHeight))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(weightField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeight))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnDone))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
