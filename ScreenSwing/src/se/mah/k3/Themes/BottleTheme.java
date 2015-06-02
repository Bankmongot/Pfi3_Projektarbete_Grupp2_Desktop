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

		bottle1 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/flaska1fin.png"));
		bottle2 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/flaska2fin.png"));
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
		
		for (Bottle bottle : bottles) {
			totalVotes += bottle.votes;
			numOfBottles++;
		}
		
		double scale = (windowWidth / 1920);
		double tableWidth = (windowWidth / 4)*3;
		tableWidth = (tableWidth/6) * numOfBottles; 
		int xStart = (int) ((windowWidth - tableWidth)/2);
		
		
		
		int tableY =  (int)(windowHeight-((windowWidth/1920)*1080)+5);
		
		g2.drawImage(bcgr, 0, 0, (int) windowWidth, (int) windowHeight, this);
		
		g2.drawImage(table, 0, tableY, (int) windowWidth, (int)((windowWidth/1920)*1080), this);
		
		int bottleWidth  = (int)(219*scale);
		int bottleHeight = (int)(709*scale);
		
		int spaceBetween = (int) (((tableWidth - (bottleWidth*numOfBottles))/numOfBottles)+bottleWidth);
		
		
		int bottleCount = 0;
		for (Bottle bottle : bottles){
			g2.drawImage(bottle.image, ((bottleCount*spaceBetween)+xStart), (int)(tableY+(50*scale)), bottleWidth, bottleHeight, this); //Draw box, centered on xAlign with the bottom as origin for the y coordinate.
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
