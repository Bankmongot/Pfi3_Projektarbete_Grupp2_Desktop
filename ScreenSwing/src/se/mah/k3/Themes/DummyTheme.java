package se.mah.k3.Themes;

import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JLabel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

public class DummyTheme extends JPanel implements ThemeInterface {
	
	FirebaseData fbData;
	JLabel lblNewLabel_4, lblNewLabel_3, lblNewLabel_1, lblNewLabel_2, lblNewLabel;
	private int frame = 0;

	public DummyTheme(){
		System.out.println("Created DummyPanel");
		setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(32, 156, 207, 16);
		lblNewLabel_3.setText("RETA");
		add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(32, 76, 175, 16);
		lblNewLabel_1.setText("Label 1");
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(32, 115, 196, 16);
		add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(128, 27, 207, 16);
		add(lblNewLabel);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(32, 199, 187, 16);
		add(lblNewLabel_4);
		

		
		
	}
	
	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		
	
		
		lblNewLabel.setText(fbData.getQuestion());
		
		frame++;
		repaint();
	}
}
