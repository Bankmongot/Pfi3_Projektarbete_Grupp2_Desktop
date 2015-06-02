package se.mah.k3.Themes;

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
	
	JLabel myLabel;
	
	List<Flavors> flavors = new ArrayList<Flavors>();
	
	Font f1 = new Font("Roboto", Font.PLAIN, 36); // Answers
	Font f2 = new Font ("Roboto", Font.PLAIN, 36); // Question
	
	public IceCream(){
		
		setLayout(null);
		setPreferredSize(new Dimension(1920,1080));
		setMinimumSize(new Dimension(1920,1080));
		
		//Needed for ugly fix, displaying the graph instantly when a survey is started.
				myLabel = new JLabel("New label");
				myLabel.setBounds(161, 224, 207, 16);
				myLabel.setText("");
				add(myLabel);
				
				//Load the images declared above.
				cone = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/icecreamcone.png"));
				vanilla = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/vanilla.png"));
				pear = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/pear.png"));
				chocolate = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/icecreamcone.png"));
				strawberry = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/strawberry.png"));
				sun = Toolkit.getDefaultToolkit().getImage(IceCream.class.getResource("/resourcesforIceCream/sol.PNG"));
	
				flavors.add(new Flavors (pear, 400, 400) );
				flavors.add(new Flavors (vanilla, 400, 400));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension dim = this.getSize();
		windowWidth = dim.getWidth();
		windowHeight = dim.getHeight();
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Anti aliasing, mainly for text
		g2.setFont(f1);
		FontMetrics fm = g2.getFontMetrics(); //Needed to figure out size of the text
		int fontHeight = fm.getAscent(); //Height of font
		double biggestFlavor = 0.0; //Biggest Flavor needed to align text nicely
		double allFlavorsHeight = 0.0; //Total height of all the flavors, must be double: using it for division.
		int totalVotes = 0;
		
		//Add size of all boxes to allBoxesHeight and calc totalVotes
				for (Flavors flavor : flavors) {
					int votes = flavor.votes;
					allFlavorsHeight += votes;
					totalVotes += votes;
				}
				//Find the biggest box 
				for (Flavors flavor : flavors) {
					int flavorSize = flavor.votes;
					double tempPercent = flavorSize / allFlavorsHeight;
					double foo =  (int) Math.floor(tempPercent*graphHeight); 
					if (foo > biggestFlavor) biggestFlavor = foo;
				}
		for (Flavors flavor : flavors) {
			if(flavor.votes > 0) {
				int size= flavor.votes;
				double percent = size / totalVotes;
				size = (int) Math.floor(percent*300);
				g2.drawImage(pear, flavor.xPos, flavor.yPos, size, size, this);
			//	g2.drawString(flavor.answer, x, y);
				
			}
			
		}
		g2.setFont(f2); //Set the font for the title
		g2.drawString(fbData.getQuestion(), 50, 50);  //The title //TODO: Positioning
		
	}
	
	@Override
	public void updateData(FirebaseData data) {
		fbData = data;

		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();

		System.out.println("Ice Cream, updateData(). Data received: " + fbData.getAnswers() + " " + fbData.getVotes());

		for(int i = flavors.size(); i<answers.size(); i++){
			flavors.add(new Flavors(answers.get(i)));
			System.out.println("Added flavor");
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
		int xPos = 0;
		int yPos = 0;
		Image img;
		Flavors (String a) { this.answer = a; }
		
		Flavors (Image img, int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			this.img = img;
		}
		void update (int votes, String answer) {
			this.votes = votes;
			this.answer = answer;
			this.xPos =xPos;
			this.yPos = yPos;
			
			
		}
	}



}
