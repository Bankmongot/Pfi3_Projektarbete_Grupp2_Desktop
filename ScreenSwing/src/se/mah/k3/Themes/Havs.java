package se.mah.k3.Themes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import javax.swing.ImageIcon;

public class Havs extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -863144768452382589L;
	FirebaseData fbData;
	JLabel myLabel;

	public Havs(){	
		
		setPreferredSize(new Dimension(1080,560));
		setMinimumSize(new Dimension(1080,560));
		setLayout(null);

		myLabel = new JLabel("New label");
		myLabel.setBounds(66, 45, 207, 16);
		myLabel.setText("The question will appear here!");
		add(myLabel);
		
		JLabel sten = new JLabel("New label");
		sten.setIcon(new ImageIcon(Havs.class.getResource("/images/sten.png")));
		sten.setBounds(0, -366, 1438, 926);
		add(sten);
		///havs tema
		
		JLabel våg1 = new JLabel("New label");
		våg1.setIcon(new ImageIcon(Havs.class.getResource("/images/v\u00E5g1.png")));
		våg1.setBounds(0, 327, 1080, 233);
		add(våg1);
		
		JLabel våg2 = new JLabel("New label");
		våg2.setIcon(new ImageIcon(Havs.class.getResource("/images/v\u00E5g2.png")));
		våg2.setBounds(0, 187, 1080, 373);
		add(våg2);
		
		JLabel våg3 = new JLabel("New label");
		våg3.setIcon(new ImageIcon(Havs.class.getResource("/images/v\u00E5g3.png")));
		våg3.setBounds(0, 215, 1080, 345);
		add(våg3);
		
		JLabel birdOne = new JLabel("");
		birdOne.setIcon(new ImageIcon(Havs.class.getResource("/images/f\u00E5gel-liten.png")));
		birdOne.setBounds(922, 45, 94, 102);
		add(birdOne);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Havs.class.getResource("/images/hav.png")));
		lblNewLabel.setBounds(-42, -163, 1122, 723);
		add(lblNewLabel);
	}

	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/lighthouse_T.png")), 0, 300, 300, 300, null);
      
		this.repaint();
	}
}
