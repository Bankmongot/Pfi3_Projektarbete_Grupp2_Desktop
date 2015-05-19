package se.mah.k3;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class DummyPanel extends JPanel implements ThemeInterface {
	
	FirebaseData fbData;

	public DummyPanel(){
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(161, 224, 61, 16);
		lblNewLabel_3.setText(fbData.getQuestion());
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(161, 81, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(161, 151, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(161, 33, 61, 16);
		add(lblNewLabel);
		
		
	}
	
	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
	}
	
	

}
