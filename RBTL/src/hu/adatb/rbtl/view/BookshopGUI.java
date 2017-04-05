package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Az alkalmazás fõ ablakának felülete
 * @author Attila
 *
 */
public class BookshopGUI extends JFrame implements ActionListener{

	private JMenuBar mb;
	private JMenu user_settings;
	private JMenuItem user_register, user_login;
	
	public BookshopGUI() {
		super();
		setTitle(Labels.MAIN_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		setSize(600, 400);
		//setResizable(false);
		
		mb = new JMenuBar();
		user_settings = new JMenu(Labels.USER_MENU);
		user_register = new JMenuItem(Labels.USER_MENUITEM_REGISTER);
		user_login = new JMenuItem(Labels.USER_MENUITEM_LOGIN);
		
		user_register.addActionListener(this);
		
		user_settings.add(user_register);
		user_settings.add(user_login);
		
		mb.add(user_settings);
		setJMenuBar(mb);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == Labels.USER_MENUITEM_REGISTER){
			System.out.println("signup");
			//TODO implement sign up interface
		}
		
	}

}
