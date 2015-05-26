package se.mah.k3;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;
import java.awt.Color;
import javax.swing.ImageIcon;

  public class BottleTheme extends JPanel implements ThemeInterface {
       FirebaseData fbData;
       JLabel myLabel;
       private final JPanel panel = new JPanel();
       panel.setBounds
  
       
       public BottleTheme(){
  	setBackground(Color.WHITE);
   setLayout(null);
           panel.setBounds(0, 0, 0, 0);
           add(panel);

           myLabel = new JLabel("New label");
   myLabel.setBounds(118, 26, 207, 16);
   myLabel.setText("The question will appear here!");
   add(myLabel);
   
   JLabel lblNewLabel = new JLabel("New label");
   lblNewLabel.setIcon(new ImageIcon(se.mah.k3.BottleTheme.class.getResource("/images/Flaska1.png")));
   lblNewLabel.setBounds(196, 172, 366, 197);
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