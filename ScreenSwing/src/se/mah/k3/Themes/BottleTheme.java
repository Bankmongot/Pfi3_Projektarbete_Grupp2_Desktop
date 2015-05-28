package se.mah.k3.Themes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;



  public class BottleTheme extends JPanel implements ThemeInterface {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FirebaseData fbData;
       JLabel myLabel;
       
       
       
       	public BottleTheme(){
       		
    	setBackground(Color.WHITE);
    	setLayout(null);
    	setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));

   
   //Färger 	
    	
   JLabel Blue = new JLabel("");
   Blue.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/blue.png")));
   Blue.setBounds(421, 397, 88, 50);
   add(Blue);
   
   JLabel Green = new JLabel("");
   Green.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/green.png")));
   Green.setBounds(127, 408, 97, 50);
   add(Green);
   
   JLabel Orange = new JLabel("");
   Orange.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/orange.png")));
   Orange.setBounds(553, 408, 88, 50);
   add(Orange);
   
   JLabel Red = new JLabel("");
   Red.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/red.png")));
   Red.setBounds(272, 452, 88, 50);
   add(Red);

   //Rubrik
   myLabel = new JLabel("New label");
   myLabel.setHorizontalAlignment(SwingConstants.CENTER);
   myLabel.setFont(new Font("Roboto", Font.BOLD, 45));
   myLabel.setBounds(-14, 45, 811, 84);
   myLabel.setText("The question will appear here!");
   add(myLabel);
   

   //Alternativ
   
   JLabel lblAlt = new JLabel("Alt 1");
   lblAlt.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt.setBounds(143, 499, 97, 14);
   add(lblAlt);
   
   JLabel lblAlt_1 = new JLabel("Alt 2");
   lblAlt_1.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_1.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_1.setBounds(279, 532, 97, 14);
   add(lblAlt_1);
   
   JLabel lblAlt_2 = new JLabel("Alt 3");
   lblAlt_2.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_2.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_2.setBounds(421, 479, 107, 14);
   add(lblAlt_2);
   
   JLabel lblAlt_3 = new JLabel("Alt 4");
   lblAlt_3.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_3.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_3.setBounds(553, 479, 107, 14);
   add(lblAlt_3);
   
   
   
   //Flaskor
   
   JLabel lblNewLabel = new JLabel("");
   lblNewLabel.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/Flaska1.png")));
   lblNewLabel.setBounds(133, 127, 107, 361);
   add(lblNewLabel);
   
   JLabel label = new JLabel("");
   label.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/flaska2.png")));
   label.setBounds(269, 225, 107, 296);
   add(label);
   
   JLabel label_1 = new JLabel("");
   label_1.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/Flaska1.png")));
   label_1.setBounds(421, 127, 107, 346);
   add(label_1);
   
   JLabel label_2 = new JLabel("");
   label_2.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/flaska2.png")));
   label_2.setBounds(552, 168, 107, 318);
   add(label_2);
   
       }
       

       
       
       
   @Override
public void updateData(FirebaseData data) {
   // TODO Auto-generated method stub
   fbData = data;
   myLabel.setText(fbData.getQuestion());
   repaint();
}
}