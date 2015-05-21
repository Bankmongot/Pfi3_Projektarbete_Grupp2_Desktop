package se.mah.k3.Themes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.mah.k3.FirebaseData;
import se.mah.k3.ThemeInterface;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JComponent;
import javax.imageio.*;

public class IceCreamTheme extends JPanel implements ThemeInterface {
	
	FirebaseData fbData;

	
	
	
	public IceCreamTheme() {
		setLayout(null);
		setSize(300,300);
		
	}
		
	
	
	
	
	@Override
	public void updateData(FirebaseData data) {
		fbData = data;
		this.repaint();
	}
	protected void paintComponent(Graphics g) {
		 //g.setColor(getBackground());
		 g.drawImage(Toolkit.getDefaultToolkit().getImage(IceCreamTheme.class.getResource("/resourcesforIceCream/pear.png")), 10, 11, 50, 100, null);
        //g.fillRect(0, 0, getWidth(), getHeight());
		this.repaint();
	}

}
