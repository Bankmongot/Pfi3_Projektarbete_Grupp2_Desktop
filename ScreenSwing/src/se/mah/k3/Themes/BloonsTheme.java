package se.mah.k3.Themes;

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
import se.mah.k3.Themes.VerticalBoxes.GraphBox;

public class BloonsTheme extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -123L;

	FirebaseData fbData;
	HashMap<String, Double> percent;
	int yFloor = 0;
	int graphHeight = 0;
	int xAlign = 200; //Where all the circles should be x-wise
	int yAlign = 200;
	int barOffset = 150;
	String question = "place holder question";

	JLabel myLabel;

	List<GraphOval> ovals = new ArrayList<GraphOval>();

	double windowWidth;
	double windowHeight;
	
    Image clouds;


	Font font  = new Font("Roboto", Font.PLAIN, 36); //Answers
	Font font2 = new Font("Roboto", Font.PLAIN, 36); //Question

	public BloonsTheme(){

		
		setLayout(null);
		setPreferredSize(new Dimension(1920,1080));
		setMinimumSize(new Dimension(1920,1080));

		//Needed for ugly fix, displaying the graph instantly when a survey is started.
		myLabel = new JLabel("New label");
		myLabel.setBounds(161, 224, 207, 16);
		myLabel.setText("");
		add(myLabel);

		    /*ovals.add(new GraphOval("Loading answer..."));
		    ovals.add(new GraphOval("Loading answer..."));
		    ovals.add(new GraphOval("Loading answer..."));
		   
		    ovals.add(new GraphOval(200, 50, 25, Color.red));
		    ovals.add(new GraphOval(200, 100,30, Color.green));
		    ovals.add(new GraphOval(200, 130,70, Color.blue));
		   
*/
		clouds = Toolkit.getDefaultToolkit().getImage(BloonsTheme.class.getResource("/images/clouds.png"));
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
		double biggestOval = 0.0; //Biggest circle needed to align text nicely
		double allOvalsHeight = 0.0; //Total height of all the circles, must be double: using it for division.
		int totalVotes = 0;

		//Add size of all circles to allOvalsHeight and calc totalVotes
		for (GraphOval oval : ovals) {
			int votes = oval.votes;
			allOvalsHeight += votes;
			totalVotes += votes;
		}

		//Find the biggest circle 
		for (GraphOval oval : ovals) {
			int ovalSize = oval.votes;
			double tempPercent = ovalSize / allOvalsHeight;
			double foo =  (int) Math.floor(tempPercent*graphHeight); 
			if (foo > biggestOval) biggestOval = foo;
		}

		//Draw background
		g2.drawImage(clouds, 0, 0, (int) windowWidth, (int) windowHeight, this);

		//Bar on left
		g2.setColor(Color.black);
		
		int nextY = yFloor; //Used to draw circles on top of each other. 

		//
		for (GraphOval oval : ovals) {
			if (oval.votes > 0){
				int size = oval.votes; //Circle size.
				double percent = size / allOvalsHeight; //One circle in percent.
				size = (int) Math.floor(percent*graphHeight); //circle size in percent converted to circle size relative to the max height.

				
				g2.fillOval(xAlign - (size/2), nextY-size, size, size); //Draw circle, centered on xAlign with the bottom as origin for the y coordinate.
				g2.drawString(oval.answer, (int)(xAlign + (biggestOval/2)) + 50 , (nextY-(size/2)+(fontHeight/2))-5); // Answer, aligned by the biggest circle
				g2.drawString((int)Math.floor(percent*100)+"%", (int)((xAlign - (biggestOval/2)) - (barOffset - 40)), (nextY-(size/2)+(fontHeight/2))-5); //Votes in %, -||-

				nextY -= size; //Subtracts the current circle size, allowing the next circle to be placed on top
			}
		}

		g2.drawString(String.valueOf(totalVotes), (int)(xAlign - (biggestOval/2) - barOffset - 10 - fm.stringWidth(String.valueOf(totalVotes))), yFloor); //Total number of votes

		g2.setFont(font2); //Set the font for the title
		g2.drawString(question, 50, 50);  //The title //TODO: Positioning
	}

	@Override
	public void updateData(FirebaseData data) {
		fbData = data;

		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();
		question = fbData.getQuestion();

		System.out.println("BloonsTheme, updateData(). Data received: " + fbData.getAnswers() + " " + fbData.getVotes());

		for (int i = ovals.size(); i<answers.size(); i++){
			ovals.add(new GraphOval(answers.get(i), Color.red ));
			System.out.println("Added oval");
		}

		//Add data to circles
		System.out.println("Ovals"+ ovals.size());
		System.out.println("Answers"+ answers.size());
		System.out.println("Votes"+ votes.size());

		for(int i = 0; i<answers.size(); i++){
			ovals.get(i).update((int) (votes.get(i)), answers.get(i));
			System.out.println("Updated oval");
		}

		//Ugly fix to automatically show the theme when it's launched.
		myLabel.setText( fbData.getQuestion() );
		myLabel.setText("");

		repaint();
	}

	class GraphOval{
		int votes = 0;
		String answer;

		//xPos is centered, yPos is on the top 
    	   int size;

    	   Color color;

           GraphOval (String a, Color color){
           this.size = size;
        //  int xAlign;
        //  this.xPos = xAlign - (size/2);

           this.color = color;
        

		}

		void update(int votes, String answer){ 
			this.votes = votes;
			this.answer = answer;

		}
	}
}
