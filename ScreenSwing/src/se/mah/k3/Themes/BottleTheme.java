package se.mah.k3.Themes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
	ArrayList<Color> colors = new ArrayList<Color>();
	Image bottle1;
	Image bottle2;
	Image bcgr;
	Image table;
	Image liquidGradient;



	public BottleTheme(){

		setBackground(Color.WHITE);
		setLayout(null);
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));

		bottle1 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/flaska1234.png"));
		bottle2 = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/flaska2fin.png"));
		bcgr = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/bottles.png"));
		table = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/table.png"));
		liquidGradient = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/bottleGradient.png"));
		
		colors.add(new Color(Integer.parseInt("fd8a85",16)));
		colors.add(new Color(Integer.parseInt("feba07",16)));
		colors.add(new Color(Integer.parseInt("e5dbcd",16)));
		colors.add(new Color(Integer.parseInt("ff8f01",16)));
		colors.add(new Color(Integer.parseInt("01c5f7",16)));
		colors.add(new Color(Integer.parseInt("eff277",16)));


		//Question
		myLabel = new JLabel("New label");
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Roboto", Font.BOLD, 50));
		myLabel.setBounds(0, 24, 1070, 106);
		myLabel.setText("The question will appear here!");
		add(myLabel);



	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		//Font fontQuestuion = new Font("Roboto", Font.PLAIN, 50);
		//Font fontAnswer = new Font("Roboto", Font.PLAIN, 30);
		
		Graphics2D g2 = (Graphics2D)g; //Create the graphics2D object we'll use for drawing
		Graphics2D g2A = (Graphics2D) g.create();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Anti aliasing, mainly for text
		
		float alpha = 0.8f;
        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        g2A.setComposite(alcom);
		
		//Determining window-size on every repaint enables smooth re-scaling
		Dimension dim = this.getSize();
		double windowWidth = dim.getWidth();
		double windowHeight = dim.getHeight();
		
		//Set graph width to two thirds of the display
		double graphWidth = windowWidth-(windowWidth/3);
		
		//Calculate scale with 1920z1080 as 1:1
		double scaleWindow = (windowWidth / 1920);
		double scale = (graphWidth / 1920);
		
		//Set maximum table width to 3/4 of the graph width
		double tableWidth = graphWidth-(graphWidth / 4);
		
		//Loop through bottles to get total amount of votes (and how many bottles there are while we're at it) 
		int numOfBottles = 0;
		double totalVotes = 0;
		for (Bottle bottle : bottles) {
			totalVotes += bottle.votes;
			numOfBottles++;
		}
		
		//Reduce the table width depending on number of answers. 
		tableWidth = (tableWidth/6) * numOfBottles; 
		
		//Center the virtual table the bottles are drawn on.
		int xStart = (int) ((graphWidth - tableWidth)/2);
		
		//Calculate where to put bottles for them to be on the table
		int tableY =  (int)(windowHeight-((graphWidth/1920)*1080)+5);
		
		//Calculate width and height of the bottles in relation to scale. The numbers here are the image dimensions in pixels.
		int bottleWidth  = (int)(219*scale);
		int bottleHeight = (int)(709*scale);
		
		//Calculate width of each bottle including space between them
		int spaceBetween = (int) (((tableWidth - (bottleWidth*numOfBottles))/numOfBottles)+bottleWidth);
		
		int fontSize = (int) (40*scaleWindow);
		Font fontAnswer = new Font("Roboto", Font.PLAIN, fontSize);
		
		//DRAWING :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		
		g2.setFont(fontAnswer);
		
		//Draw background image
		g2.drawImage(bcgr, 0, 0, (int) windowWidth, (int) windowHeight, this);
		//Draw table
		g2.drawImage(table, 0, tableY, (int) graphWidth, (int)((graphWidth/1920)*1080), this);
		
		//Drawing loop.
		int bottleCount = 0;
		for (Bottle bottle : bottles){
			
			if (bottle.votes > 0) {
				double percent = bottle.votes / totalVotes; //One bar in percent.
				int barHeight = (int) Math.floor((percent*(bottleHeight/2))-(10*scale)); //Box size in percent converted to box size relative to the max height.
				int bottomOfBottle = (int)((tableY+(50*scale))+bottleHeight);
				
				int barXActual = (int) (((bottleCount*spaceBetween)+xStart) + (15*scale));
				int barYActual = (int)(bottomOfBottle-barHeight-(30*scale));
				int barWActual = (int)(bottleWidth-(bottleWidth/8.0));
				
				g2A.setColor(bottle.color);
				g2A.fillRect((int) (((bottleCount*spaceBetween)+xStart) + (15*scale)), (int)(bottomOfBottle-barHeight-(30*scale)), (int)(bottleWidth-(bottleWidth/8.0)), barHeight);
				g2A.drawImage(liquidGradient, barXActual, barYActual, barWActual, barHeight, this);
			}
			
			//Draw bottle
			g2.drawImage(bottle.image, ((bottleCount*spaceBetween)+xStart), (int)(tableY+(50*scale)), bottleWidth, bottleHeight, this); //Draw bottle, aligned with the table.
			//Draw text
			g2.drawString(bottle.answer, (int) graphWidth, (int)((fontSize*1.5)*bottleCount)+tableY); //Answer, aligned by the biggest box
			bottleCount++;
		}
		//g2.dispose();
	}



	@Override
	public void updateData(FirebaseData data) {
		fbData = data;

		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();

		System.out.println("Vertical boxes, updateData(). Data received: " + fbData.getAnswers() + " " + fbData.getVotes());
		
		for(int i = bottles.size(); i<answers.size(); i++){
			if(Math.random() > 0.5) bottles.add(new Bottle(bottle1, colors.get(i)));
			else bottles.add(new Bottle(bottle2, colors.get(i)));
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
		Color color;

		Bottle(Image img, Color c){ this.image = img; this.color = c;}
		void update(int votes, String answer){ 
			this.votes = votes;
			this.answer = answer;

		}
	}
}
