package hu.adatb.rbtl.view;

import javax.swing.JPanel;

public class UserCartScreen extends JPanel{

	private BookshopGUI gui;
	//private JLabel a;
	
	public UserCartScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		//TODO here: when you cann getUserCart, you get a map with <Product, Integer>. Product ONLY HAS id, every Title will show "TODO"!!!
		
	}
}
