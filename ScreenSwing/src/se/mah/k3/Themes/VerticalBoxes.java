package se.mah.k3.Themes;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

public class VerticalBoxes extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -7667456219668361746L;
	
	FirebaseData fbData;
	JLabel myLabel;

	public VerticalBoxes(){
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		
		myLabel = new JLabel("New label");
		myLabel.setBounds(161, 224, 207, 16);
		myLabel.setText("The question will appear here!");
		add(myLabel);
	}

	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
}