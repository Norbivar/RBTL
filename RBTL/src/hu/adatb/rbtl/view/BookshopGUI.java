package hu.adatb.rbtl.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import hu.adatb.rbtl.controller.BookshopController;
import hu.adatb.rbtl.view.dialogs.UserLoginDialog;
import hu.adatb.rbtl.view.dialogs.UserSignUpDialog;

/**
 * The main screen of the application.
 * @author Attila Uhrin
 *
 */
public class BookshopGUI extends JFrame implements ActionListener{

	private BookshopController controller;
	
	private JMenuBar mb;
	
	private JMenu file_menu;
	private JMenuItem file_home, file_exit;
	
	private JMenu user_settings;
	private JMenuItem user_register, user_login, user_logout, user_editprofile;
	
	private JMenu products;
	private JMenuItem search_products, product_toplist;
	
	public BookshopGUI(BookshopController controller) {
		super();
		this.controller = controller;
		setTitle(Labels.MAIN_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);	//Place the jframe at the center of the screen
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
		file_menu.addSeparator();
		file_menu.add(file_exit);
		
		//USER SETTINGS MENU
		user_settings = new JMenu(Labels.USER_MENU);
		user_register = new JMenuItem(Labels.USER_MENUITEM_REGISTER);
		user_login = new JMenuItem(Labels.USER_MENUITEM_LOGIN);
		user_logout = new JMenuItem(Labels.USER_MENUITEM_SIGNOUT);
		user_editprofile = new JMenuItem(Labels.USER_MENUITEM_EDITPROFILE);
		
		user_register.addActionListener(this);
		user_login.addActionListener(this);
		user_logout.addActionListener(this);
		user_editprofile.addActionListener(this);
		
		user_settings.add(user_register);
		user_settings.add(user_login);
		user_settings.add(user_editprofile);
		user_settings.addSeparator();
		user_settings.add(user_logout);
		
		//PRODUCTS MENU
		products = new JMenu(Labels.PRODUCTS_MENU);
		search_products = new JMenuItem(Labels.PRODUCTS_MENUITEM_SEARCH);
		product_toplist = new JMenuItem(Labels.PRODUCTS_MENUITEM_TOPLIST);
		
		search_products.addActionListener(this);
		product_toplist.addActionListener(this);
		
		products.add(search_products);
		products.add(product_toplist);
		
		mb.add(file_menu);
		mb.add(user_settings);
		mb.add(products);
		
		setJMenuBar(mb);
		
		/*------------------------------------------------*/
		
		
		getContentPane().add(new WelcomeScreen());		
		setVisible(true);
	}
	
	public BookshopController getController(){
		return this.controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == file_home){					//If the user clicked on the 'Home' menu item
			getContentPane().removeAll();
			getContentPane().add(new WelcomeScreen());
			revalidate();
		} else if (e.getSource() == file_exit) {		//If the user clicked on the 'Exit' menu item
			System.exit(0);
		} else if (e.getSource() == user_register){ 	//If the user clicked on the 'Sign up' menu item
			new UserSignUpDialog(this);
		} else if (e.getSource() == user_login){		//If the user clicked on the 'Log in' menu item
			if(controller.isLoggedin()){
				JOptionPane.showMessageDialog(this, 
						Labels.USER_ALREADY_LOGGED_IN, 
						Labels.USER_LOGIN_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				new UserLoginDialog(this);
			}			
		} else if (e.getSource() == user_logout){		//If the user clicked on the 'Sign out' menu item
			if (!controller.isLoggedin()){
				JOptionPane.showMessageDialog(this, 
						Labels.USER_SIGNOUT_ERROR, 
						Labels.USER_SIGNOUT_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				controller.setLoggedin(false);
				JOptionPane.showMessageDialog(this, 
						Labels.USER_SIGNOUT_SUCCESSFUL, 
						Labels.USER_SIGNOUT_TITLE, 
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == user_editprofile){	//If the user clicked on the 'Edit profile' menu item
			//TODO implement editing personal profile
		} else if (e.getSource() == search_products){	//If the user clicked on the 'Search products' menu item
			getContentPane().removeAll();
			getContentPane().add(new ProductSearchScreen(this));
			revalidate();
			//TODO implement browsing products
		} else if (e.getSource() == product_toplist){	//If the user clicked on the 'Product toplists' menu item
			//TODO implement product toplists
		}
	}

}
