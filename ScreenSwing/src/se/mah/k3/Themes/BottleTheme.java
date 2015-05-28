package se.mah.k3.Themes;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import se.mah.k3.Themes.ThemeOfCircles.GraphOval;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;



  public class BottleTheme extends JPanel implements ThemeInterface {
       FirebaseData fbData;
       JLabel myLabel;
       
       
       
       public BottleTheme(){
    	   
  	setBackground(Color.WHITE);
  	setLayout(null);
   
   JLabel lblNewLabel_2 = new JLabel("");
   lblNewLabel_2.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/blue.png")));
   lblNewLabel_2.setBounds(22, 11, 436, 535);
   add(lblNewLabel_2);

   myLabel = new JLabel("New label");
   myLabel.setHorizontalAlignment(SwingConstants.CENTER);
   myLabel.setFont(new Font("Roboto", Font.BOLD, 45));
   myLabel.setBounds(-20, 20, 811, 84);
   myLabel.setText("The question will appear here!");
   add(myLabel);
   
   
   JLabel lblNewLabel = new JLabel("");
   lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
   lblNewLabel.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/Flaska1.png")));
   lblNewLabel.setBounds(133, 160, 107, 343);
   add(lblNewLabel);
   
   JLabel lblNewLabel_1 = new JLabel("");
   lblNewLabel_1.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/flaska2.png")));
   lblNewLabel_1.setBounds(279, 230, 113, 300);
   add(lblNewLabel_1);
   
   JLabel label = new JLabel("");
   label.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/Flaska1.png")));
   label.setBounds(421, 138, 107, 343);
   add(label);
   
   JLabel label_1 = new JLabel("");
   label_1.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/flaska2.png")));
   label_1.setBounds(552, 192, 107, 311);
   add(label_1);
   
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
   lblAlt_3.setBounds(552, 499, 107, 14);
   add(lblAlt_3);
   
       }
       

       
       
       
   @Override
public void updateData(FirebaseData data) {
   // TODO Auto-generated method stub
   fbData = data;
   myLabel.setText(fbData.getQuestion());
   repaint();
}
}