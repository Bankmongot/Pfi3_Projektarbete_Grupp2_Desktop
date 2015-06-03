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
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;


public class IceCream extends JPanel implements ThemeInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirebaseData fbData;
	double windowWidth;
	double windowHeight;
	int graphHeight = 0;
	
	
	
	// Declare images within the theme.
	Image chocolate;
	Image vanilla;
	Image strawberry;
	Image cone;
	Image pear;
	Image sun;
	Image icbg;
	
	JLabel myLabel;
	
	List<Flavors> flavors = new ArrayList<Flavors>();
	List<FlavorThumbs> flavorThumb = new ArrayList<FlavorThumbs>();
	List<Image> images = new ArrayList<Image>();
	List<Integer> yCord = new ArrayList<Integer>();
	List<Integer> thumbYpos = new ArrayList <Integer>();
	List<flavorAnswers> flavoranswr = new ArrayList<flavorAnswers>();
	
	List <Integer> xCord = new ArrayList<Integer>();
	
	Font f1 = new Font("Roboto", Font.PLAIN, 45); // Answers
	Font f2 = new Font ("Roboto", Font.PLAIN, 72); // Question
	
	
	
	public IceCream(){
		
		
		setLayout(null);
		setPreferredSize(new Dimension(1920,1080));
		setMinimumSize(new Dimension(1920,1080));
		
		//Needed for ugly fix, displaying the graph instantly when a survey is started.
				myLabel = new JLabel("New label");
				myLabel.setBounds(161, 224, 207, 16);
				myLabel.setText("");
				add(myLabel);
				
				
				// Add X-Coordinates to match the image arrayList.
				xCord.add(320);
				xCord.add(440);
				xCord.add(560);
				xCord.add(680);
				
				
				// Add Y-Coordinates to match the image arrayList.
				yCord.add(660);
				yCord.add(530);
				yCord.add(650);
				yCord.add(680);
				
				thumbYpos.add(200);
				thumbYpos.add(280);
				thumbYpos.add(360);
				thumbYpos.add(440);
				
				//Load the images declared above.
				images.add(Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/vanilla.png")));
		        images.add(Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/pear.png")));        
		        images.add(Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/strawberry.png")));
		        images.add(Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/chocolate.png")));
		        
				
				sun = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/sol.PNG"));
				icbg = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/realicbg.PNG"));
				cone = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/icecreamcone.png"));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Ice Cream
		Dimension dim = this.getSize();
		windowWidth = dim.getWidth();
		windowHeight = dim.getHeight();
		int numOfFlavors= 0;
		double totalVotes =0;
		
		for (Flavors flavor : flavors) {
			int votes = flavor.votes;
			totalVotes += votes;
			numOfFlavors++;
		}
		// ICe cream
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Anti aliasing, mainly for text
		g2.setFont(f1);
		
		FontMetrics fm = g2.getFontMetrics(); //Needed to figure out size of the text
		
		double scale = (windowWidth / 1280);
		
		int flavorHeight = (int)(300*scale);
		
		//Draw background
		g2.drawImage(icbg, 0, 0, (int) windowWidth, (int) windowHeight, this);
	
		g2.drawImage(cone,640-312, 847, 623, 213, this); 	// Draw the cone
		
		//Drawing loop.
		int flavorCount = 0;
		for (Flavors flavor : flavors){
			if (flavor.votes > 0) {
				double percent = flavor.votes / totalVotes; //One bar in percent.
				int flavorSize = (int) Math.floor((percent*(flavorHeight/2))-(10*scale)); //Box size in percent converted to box size relative to the max height.
				
				g2.drawImage(flavor.img, flavor.xPos, flavor.yPos, (int)(flavorSize-(30*scale)+300), (int)(flavorSize-(30*scale)+300), this); //Draw box, centered on xAlign with the bottom as origin for the y coordinate.
				
		
			}
			flavorCount++;
		}
		
		for (FlavorThumbs flavorThumbs : flavorThumb) {
			g2.drawImage(flavorThumbs.img, 50, flavorThumbs.yPosi, 50, 50, this);
			
		
		}
		
		for(flavorAnswers flavorAnswers : flavoranswr) {
			g2.setFont(f1);
			g2.drawString(flavorAnswers.answers , 110, flavorAnswers.yPosi+30);
			
		}
				
				g2.setFont(f2); //Set the font for the title
				//g2.setColor(Color.WHITE);
				g2.drawString(fbData.getQuestion(), 50, 90);  //The title //TODO: Positioning
				g2.drawString( String.valueOf(totalVotes)+ " Votes", 50, 980); 

				
				
			
				
				
			
			
		}
	
	
	
	@Override
	public void updateData(FirebaseData data) {
		fbData = data;

		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();

		System.out.println("Ice Cream, updateData(). Data received: " + fbData.getAnswers() + " " + fbData.getVotes());

		for(int i = flavors.size(); i<answers.size(); i++){
			flavors.add(new Flavors(images.get(i),xCord.get(i), yCord.get(i)));
			
			flavorThumb.add(new FlavorThumbs(images.get(i), 50, thumbYpos.get(i)));
			flavoranswr.add(new flavorAnswers(answers.get(i), 50, thumbYpos.get(i)));
		
			System.out.println("Added box");
		}
		

		//Add data to boxes
		System.out.println("Boxes"+ flavors.size());
		System.out.println("Answers"+ answers.size());
		System.out.println("Votes"+ votes.size());

		for(int i = 0; i<answers.size(); i++){
			flavors.get(i).update((int) (votes.get(i)), answers.get(i));
			System.out.println("Updated box");
		}

		//Ugly fix to automatically show the theme when it's launched.
		myLabel.setText( fbData.getQuestion() );
		myLabel.setText("");

		repaint();
	}
	
	
	
	// Class for ice-cream arrayList.
	class Flavors {
		int votes = 0;
		String answer;
		Image img;
		int xPos;
		int yPos;
	
		
		Flavors (Image img, int xPos, int yPos) {
			this.img = img;
			this.xPos = xPos;
			this.yPos = yPos;
		}
		void update (int votes, String answer) {
			this.votes = votes;
			this.answer = answer;
		
			
			
		}
	}
	
	class FlavorThumbs {
		Image img;
		int xPos;
		int yPosi;
		 
		FlavorThumbs (Image img, int xPos, int yPosi) {
			this.img = img;
			this.xPos = xPos;
			this.yPosi = yPosi;
		}
		
	}
	
	class flavorAnswers {
		int xPos;
		int yPosi;
		String answers;
	
		
		flavorAnswers (String answers, int xPos, int yPosi) {
	
			this.answers = answers;
			this.xPos = xPos;
			this.yPosi = yPosi;
		}
	}

	}
