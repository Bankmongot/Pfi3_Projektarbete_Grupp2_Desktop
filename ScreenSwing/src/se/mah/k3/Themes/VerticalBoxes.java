package se.mah.k3.Themes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		//Denna metoden beh�ver st�das


		Graphics2D g2 = (Graphics2D)g; //Skapa grafikobjekt
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Roboto", Font.PLAIN, 36);
		g2.setFont(font);
		FontMetrics fm = g2.getFontMetrics();
		int fontHeight = fm.getAscent();
		int biggestBox = 0; //Biggest box needed to align text nicely
		
		
		int numOfBoxes = boxes.size(); //Antal boxar
		double allBoxesHeight = 0.0;   //Initsiera variablen f�r alla boxars h�jd. M�ste vara en double.

		//R�kna ihop h�jden, hitta st�rsta boxens storlek
		for (GraphBox box : boxes) {
			int temp = (box.size + box.grow + box.votes);
			allBoxesHeight += temp;
			if (temp > biggestBox) biggestBox = temp;
		}
		
		int nextY = yFloor; //Startpositionen f�r boxar, nerifr�n
		
		//Loopa igenom alla boxar
		for (GraphBox box : boxes) {
			int sizeT = box.size + box.grow + box.votes; //R�kna ihop den totala storleken av en box.
			
			//Om boxarnas h�jd tillsamman �r �ver den till�tna storleken, r�kna om boxarnsas induviduella storlek till procent.
			if(allBoxesHeight > graphHeight){
				double percent = sizeT / allBoxesHeight; //One box in percent.
				sizeT = (int) Math.floor(percent*graphHeight); //Box size in percent converted to box size relative to the max height.
			}
			
			g2.setColor(box.color); //St�ll in boxens f�rg.
			g2.fillRect(xAlign - (sizeT/2), nextY-sizeT, sizeT, sizeT); //Rita ut boxen centrerat i x-led, med botten som utg�ngspunkt i y-led.
			g2.drawString(box.awnser, (xAlign + (biggestBox/2) + 20), nextY-(sizeT/2)+(fontHeight/2)); //TODO: Svarsalternativen och antal r�ster
			
			nextY -= (sizeT); //Ta bort boxens storlek fr�n y v�rdet s� att n�sta box hamnar ovan p�.
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
		String awnser = "Placeholder awnswer.";

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