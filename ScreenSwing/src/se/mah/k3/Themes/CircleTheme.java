package se.mah.k3.Themes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import se.mah.k3.Constants;
import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import se.mah.k3.*;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class CircleTheme extends JPanel implements ThemeInterface{
	private static final long serialVersionUID = 1L;
	//A vector is like an ArrayList a little bit slower but Thread-safe. This means that it can handle concurrent changes. 
	Font font = new Font("Avenir next", Font.BOLD, 40);
	String question = "Dummy";
	private int frame = 0;
	private final JTextField txtHejhejhejhej = new JTextField();
	

	
	
	public CircleTheme() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 121, 1, 1);
		panel.setBackground(Color.PINK);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(82, 5, 292, 233);
		lblNewLabel.setIcon(new ImageIcon(CircleTheme.class.getResource("/resourcesforIceCream/countmeinlogo-01.png")));
		add(lblNewLabel);
		txtHejhejhejhej.setBackground(Color.WHITE);
		txtHejhejhejhej.setEditable(false);
		txtHejhejhejhej.setEnabled(false);
		txtHejhejhejhej.setHorizontalAlignment(SwingConstants.CENTER);
		txtHejhejhejhej.setFont(new Font("Roboto Cn", Font.PLAIN, 20));
		txtHejhejhejhej.setText("No current survey");
		txtHejhejhejhej.setBounds(0, 249, 450, 40);
		add(txtHejhejhejhej);
		txtHejhejhejhej.setColumns(10);
		System.out.println("Created DrawPanel");
		
	}
	


	
//	
//
//	
//	//Called when the screen needs a repaint.
//	@Override
//	public void paint(Graphics g) {
//
//		frame++;
//		super.paint(g);
//		Graphics2D g2= (Graphics2D) g;
//		g2.setFont(font);
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, getSize().width, getSize().height);
//		g2.setColor(Color.BLACK);
//		
//		g.drawString("Frame: "+frame, 250, 50);
//		
//		g.setColor(Color.red);
//		g.drawString(question, 100, 90);
//		
//		Font fontt = new Font("Avenir next", Font.BOLD, 20);
//		
//		g2.setFont(fontt);
//
//			 g.setColor(Color.YELLOW);
//			 g.fillOval(50-Constants.x1/2, 50-Constants.x1/2, Constants.x1, Constants.x1);
//		
//		
//			 g.setColor(Color.RED);
//			 g.fillOval(250-Constants.x2/2, 50-Constants.x2/2, Constants.x2, Constants.x2);
//		
//
//			 g.setColor(Color.GREEN);
//			 g.fillOval(50-Constants.x3/2, 250-Constants.x3/2, Constants.x3, Constants.x3);
//		
//		
//			 g.setColor(Constants.green);	 
//			 g.fillOval(250-Constants.x4/2, 250-Constants.x4/2, Constants.x4, Constants.x4);
//			 g.setColor(Color.white);
//			 g.drawString(Long.toString(Constants.alt4C), 238, 260);
//			 g.setColor(Color.BLACK);
//			 g.drawString(Constants.alt4,210, 280+Constants.x4/2);
//
//			 
//			 g.setColor(Constants.pink);
//			 g.fillOval(150, 575, 150, 150);
//			 g.setColor(Color.white);
//			 g.drawString("15", 210, 660);
//			 g.setColor(Color.BLACK);
//			 g.drawString(Constants.alt3, 180, 750);
//			 
//			 g.setColor(Constants.blue);
//			 g.fillOval(650, 475, 50, 50);
//			 g.setColor(Color.white);
//			 g.drawString("3", 668, 508);
//			 g.setColor(Color.BLACK);
//			 g.drawString(Constants.alt2, 650, 560);
//		
//	}
		@Override
		public void updateData(FirebaseData data) {
			// TODO Auto-generated method stub
			question = data.getQuestion();
			//invalidate();
			repaint();
		}
//
//
//
//
//
}
//
//
	