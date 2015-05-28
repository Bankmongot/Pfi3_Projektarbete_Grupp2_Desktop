package se.mah.k3.Themes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.Color;

public class Havs extends JPanel implements ThemeInterface {

	private static final long serialVersionUID = -863144768452382589L;
	FirebaseData fbData;
	JLabel myLabel;

	public Havs(){
		
		
		setBackground(Color.BLACK);	

		setPreferredSize(new Dimension(1024,768));
		setMinimumSize(new Dimension(1024,768));
		setLayout(null);
//		
//		JPanel Panel = new JPanel(){
//			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);
//				g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/lighthouse_T.png")), 150, 400, 300, 300, null);
//				
//				
//				this.repaint();
//		
		myLabel = new JLabel("New label");
		myLabel.setBounds(66, 45, 207, 16);
		myLabel.setText("The question will appear here!");
		add(myLabel);


		JLabel sten = new JLabel("New label");
		sten.setIcon(new ImageIcon(Havs.class.getResource("/images/sten.png")));
		sten.setBounds(0, 590, 1495, 172);
		add(sten);

		JLabel vitv�g = new JLabel("");
		vitv�g.setIcon(new ImageIcon(Havs.class.getResource("/images/vitv\u00E5g.png")));
		vitv�g.setBounds(0, 493, 1495, 240);
		add(vitv�g);

		JLabel lbl�v�g = new JLabel("New label");
		lbl�v�g.setIcon(new ImageIcon(Havs.class.getResource("/images/lbl\u00E5.png")));
		lbl�v�g.setBounds(0, 397, 1495, 325);

		add(lbl�v�g);

		JLabel mbl�v�g = new JLabel("");
		mbl�v�g.setIcon(new ImageIcon(Havs.class.getResource("/images/v\u00E5g3.png")));
		mbl�v�g.setBounds(0, 414, 1495, 308);
		add(mbl�v�g);

		JLabel birdOne = new JLabel("");
		birdOne.setIcon(new ImageIcon(Havs.class.getResource("/images/f\u00E5gel-liten.png")));
		birdOne.setBounds(922, 45, 94, 102);
		add(birdOne);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Havs.class.getResource("/images/hav.png")));
		lblNewLabel.setBounds(0, 0, 1495, 733);
		add(lblNewLabel);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(731, 343, 6, 74);
		add(desktopPane);
		
		
	}

	@Override
	public void updateData(FirebaseData data) {
		// TODO Auto-generated method stub
		fbData = data;
		myLabel.setText(fbData.getQuestion());
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(StarTheme.class.getResource("/images/lighthouse_T.png")), 150, 400, 300, 300, null);
		
		
		this.repaint();	
	}
	
}
