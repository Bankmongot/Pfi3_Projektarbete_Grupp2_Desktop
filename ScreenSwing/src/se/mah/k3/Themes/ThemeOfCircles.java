package se.mah.k3.Themes;



import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.util.ArrayList;

import java.util.List;



import javax.swing.JLabel;

import javax.swing.JPanel;



import se.mah.k3.FirebaseData;

import se.mah.k3.ThemeInterface;







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


		Ovals.add(new GraphOval(200, 50, Color.blue));

		Ovals.add(new GraphOval(200, 100, Color.orange));

		Ovals.add(new GraphOval(200, 130, Color.yellow));


		myLabel = new JLabel("New label");

		myLabel.setBounds(161, 224, 207, 16);

		myLabel.setText("The question will appear here!");

		add(myLabel);

	}



	@Override

	public void updateData(FirebaseData data) {

		// TODO Auto-generated method stub

		fbData = data;

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