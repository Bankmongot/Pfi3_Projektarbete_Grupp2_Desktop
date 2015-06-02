package se.mah.k3.Themes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SwingConstants;





public class BottleTheme extends JPanel implements ThemeInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirebaseData fbData;
	JLabel myLabel;
	ArrayList<Bottle> bottles = new ArrayList<Bottle>();
	Image bottle1;
	Image bottle2;
	Image bcgr;
	Image table;



	public BottleTheme(){

		setBackground(Color.WHITE);
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));

		bottle1 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/Flaska1.png"));
		bottle2 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/Flaska2.png"));
		bcgr = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/bottles.png"));
		table = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/table.png"));


		//Rubrik
		myLabel = new JLabel("New label");
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		myLabel.setBounds(0, 24, 1070, 106);
		myLabel.setText("The question will appear here!");
		add(myLabel);



	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //Create the graphics2D object we'll use for drawing
		
		//Determining window-size on every repaint enables smooth re-scaling
		Dimension dim = this.getSize();
		double windowWidth = dim.getWidth();
		double windowHeight = dim.getHeight();
		int numOfBottles = 0;
		int totalVotes = 0;
		
		double scale = (windowWidth / 1920);
		double tableWidth = (windowWidth / 4)*3;
		int xStart = (int) ((windowWidth - tableWidth)/2);
		
		for (Bottle bottle : bottles) {
			totalVotes += bottle.votes;
			numOfBottles++;
		}
		
		int bottleWidth = (int)(283*scale);
		
		g2.fillRect(xStart, 500, (int) tableWidth, 10);
		
		int spaceBetween = (int) (((tableWidth - (bottleWidth*numOfBottles))/numOfBottles)+bottleWidth);
		
		
		int bottleCount = 0;
		for (Bottle bottle : bottles){
			g2.drawImage(bottle.image, ((bottleCount*spaceBetween)+xStart), 100, (int)(283*scale), (int)(709*scale), this); //Draw box, centered on xAlign with the bottom as origin for the y coordinate.
			bottleCount++;
		}


	}



	@Override
	public void updateData(FirebaseData data) {
		fbData = data;

		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();

		System.out.println("Vertical boxes, updateData(). Data received: " + fbData.getAnswers() + " " + fbData.getVotes());
		
		for(int i = bottles.size(); i<answers.size(); i++){
			if(Math.random() > 0.5) bottles.add(new Bottle(bottle1));
			else bottles.add(new Bottle(bottle2));
			System.out.println("Added box");
		}

		for(int i = 0; i<answers.size(); i++){
			bottles.get(i).update((int) (votes.get(i)), answers.get(i));
			System.out.println("Updated box");
		}

		myLabel.setText(fbData.getQuestion());

		repaint();
	}
	class Bottle{
		int votes = 0;
		String answer;
		Image image;

		Bottle(Image img){ this.image = img; }
		void update(int votes, String answer){ 
			this.votes = votes;
			this.answer = answer;

		}
	}
}
