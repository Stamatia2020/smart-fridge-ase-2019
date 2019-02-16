package main.java.ui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JButton btnDone;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public ProfileFrame() {

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(new ClassPathResource("/images/fridge.png").getURL()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setTitle("Smart Fridge");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		contentPane.add(panel, BorderLayout.CENTER);

		ageField = new JTextField();
		ageField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		ageField.setColumns(10);

		heightField = new JTextField();
		heightField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		heightField.setColumns(10);

		weightField = new JTextField();
		weightField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		weightField.setColumns(10);

		JLabel lblMakeYourProfile = new JLabel("Make your Profile");
		lblMakeYourProfile.setForeground(new Color(255, 255, 255));
		lblMakeYourProfile.setFont(new Font("Perpetua Titling MT", Font.BOLD, 23));

		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(255, 255, 255));
		lblAge.setFont(new Font("Perpetua Titling MT", Font.BOLD, 19));

		JLabel lblHeight = new JLabel("HEIGHT (cm)");
		lblHeight.setForeground(new Color(255, 255, 255));
		lblHeight.setFont(new Font("Perpetua Titling MT", Font.BOLD, 19));

		JLabel lblWeight = new JLabel("Weight (KG)");
		lblWeight.setForeground(new Color(255, 255, 255));
		lblWeight.setFont(new Font("Perpetua Titling MT", Font.BOLD, 19));

		btnDone = new JButton("DONE");
		btnDone.setBackground(new Color(30, 144, 255));
		btnDone.setForeground(new Color(255, 255, 255));
		btnDone.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));
		btnDone.setFocusable(false);

		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 17));
		btnBack.setBackground(new Color(30, 144, 255));
		btnBack.setForeground(Color.WHITE);
        btnBack.setFocusable(false);

        JLabel lblNewLabel = new JLabel("");

        try {
            lblNewLabel.setIcon(new ImageIcon(new ClassPathResource("/images/iconprofile.png").getURL()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addComponent(lblMakeYourProfile, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGap(147)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblWeight)
								.addComponent(lblHeight)
								.addComponent(lblAge))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(ageField, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addComponent(heightField, 0, 0, Short.MAX_VALUE)
								.addComponent(weightField, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(70))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addComponent(lblMakeYourProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(150))
				.addGroup(gl_panel.createSequentialGroup()
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
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDone)
						.addComponent(btnBack))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

    public void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Profile saved", JOptionPane.INFORMATION_MESSAGE);
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getHeightField() {
        return heightField;
    }

    public JTextField getWeightField() {
        return weightField;
    }

    public JButton getBtnDone() {
        return btnDone;
    }

    public JButton getBtnBack() {
        return btnBack;
    }
}
