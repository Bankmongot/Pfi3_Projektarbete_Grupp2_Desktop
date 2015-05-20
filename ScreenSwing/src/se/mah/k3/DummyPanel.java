package se.mah.k3;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class DummyPanel extends JPanel implements ThemeInterface {
	
	FirebaseData fbData;
	JLabel lblNewLabel_3, lblNewLabel_1, lblNewLabel_2, lblNewLabel;
	private int frame = 0;

	public DummyPanel(){
		System.out.println("Created DummyPanel");
		setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(161, 224, 207, 16);
		lblNewLabel_3.setText("RETA");
		//lblNewLabel_3.setText(fbData.getQuestion());
		add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(161, 81, 175, 16);
		lblNewLabel_1.setText("Label 1");
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(161, 151, 196, 16);
		add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(161, 33, 207, 16);
		add(lblNewLabel);
		
		
	}
	
	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		lblNewLabel_3.setText(fbData.getQuestion());
		lblNewLabel_1.setText("Frame: "+frame);
		frame++;
		repaint();
	}
	
	

}
