package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3.Themes.CircleTheme;
import se.mah.k3.Themes.DummyTheme;
import se.mah.k3.Themes.Havs;
import se.mah.k3.Themes.StarTheme;
import se.mah.k3.Themes.VerticalBoxes;

import com.firebase.client.Firebase;

import java.awt.event.KeyEvent;

public class FullScreen extends JFrame implements KeyEventDispatcher{
	
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private boolean inFullScreenMode = false;
	private int PrevX = 100 ,PrevY = 100 ,PrevWidth = 480,PrevHeight = 640;
	//private static ThemeInterface tInter;
	private FireBase fb;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullScreen frame = new FullScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static ThemeInterface setUpTheme(String theme){
		JPanel panel;
		switch(theme){
		case "Circles":
			//Empty all old crap
			contentPane.removeAll();
			panel = new CircleTheme();
			contentPane.add(panel, BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate(); //This seems to be needed to really repaint a component with graphical objects strange....
			break;
		case "Stars":
			//Empty all old crap
			contentPane.removeAll();
			panel = new StarTheme();
			contentPane.add(panel, BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate(); //This seems to be needed to really repaint a component with graphical objects strange....
			break;
		case "VerticalBoxes":
			//Empty all old crap
			contentPane.removeAll();
			panel = new VerticalBoxes();
			contentPane.add(panel, BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate(); //This seems to be needed to really repaint a component with graphical objects strange....
			break;
		case "Havs":
			//Empty all old crap
			contentPane.removeAll();
			panel = new Havs();
			contentPane.add(panel, BorderLayout.CENTER);
			contentPane.repaint();
			contentPane.revalidate(); //This seems to be needed to really repaint a component with graphical objects strange....
			break;
		default:
			//Empty all old crap
			contentPane.removeAll();
			panel = new VerticalBoxes();
			contentPane.add(panel, BorderLayout.CENTER);
			contentPane.repaint();
			break;
		}
		return (ThemeInterface) panel;
	}
	
	public FullScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//Show DrawPanel as a start or screensaver
//		JPanel panel = new DummyPanel();
//		contentPane.add(panel, BorderLayout.CENTER);
		fb = new FireBase();

		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager(); //Listen to keyboard
	    manager.addKeyEventDispatcher(this);
		setFullscreen(true);
	}
	
	public void setFullscreen(boolean fullscreen) {
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     GraphicsDevice[] gd = ge.getScreenDevices();    
			 if(fullscreen){
				PrevX = getX();
				PrevY = getY();
				PrevWidth = getWidth();
				PrevHeight = getHeight();
				dispose(); 
				//Always on last screen!
				setUndecorated(true);
				gd[gd.length-1].setFullScreenWindow(this);
				setVisible(true);
				this.inFullScreenMode = true;
			}
			else{
				setVisible(true);
				setBounds(PrevX, PrevY, PrevWidth, PrevHeight);
				dispose();
				setUndecorated(false);
				setVisible(true);
				this.inFullScreenMode = false;
			}
   }


	//Toggle fullscreen with f
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
       if (e.getID() == KeyEvent.KEY_TYPED) {
       	 if(e.getKeyChar()=='f'){     		 
             	setFullscreen(!inFullScreenMode);	
     		}
        }
        return false;
	}
}
