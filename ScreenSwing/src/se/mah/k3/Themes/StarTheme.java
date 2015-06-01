package se.mah.k3.Themes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.Constants;
import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import se.mah.k3.Themes.VerticalBoxes.GraphBox;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class StarTheme extends JPanel implements ThemeInterface {

	FirebaseData fbData;
	JLabel lblQuestionHere, lblAlt1, lblResult1;
	private JTextField txtQuestionHere;
	
	List<StarCreate> stars = new ArrayList<StarCreate>();
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	Image starImage;
	
	
	public StarTheme(){
		setBackground(new Color(0, 0, 51));
		setPreferredSize (new Dimension(1024, 768));
		setMinimumSize (new Dimension(1024, 768));
		System.out.println("Created StarPanel");
		setLayout(null);
		starImage = Toolkit.getDefaultToolkit().getImage(VerticalBoxes.class.getResource("/images/Star-1.png"));

		stars.add(new StarCreate((int) (width/8*1-150), 400));
		stars.add(new StarCreate((int) (width/8*2), 250));
		stars.add(new StarCreate((int) (width/8*3-200), 650));
		stars.add(new StarCreate((int) (width/8*4-200), 400));
		stars.add(new StarCreate((int) (width/8*5-200), 600));
		stars.add(new StarCreate((int) (width/8*6-200), 250));
		stars.add(new StarCreate((int) (width/8*7-200), 550));
		
		
		//JLabel lblQuestionHere = new JLabel(fbData.getQuestion());
		JLabel lblQuestionHere = new JLabel("Question?");
		lblQuestionHere.setBackground(new Color(0, 255, 0));
		lblQuestionHere.setFont(new Font("Roboto", Font.BOLD, 77));
		lblQuestionHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionHere.setForeground(Color.WHITE);
		lblQuestionHere.setBounds((int) (width/8*1-100), 35, 884, 91);
		add(lblQuestionHere);
		//lblQuestionHere.setText(fbData.getQuestion());		

		
		
		//JLabel lblAlt1 = new JLabel(fbData.getAlt1());
		JLabel lblAlt1 = new JLabel("Alt1");
		lblAlt1.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt1.setForeground(Color.WHITE);
		lblAlt1.setBounds((int) (width/8*1-100), 149, 100, 30);
		add(lblAlt1);
		
		//JLabel lblResult1 = new JLabel(String.valueOf(fbData.getVote1()));
		JLabel lblResult1 = new JLabel("Result1");
		lblResult1.setForeground(Color.WHITE);
		lblResult1.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult1.setBounds((int) (width/8*1-100), 177, 46, 14);
		add(lblResult1);
		
		JLabel lblAlt2 = new JLabel("Alt 2");
		lblAlt2.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt2.setForeground(Color.WHITE);
		lblAlt2.setBounds((int) (width/8*2-100), 149, 100, 30);
		add(lblAlt2);
		
		JLabel lblResult2 = new JLabel("Result 2");
		lblResult2.setForeground(Color.WHITE);
		lblResult2.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult2.setBounds((int) (width/8*2-100), 177, 46, 14);
		add(lblResult2);
		
		JLabel lblAlt3 = new JLabel("Alt 3");
		lblAlt3.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt3.setForeground(Color.WHITE);
		lblAlt3.setBounds((int) (width/8*3-100), 149, 100, 30);
		add(lblAlt3);
		
		JLabel lblResult3 = new JLabel("Result 3");
		lblResult3.setForeground(Color.WHITE);
		lblResult3.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult3.setBounds((int) (width/8*3-100), 177, 46, 14);
		add(lblResult3);
		
		JLabel lblAlt4 = new JLabel("Alt 4");
		lblAlt4.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt4.setForeground(Color.WHITE);
		lblAlt4.setBounds((int) (width/8*4-100), 149, 100, 30);
		add(lblAlt4);
		
		JLabel lblResult4 = new JLabel("Result 4");
		lblResult4.setForeground(Color.WHITE);
		lblResult4.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult4.setBounds((int) (width/8*4-100), 177, 46, 14);
		add(lblResult4);
		
		JLabel lblAlt5 = new JLabel("Alt 5");
		lblAlt5.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt5.setForeground(Color.WHITE);
		lblAlt5.setBounds((int) (width/8*5-100), 149, 100, 30);
		add(lblAlt5);
		
		JLabel lblResult5 = new JLabel("Result 5");
		lblResult5.setForeground(Color.WHITE);
		lblResult5.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult5.setBounds((int) (width/8*5-100), 177, 46, 14);
		add(lblResult5);
		
		JLabel lblAlt6 = new JLabel("Alt 6");
		lblAlt6.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt6.setForeground(Color.WHITE);
		lblAlt6.setBounds((int) (width/8*6-100), 149, 100, 30);
		add(lblAlt6);
		
		JLabel lblResult6 = new JLabel("Result 6");
		lblResult6.setForeground(Color.WHITE);
		lblResult6.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult6.setBounds((int) (width/8*6-100), 177, 46, 14);
		add(lblResult6);
		
		JLabel lblAlt7 = new JLabel("Alt 7");
		lblAlt7.setFont(new Font("Roboto", Font.BOLD, 30));
		lblAlt7.setForeground(Color.WHITE);
		lblAlt7.setBounds((int) (width/8*7-100), 149, 100, 30);
		add(lblAlt7);
		
		JLabel lblResult7 = new JLabel("Result 7");
		lblResult7.setForeground(Color.WHITE);
		lblResult7.setFont(new Font("Roboto", Font.BOLD, 15));
		lblResult7.setBounds((int) (width/8*7-100), 177, 46, 14);
		add(lblResult7);
	}
	
	protected void paintComponent(Graphics g) {
		 //g.setColor(getBackground()); // x , y , w, h , let stay null
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //Create the graphics2D object we'll use for drawing

		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/NightSkyBackground.png")), 0,0, (int) width, (int) height, null);
		/* g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-1.png")), (int) (width/8*1-150), 400, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-2.png")), (int) (width/8*2), 250, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-3.png")), (int) (width/8*3-200), 650, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-4.png")), (int) (width/8*4-200), 400, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-5.png")), (int) (width/8*5-200), 600, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-6.png")), (int) (width/8*6-200), 250, 300, 300, null);
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/Star-7.png")), (int) (width/8*7-200), 550, 300, 300, null);*/
		 
		 int totalVotes = 0;
		 
			for (StarCreate star : stars) {
				int votes = star.votes;
				totalVotes += votes;
			}
		 
		 for (StarCreate star : stars) {
				if (star.votes > 0){
					int size = star.votes; //Box size.
					double percent = size / totalVotes; //One box in percent.
					size = (int) Math.floor(percent*300); //Box size in percent converted to box size relative to the max height.

					g2.drawImage(starImage, star.xPos, star.yPos, size, size, this); //Draw box, centered on xAlign with the bottom as origin for the y coordinate.
					/*g2.drawString(box.answer, (int)(xAlign + (biggestBox/2)) + 50 , (nextY-(size/2)+(fontHeight/2))-5); // Answer, aligned by the biggest box
					g2.drawString((int)Math.floor(percent*100)+"%", (int)((xAlign - (biggestBox/2)) - (barOffset - 40)), (nextY-(size/2)+(fontHeight/2))-5); //Votes in %, -||-*/

					}
			}
		 
      //g.fillRect(0, 0, getWidth(), getHeight());
		this.repaint();
	}
	
	
	
	@Override
	public void updateData(FirebaseData data) {
		fbData = data;
		lblQuestionHere.setText(fbData.getQuestion());
		
		ArrayList<String> answers = fbData.getAnswers();
		ArrayList<Integer> votes = fbData.getVotes();
		
		//Add data to boxes
		System.out.println("Boxes"+ stars.size());
		System.out.println("Answers"+ answers.size());
		System.out.println("Votes"+ votes.size());

		for(int i = 0; i<answers.size(); i++){
			stars.get(i).update((int) (votes.get(i)), answers.get(i));
			System.out.println("Updated box");
		}

		
		repaint();
	} 
	
	class StarCreate{
		int votes = 0;
		String answer;
		int xPos;
		int yPos;

		StarCreate(int x, int y)
		{ 
			this.xPos = x;
			this.yPos = y;
		}
		void update(int votes, String answer){ 
			this.votes = votes;
			this.answer = answer;

		}


		}

}
