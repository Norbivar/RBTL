package hu.adatb.rbtl.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The panel what we display as the welcome screen
 * @author Attila Uhrin
 *
 */
public class WelcomeScreen extends JPanel {

	private JLabel screen_title, logo;
	
	/**
	 * {@link WelcomeScreen} default constructor
	 */
	public WelcomeScreen(){
		super();
		setLayout(new BorderLayout());
		
		screen_title = new JLabel(Labels.MAIN_WELCOME, SwingConstants.CENTER);
		add(screen_title, BorderLayout.NORTH);
		
		logo = new JLabel(new ImageIcon(this.getClass().getResource("/images/Genealogy-Logo.png")));
		add(logo, BorderLayout.CENTER);
		
		//TODO * A legújabb könyvek megjelenítése a kezdõ oldalon
	}
	
}
