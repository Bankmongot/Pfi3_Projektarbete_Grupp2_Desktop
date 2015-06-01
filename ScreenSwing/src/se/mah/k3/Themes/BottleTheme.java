package se.mah.k3.Themes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;




public class BottleTheme extends JPanel implements ThemeInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirebaseData fbData;
	JLabel myLabel;



	public BottleTheme(){

		setBackground(Color.WHITE);
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));


		//Rubrik
		myLabel = new JLabel("New label");
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		myLabel.setBounds(0, 24, 1070, 106);
		myLabel.setText("The question will appear here!");
		add(myLabel);



	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);



	}



	@Override
	public void updateData(FirebaseData data) {
		fbData = data;
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
}
