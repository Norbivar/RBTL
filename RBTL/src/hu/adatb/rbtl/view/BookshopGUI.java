package hu.adatb.rbtl.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The main screen of the application.
 * @author Attila Uhrin
 *
 */
public class BookshopGUI extends JFrame implements ActionListener{

	private JMenuBar mb;
	
	private JMenu file_menu;
	private JMenuItem file_home, file_exit;
	
	private JMenu user_settings;
	private JMenuItem user_register, user_login;
	private JLabel screen_title, logo;
	
	public BookshopGUI() {
		super();
		setTitle(Labels.MAIN_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		//setResizable(false);
		
		/*----------------MENUBAR----------------*/
		mb = new JMenuBar();
		
		//FILE MENU
		file_menu = new JMenu(Labels.FILE_MENU);
		file_home = new JMenuItem(Labels.FILE_MENUITEM_HOME);
		file_exit = new JMenuItem(Labels.FILE_MENUITEM_EXIT);
		
		file_home.addActionListener(this);
		file_exit.addActionListener(this);
		
		file_menu.add(file_home);
		file_menu.add(file_exit);
		
		//USER SETTINGS MENU
		user_settings = new JMenu(Labels.USER_MENU);
		user_register = new JMenuItem(Labels.USER_MENUITEM_REGISTER);
		user_login = new JMenuItem(Labels.USER_MENUITEM_LOGIN);
		
		user_register.addActionListener(this);
		
		user_settings.add(user_register);
		user_settings.add(user_login);
		
		mb.add(file_menu);
		mb.add(user_settings);		
		
		setJMenuBar(mb);
		/*------------------------------------------------*/
		
		getContentPane().add(new WelcomeScreen());		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == file_home){				//If the user clicked on the 'Home' menu item
			getContentPane().removeAll();
			getContentPane().add(new WelcomeScreen());
			revalidate();
		} else if (e.getSource() == file_exit) {	//If the user clicked on the 'Exit' menu item
			System.exit(0);
		} else if(e.getSource() == user_register){ 	//If the user clicked on the 'Sign up' menu item
			getContentPane().removeAll();
			getContentPane().add(new UserSignUpScreen(getContentPane()));
			revalidate();
		}
	}

}
