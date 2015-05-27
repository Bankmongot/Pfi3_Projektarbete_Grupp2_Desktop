package se.mah.k3.Themes;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import java.awt.Color;
import javax.swing.ImageIcon;



  public class BottleTheme extends JPanel implements ThemeInterface {
       FirebaseData fbData;
       JLabel myLabel;
       
       
       
       public BottleTheme(){
    	   
  	setBackground(Color.GREEN);
  	setLayout(null);

   myLabel = new JLabel("New label");
   myLabel.setBounds(128, 30, 207, 16);
   myLabel.setText("The question will appear here!");
   add(myLabel);
   
   JLabel lblNewLabel = new JLabel("New label");
   lblNewLabel.setIcon(new ImageIcon(BottleTheme.class.getResource("/images/Flaska1.png")));
   lblNewLabel.setBounds(4, 11, 331, 343);
   add(lblNewLabel);
   }

       
       
   @Override
public void updateData(FirebaseData data) {
   // TODO Auto-generated method stub
   fbData = data;
   myLabel.setText(fbData.getQuestion());
   repaint();
}
}