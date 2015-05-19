package se.mah.k3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//A vector is like an ArrayList a little bit slower but Thread-safe. This means that it can handle concurrent changes. 
	Font font = new Font("Avenir next", Font.BOLD, 40);
	
	private int frame = 0;
	

	
	
	public DrawPanel() {
		
	}
	
	
	

	
	//Called when the screen needs a repaint.
	@Override
	public void paint(Graphics g) {

		frame++;
		super.paint(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setFont(font);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setColor(Color.BLACK);
		
		g.drawString("Frame: "+frame, 250, 50);
		
		g.setColor(Color.black);
		g.drawString(Constants.question, 100, 50);
		
		Font fontt = new Font("Avenir next", Font.BOLD, 20);
		
		g2.setFont(fontt);

			 g.setColor(Color.YELLOW);
			 g.fillOval(50-Constants.x1/2, 50-Constants.x1/2, Constants.x1, Constants.x1);
		
		
			 g.setColor(Color.RED);
			 g.fillOval(250-Constants.x2/2, 50-Constants.x2/2, Constants.x2, Constants.x2);
		

			 g.setColor(Color.GREEN);
			 g.fillOval(50-Constants.x3/2, 250-Constants.x3/2, Constants.x3, Constants.x3);
		
		
			 g.setColor(Constants.green);	 
			 g.fillOval(250-Constants.x4/2, 250-Constants.x4/2, Constants.x4, Constants.x4);
			 g.setColor(Color.white);
			 g.drawString(Long.toString(Constants.alt4C), 238, 260);
			 g.setColor(Color.BLACK);
			 g.drawString(Constants.alt4,210, 280+Constants.x4/2);

			 
			 g.setColor(Constants.pink);
			 g.fillOval(150, 575, 150, 150);
			 g.setColor(Color.white);
			 g.drawString("15", 210, 660);
			 g.setColor(Color.BLACK);
			 g.drawString(Constants.alt3, 180, 750);
			 
			 g.setColor(Constants.blue);
			 g.fillOval(650, 475, 50, 50);
			 g.setColor(Color.white);
			 g.drawString("3", 668, 508);
			 g.setColor(Color.BLACK);
			 g.drawString(Constants.alt2, 650, 560);
		
	}
}

	