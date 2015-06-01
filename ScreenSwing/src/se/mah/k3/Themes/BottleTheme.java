package se.mah.k3.Themes;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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


   //Rubrik
   myLabel = new JLabel("New label");
   myLabel.setHorizontalAlignment(SwingConstants.CENTER);
   myLabel.setFont(new Font("Roboto", Font.BOLD, 50));
   myLabel.setBounds(0, 24, 1070, 106);
   myLabel.setText("The question will appear here!");
   add(myLabel);
   

   //Alternativ
   
   JLabel lblAlt = new JLabel("Alt 1");
   lblAlt.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt.setBounds(227, 469, 97, 14);
   add(lblAlt);
   
   JLabel lblAlt_1 = new JLabel("Alt 2");
   lblAlt_1.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_1.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_1.setBounds(417, 469, 97, 14);
   add(lblAlt_1);
   
   JLabel lblAlt_2 = new JLabel("Alt 3");
   lblAlt_2.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_2.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_2.setBounds(576, 511, 107, 14);
   add(lblAlt_2);
   
   JLabel lblAlt_3 = new JLabel("Alt 4");
   lblAlt_3.setFont(new Font("Roboto Bk", Font.PLAIN, 15));
   lblAlt_3.setHorizontalAlignment(SwingConstants.CENTER);
   lblAlt_3.setBounds(781, 478, 107, 14);
   add(lblAlt_3);
   
       }
       	
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		
    	
    		
    	}
       


		@Override
		public void updateData(FirebaseData data) {
			   fbData = data;
			   myLabel.setText(fbData.getQuestion());
			   repaint();
			}
		}
  