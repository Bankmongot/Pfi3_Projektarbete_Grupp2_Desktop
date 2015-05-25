package se.mah.k3.Themes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.Helpers;
import se.mah.k3.ThemeInterface;





import javax.swing.JLabel;
import javax.swing.JPanel;





import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import se.mah.k3.Themes.VerticalBoxes.GraphBox;

    public class ThemeOfCircles extends JPanel implements ThemeInterface {
    FirebaseData fbData;
    JLabel myLabel;

   
    private int frame = 0;
    Font font = new Font("Avenir next", Font.BOLD, 40);



	private static final long serialVersionUID =2L;
    
	GraphOval Oval;
	List<GraphOval> Ovals = new ArrayList<GraphOval>();

     public ThemeOfCircles(){
    //temp
   //-/temp
  //percent = Helpers.calcPercent(fbData.getInData());
        setLayout(null);
        setPreferredSize(new Dimension(1080,560));
        setMinimumSize(new Dimension(1080,560));

        Ovals.add(new GraphOval(200, 50, Color.red));
        Ovals.add(new GraphOval(200, 100, Color.green));
        Ovals.add(new GraphOval(200, 130, Color.blue));


		myLabel = new JLabel("New label");
        myLabel.setBounds(161, 224, 207, 16);
        myLabel.setText("The question will appear here!");
        add(myLabel);

	}
     
     
     public void paint(Graphics g) {
 		super.paintComponent(g);
 		
 		g.drawString(fbData.getQuestion(), 100, 30);
 		//g.drawString(String.valueOf(fbData.getVote1()), 25, 35);
 		
 		int y = 50;
 		for (GraphOval oval : Ovals) {
 			g.setColor(oval.color);
 			g.fillRect(oval.xPos, y, oval.size, oval.size);
 			y += oval.size;
 			oval.yPos = y;
 		}
     }

       public void updateData(FirebaseData data) {

		// TODO Auto-generated method stub
    	fbData = data;
    	
    	Ovals.get(0).setSize((int) (50 + fbData.getVote1()*2));
		Ovals.get(1).setSize((int) (50 + fbData.getVote2()*2));
		Ovals.get(2).setSize((int) (50 + fbData.getVote3()*2));
    	
    	myLabel.setText(fbData.getQuestion()); 
    	repaint();

	  }

       class GraphOval{

		//xPos is centered, yPos is on the top 
    	   int size;
    	   int xPos;
    	   int yPos;
    	   Color color;

           GraphOval(int size, int yPos, Color color){
           this.size = size;
           int xAlign;
           //this.xPos = xAlign - (size/2);
           this.yPos = yPos;
           this.color = color;

		}
           void setSize(int size){
           this.size = size;
           int xAlign;
           //xPos = xAlign - (size/2);

		}


	}

}