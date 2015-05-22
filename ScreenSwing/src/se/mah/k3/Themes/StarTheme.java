package se.mah.k3.Themes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StarTheme extends JPanel implements ThemeInterface {

	FirebaseData fbData;
	JLabel lblQuestionHere;
	private int frame = 0;
	private JTextField txtQuestionHere;
	
	public StarTheme(){
		setBackground(new Color(0, 0, 51));
		setPreferredSize (new Dimension(1024, 768));
		setMinimumSize (new Dimension(1024, 768));
		System.out.println("Created StarPanel");
		setLayout(null);
		
		
		JLabel lblQuestionHere = new JLabel("Question?");
		lblQuestionHere.setBackground(new Color(0, 255, 0));
		lblQuestionHere.setFont(new Font("Roboto", Font.BOLD, 77));
		lblQuestionHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionHere.setForeground(Color.WHITE);
		lblQuestionHere.setBounds(70, 35, 884, 91);
		add(lblQuestionHere);
	//	lblQuestionHere.setText(fbData.getQuestion());		


		/*lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(161, 81, 175, 16);
		lblNewLabel_1.setText("Label 1");
		add(lblNewLabel_1);
		lblNewLabel_3.setText(fbData.getQuestion());*/
		
	}
	
	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		/*fbData = data;
		lblQuestionHere.setText(fbData.getQuestion());
		*/
		repaint();
	} 
	
	protected void paintComponent(Graphics g) {
		 //g.setColor(getBackground()); // x , y , w, h , let stay null
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-01.png")), 70, 400, 300, 300, null);
       //g.fillRect(0, 0, getWidth(), getHeight());
		this.repaint();
	}

}
