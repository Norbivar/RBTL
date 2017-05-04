package hu.adatb.rbtl.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hu.adatb.rbtl.controller.BookshopController;
import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
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
	private JMenuItem search_products, product_toplist, cheap_products, popular_books;
	
	private JMenu shops;
	private JMenuItem every_book_in_a_shop, book_in_which_shop;
	
	private JMenu cart;
	private JMenuItem show_cart, cart_checkout;
	
	
	public BookshopGUI(BookshopController controller) {
		super();
		this.controller = controller;
		setTitle(Labels.MAIN_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);	//Place the jframe at the center of the screen
		setResizable(false);
		
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
		cheap_products = new JMenuItem(Labels.PRODUCTS_MENUITEM_CHEAP);
		popular_books = new JMenuItem(Labels.PRODUCTS_POPULAR_BOOKS);
		
		search_products.addActionListener(this);
		product_toplist.addActionListener(this);
		cheap_products.addActionListener(this);
		popular_books.addActionListener(this);
		
		products.add(search_products);
		products.add(product_toplist);
		products.add(cheap_products);
		
		//SHOPS MENU
		shops = new JMenu(Labels.SHOP_MENU);
		every_book_in_a_shop = new JMenuItem(Labels.SHOP_MENUITEM_BROWSE);
		book_in_which_shop = new JMenuItem(Labels.SHOP_MENUITEMS_SEARCH);
		
		every_book_in_a_shop.addActionListener(this);
		book_in_which_shop.addActionListener(this);
		
		shops.add(every_book_in_a_shop);
		shops.add(book_in_which_shop);
		
		//CART MENU
		cart = new JMenu(Labels.CART_MENU);
		show_cart = new JMenuItem(Labels.SHOW_CART_MENUITEM);
		cart_checkout = new JMenuItem(Labels.CART_CHECKOUT_MENUITEM);
		
		show_cart.addActionListener(this);
		cart_checkout.addActionListener(this);
		
		cart.add(show_cart);
		cart.add(cart_checkout);
		
		
		/* ----------- */
		mb.add(file_menu);
		mb.add(user_settings);
		mb.add(products);
		mb.add(shops);
		mb.add(cart);
		
		setJMenuBar(mb);
		/*------------------------------------------------*/
		
		getContentPane().add(new WelcomeScreen());		
		setVisible(true);
	}
	
	public BookshopController getController(){
		return this.controller;
	}
	
	public JPanel displayProductInList(Product product){
	
		if(product instanceof Book){
			JPanel ret, icon_panel, labels_panel, values_panel, button_panel;
			
			JLabel book_icon, label_title, label_author, label_publisher, label_price, label_publishYear;
			JLabel title, author, publisher, price, publishYear;
			
			ret = new JPanel();
			ret.setLayout(new FlowLayout());
			
			/* -----------------BOOK ICON PANEL-------------  */
			icon_panel = new JPanel();
			book_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/book_icon_smaller.png")));
			icon_panel.add(book_icon);
			/* ---------------------------------------------- */
			
			/* ------------BOOK LABELS PANEL --------------- */
			labels_panel = new JPanel();
			labels_panel.setLayout(new GridLayout(4, 1));
			
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			label_author = new JLabel(Labels.PRODUCT_RESULT_AUTHOR);
			label_publisher = new JLabel(Labels.PRODUCT_RESULT_PUBLISHER);
			label_price = new JLabel(Labels.PRODUCT_RESULT_PRICE);
			
			labels_panel.add(label_title);		
			labels_panel.add(label_author);		
			labels_panel.add(label_publisher);		
			labels_panel.add(label_price);
			/* -------------------------------------------------- */
			
			/* ---------------------------- VALUES PANEL -------------------- */
			values_panel = new JPanel();
			values_panel.setLayout(new GridLayout(4, 1));
			
			title = new JLabel(((Book) product).getTitle());
			author = new JLabel(((Book) product).getAuthor());
			publisher = new JLabel(((Book) product).getPublisher());
			price = new JLabel(String.valueOf(((Book) product).getPrice()));
			
			values_panel.add(title);
			values_panel.add(author);
			values_panel.add(publisher);
			values_panel.add(price);		
			/* ----------------------------------------------------- */
			
			/* --------------- BUTTON PANEL -------------------*/
			button_panel = new JPanel();
			button_panel.setLayout(new GridLayout(3, 1));
			
			ProductDetailsButton detailsButton;
			detailsButton = new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON);
			detailsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add(new ProductDetailScreen(BookshopGUI.this, detailsButton.getProduct()));
					revalidate();
				}
			});
			detailsButton.setProduct(product);
			
			
			button_panel.add(new JLabel());	//ï¿½res hely az elsï¿½ sorban
			button_panel.add(detailsButton);
			/* ------------------------------------------------ */
			
			ret.add(icon_panel);
			ret.add(labels_panel);
			ret.add(values_panel);
			ret.add(button_panel);
			
			return ret;
		} else if (product instanceof Film){
			JPanel p;
			JLabel film_icon, label_title, title;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			film_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/film_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Film) product).getTitle());


			ProductDetailsButton detailsButton;
			detailsButton = new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON);
			detailsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add(new ProductDetailScreen(BookshopGUI.this, detailsButton.getProduct()));
					revalidate();
				}
			});
			detailsButton.setProduct(product);
			
						
			p.add(film_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		} else if (product instanceof Song){
			JPanel p;
			JLabel song_icon, label_title, title;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			song_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/song_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Song) product).getTitle());
			
			ProductDetailsButton detailsButton;
			detailsButton = new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON);
			detailsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add(new ProductDetailScreen(BookshopGUI.this, detailsButton.getProduct()));
					revalidate();
				}
			});
			detailsButton.setProduct(product);

			
			p.add(song_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		} else {	//ebook
			JPanel p;
			JLabel ebook_icon, label_title, title;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			ebook_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/ebook_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Ebook) product).getTitle());
			
			ProductDetailsButton detailsButton;
			detailsButton = new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON);
			detailsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add(new ProductDetailScreen(BookshopGUI.this, detailsButton.getProduct()));
					revalidate();
				}
			});
			detailsButton.setProduct(product);

			
			p.add(ebook_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		}
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
			if(controller.getLoggedinUser() != null){
				JOptionPane.showMessageDialog(this, 
						Labels.USER_ALREADY_LOGGED_IN, 
						Labels.USER_LOGIN_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				new UserLoginDialog(this);
			}			
		} else if (e.getSource() == user_logout){		//If the user clicked on the 'Sign out' menu item
			if (controller.getLoggedinUser() == null){
				JOptionPane.showMessageDialog(this, 
						Labels.USER_SIGNOUT_ERROR, 
						Labels.USER_SIGNOUT_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			} else {
				controller.setLoggedinUser(null); // TODO: frissï¿½teni a grafikus elemeket hogy eltï¿½njenek ha valaminek el kell
				JOptionPane.showMessageDialog(this, 
						Labels.USER_SIGNOUT_SUCCESSFUL, 
						Labels.USER_SIGNOUT_TITLE, 
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == user_editprofile){	//If the user clicked on the 'Edit profile' menu item
			getContentPane().removeAll();
			getContentPane().add(new EditProfileScreen(this));
			revalidate();
			
		} else if (e.getSource() == search_products){	//If the user clicked on the 'Search products' menu item
			getContentPane().removeAll();
			getContentPane().add(new ProductSearchScreen(this));
			revalidate();
		} else if (e.getSource() == product_toplist){	//If the user clicked on the 'Product toplists' menu item
			//TODO Heti/havi toplista a vásárlások alapján (mindegy, hogy interneten vagy boltban vásárolták meg a könyvet).
		} else if (e.getSource() == cheap_products){
			getContentPane().removeAll();
			getContentPane().add(new CheapProductsScreen(this));
			revalidate();
		} else if (e.getSource() == popular_books){
			//TODO * A legnépszerûbb könyvek mûfajonként.
		} else if (e.getSource() == show_cart){
			getContentPane().removeAll();
			getContentPane().add(new UserCartScreen(this));
			revalidate();
		} else if (e.getSource() == cart_checkout) {
			getContentPane().removeAll();
			getContentPane().add(new CartCheckoutScreen(this));
			revalidate();
		} else if (e.getSource() == every_book_in_a_shop){
			getContentPane().removeAll();
			getContentPane().add(new BrowseProductsInShopScreen(this));
			revalidate();
		} else if (e.getSource() == book_in_which_shop){
			//TODO Egy adott könyv mely áruházban kapható?
		}
		
	}

}
