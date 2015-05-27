package se.mah.k3.Themes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	int graphHeight = 600;
	int xAlign = 512; //Where all the boxes should be x-wise
	
	
	JLabel myLabel;
	GraphBox box;
	List<GraphBox> boxes = new ArrayList<GraphBox>();

	public VerticalBoxes(){
		
		//percent = Helpers.calcPercent(fbData.getInData());
		
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		
		boxes.add(new GraphBox(Color.blue));
		boxes.add(new GraphBox(Color.orange));
		boxes.add(new GraphBox(Color.yellow));
		
		myLabel = new JLabel("New label");
		myLabel.setBounds(161, 224, 207, 16);
		myLabel.setText("The question will appear here!");
		add(myLabel);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Denna metoden behöver städas
		Graphics2D g2 = (Graphics2D)g;
		
		g2.fillRect(500, 500, 50, 50);
		
		int numOfBoxes = boxes.size();
		double allBoxesHeight = 0.0;
		
		for (GraphBox box : boxes) {
			allBoxesHeight += (box.size + box.grow + box.votes);
		}
		
		if( allBoxesHeight > graphHeight ){
			//Boxes in percent
			
			int nextY = yFloor;
			for (GraphBox box : boxes) {
				
				//Total size of the box
				int sizeT = box.size + box.grow + box.votes;
				
				//One box in percent
				double percent = sizeT / allBoxesHeight;
				
				//Box size in percent converted to box size relative to the max height
				sizeT = (int) Math.floor(percent*graphHeight);
				
				g2.setColor(box.color);
				g2.fillRect(xAlign - (sizeT/2), nextY-sizeT, sizeT, sizeT);
				nextY -= (sizeT);
			}
			
		}else{
			//Boxes in px
			
			int nextY = yFloor;
			for (GraphBox box : boxes) {
				int sizeT = box.size + box.grow + box.votes;
				g2.setColor(box.color);
				g2.fillRect(xAlign - (sizeT/2), nextY-sizeT, sizeT, sizeT);
				nextY -= (sizeT);
			}
		}
	}
	
	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		
		//Stoppa in storlekarna i rutorna
		
		boxes.get(0).update((int) (fbData.getVote1()*2));
		boxes.get(1).update((int) (fbData.getVote2()*2));
		boxes.get(2).update((int) (fbData.getVote3()*2));
		
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
	
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if(boxes.size() == 0){

			}else{
				for(GraphBox box : boxes){
					//box.update();
				}
				repaint();
			}
		}
	};
	
	class GraphBox{
		//xPos is centered, yPos is on the top
		int size = 50; //Initial size
		int grow = 0;
		int xPos;
		int yPos;
		Color color;
		int votes;
		
		GraphBox(Color color){
			this.xPos = xAlign - (size/2);
			this.color = color;
		}
		void setSize(int size){
			this.size = size;
			xPos = xAlign - (size/2);
		}
		void update(int votes){
			this.votes = votes*2;
		}
		
	}
}