package se.mah.k3.Themes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.Helpers;
import se.mah.k3.ThemeInterface;

public class VerticalBoxes extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -7667456219668361746L;

	FirebaseData fbData;
	HashMap<String, Double> percent;
	int yFloor = 625;
	int height = 600;
	int xAlign = 512; //Where all the boxes should be x-wise
	
	
	JLabel myLabel;
	GraphBox box;
	List<GraphBox> boxes = new ArrayList<GraphBox>();

	public VerticalBoxes(){
		
		//percent = Helpers.calcPercent(fbData.getInData());
		
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		
		boxes.add(new GraphBox(200, 50, Color.blue));
		boxes.add(new GraphBox(200, 100, Color.orange));
		boxes.add(new GraphBox(200, 130, Color.yellow));
		
		myLabel = new JLabel("New label");
		myLabel.setBounds(161, 224, 207, 16);
		myLabel.setText("The question will appear here!");
		add(myLabel);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.fillRect(500, 500, 50, 50);
		
		//g.drawString(fbData.getQuestion(), 100, 30);
		//g.drawString(String.valueOf(fbData.getVote1()), 25, 35);
		
		int y = 50;
		for (GraphBox box : boxes) {
			g.setColor(box.color);
			g.fillRect(box.xPos, y, box.size, box.size);
			y += box.size;
			box.yPos = y;
		}
		//g.fillRect(100, 10, 60, 50);
		
		g.setColor(Color.black);
		g.drawString(fbData.getAlt1(), 100, (boxes.get(0).yPos)-(boxes.get(0).size/2));
		g.drawString(fbData.getAlt2(), 100, (boxes.get(1).yPos)-(boxes.get(1).size/2));
		g.drawString(fbData.getAlt3(), 100, (boxes.get(2).yPos)-(boxes.get(2).size/2));
		
		g.drawString(String.valueOf(fbData.getVote1()), xAlign-5, (boxes.get(0).yPos)-(boxes.get(0).size/2));
		g.drawString(String.valueOf(fbData.getVote2()), xAlign-5, (boxes.get(1).yPos)-(boxes.get(1).size/2));
		g.drawString(String.valueOf(fbData.getVote3()), xAlign-5, (boxes.get(2).yPos)-(boxes.get(2).size/2));
	}

	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		
		//Stoppa in storlekarna i rutorna
		
		boxes.get(0).setSize((int) (50 + fbData.getVote1()*2));
		boxes.get(1).setSize((int) (50 + fbData.getVote2()*2));
		boxes.get(2).setSize((int) (50 + fbData.getVote3()*2));
		
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
	
	class GraphBox{
		//xPos is centered, yPos is on the top
		int size;
		int grow = 0;
		int xPos;
		int yPos;
		Color color;
		
		GraphBox(int size, int yPos, Color color){
			this.size = size;
			this.xPos = xAlign - (size/2);
			this.yPos = yPos;
			this.color = color;
		}
		void setSize(int size){
			this.size = size;
			xPos = xAlign - (size/2);
		}
		
	}
}