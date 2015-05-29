package se.mah.k3.Themes;

import java.awt.AWTError;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

public class VerticalBoxes extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -7667456219668361746L;

	FirebaseData fbData;
	HashMap<String, Double> percent;
	int yFloor = 0;
	int graphHeight = 0;
	int xAlign = 0; //Where all the boxes should be x-wise
	int barOffset = 150;

	JLabel myLabel;

	List<GraphBox> boxes = new ArrayList<GraphBox>();

	double windowWidth;
	double windowHeight;

	Image iceCube;
	Image bcgr;

	Font font  = new Font("Roboto", Font.PLAIN, 36); //Answers
	Font font2 = new Font("Roboto", Font.PLAIN, 36); //Question

	public VerticalBoxes(){

		setLayout(null);
		setPreferredSize(new Dimension(1920,1080));
		setMinimumSize(new Dimension(1920,1080));

		//Needed for ugly fix, displaying the graph instantly when a survey is started.
		myLabel = new JLabel("New label");
		myLabel.setBounds(161, 224, 207, 16);
		myLabel.setText("");
		add(myLabel);

//		boxes.add(new GraphBox("Loading answer..."));
//		boxes.add(new GraphBox("Loading answer..."));
//		boxes.add(new GraphBox("Loading answer..."));

		iceCube = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/blockTexture.png"));
		bcgr = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/gradientBackground.png"));

		font = new Font("Roboto", Font.PLAIN, 36);
		font2 = new Font("Roboto", Font.PLAIN, 46);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Determining window-size on every repaint enables smooth re-scaling
		Dimension dim = this.getSize();
		windowWidth = dim.getWidth();
		windowHeight = dim.getHeight();
		graphHeight = (int) (windowHeight - (windowHeight/3));
		yFloor = (int) (windowHeight - (windowHeight / 12));
		xAlign = (int) windowWidth / 3;

		Graphics2D g2 = (Graphics2D)g; //Create the graphics2D object we'll use for drawing
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Anti aliasing, mainly for text
		g2.setFont(font); //Font used for answers 
		FontMetrics fm = g2.getFontMetrics(); //Needed to figure out size of the text
		int fontHeight = fm.getAscent(); //Height of font
		double biggestBox = 0.0; //Biggest box needed to align text nicely
		double allBoxesHeight = 0.0; //Total height of all the boxes, must be double: using it for division.
		int totalVotes = 0;

		//Add size of all boxes to allBoxesHeight and calc totalVotes
		for (GraphBox box : boxes) {
			int votes = box.votes;
			allBoxesHeight += votes;
			totalVotes += votes;
		}

		//Find the biggest box 
		for (GraphBox box : boxes) {
			int boxSize = box.votes;
			double tempPercent = boxSize / allBoxesHeight;
			double foo =  (int) Math.floor(tempPercent*graphHeight); 
			if (foo > biggestBox) biggestBox = foo;
		}

		//Draw background
		g2.drawImage(bcgr, 0, 0, (int) windowWidth, (int) windowHeight, this);

		//Bar on left
		g2.setColor(Color.black);
		g2.fillRect((int)(xAlign - (biggestBox/2) - barOffset), yFloor-graphHeight, 10, graphHeight);

		int nextY = yFloor; //Used to draw boxes on top of each other. 

		//
		for (GraphBox box : boxes) {
			if (box.votes > 0){
				int size = box.votes; //Box size.
				double percent = size / allBoxesHeight; //One box in percent.
				size = (int) Math.floor(percent*graphHeight); //Box size in percent converted to box size relative to the max height.

				g2.fillRect((int)(xAlign - (biggestBox/2) - barOffset), nextY-((size+10)/2), 30, 10); //Line on the bar to the left.
				g2.drawImage(iceCube, xAlign - (size/2), nextY-size, size, size, this); //Draw box, centered on xAlign with the bottom as origin for the y coordinate.
				g2.drawString(box.answer, (int)(xAlign + (biggestBox/2)) + 50 , (nextY-(size/2)+(fontHeight/2))-5); // Answer, aligned by the biggest box
				g2.drawString((int)Math.floor(percent*100)+"%", (int)((xAlign - (biggestBox/2)) - (barOffset - 40)), (nextY-(size/2)+(fontHeight/2))-5); //Votes in %, -||-

				nextY -= size; //Subtracts the current box's size, allowing the next box to be placed on top
			}
		}
		
		g2.drawString(String.valueOf(totalVotes), (int)(xAlign - (biggestBox/2) - barOffset - 10 - fm.stringWidth(String.valueOf(totalVotes))), yFloor); //Total number of votes
		
		g2.setFont(font2); //Set the font for the title
		g2.drawString(fbData.getQuestion(), 50, 50);  //The title //TODO: Positioning
	}

	@Override
	public void updateData(FirebaseData data) {
		fbData = data;
		
		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();
		
		System.out.println("Vertical boxes, updateData(). Data received: " + fbData.getAnswers());
		if(boxes.isEmpty()){
			for(int i = 0; i<answers.size(); i++){
				boxes.add(new GraphBox(answers.get(i)));
			}
		}else{
			//Add data to boxes
			for(int i = 0; i<answers.size(); i++){
				boxes.get(i).update((int) (votes.get(i)), answers.get(i));
			}
		}

		//Ugly fix to automatically show the theme when it's launched.
		myLabel.setText( fbData.getQuestion() );
		myLabel.setText("");

		repaint();
	}

	class GraphBox{
		int votes = 0;
		String answer;

		GraphBox(String a){ this.answer = a; }
		void update(int votes, String answer){ 
			this.votes = votes;
			this.answer = answer;
		
		}
	}
}