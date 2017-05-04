package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.adatb.rbtl.model.beans.Book;

/**
 * On this screen, you can select a shop and then it displays all the products what you can find there.
 *
 */
public class BrowseProductsInShopScreen extends JPanel implements ItemListener{

	private BookshopGUI gui;
	
	private Box verticalBox;
	
	private JPanel selectorpanel;
	private JLabel select_shop_label;
	private JComboBox<String> shop_combobox;
	private String selectedShop_name, selectedShop_address;
	
	private JScrollPane product_scrollable_list;
	private JPanel listpanel;
	
	/**
	 * {@link BrowseProductsInShopScreen} constructor
	 * @param gui - the {@link BookshopGUI} of the app
	 */
	public BrowseProductsInShopScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		verticalBox = Box.createVerticalBox();
		
		/*  Panel where the user can select which shop's collection he/she wants to see  */
		selectorpanel = new JPanel();
		selectorpanel.setLayout(new FlowLayout());
		
		select_shop_label = new JLabel(Labels.SHOP_SELECTSHOP);
		shop_combobox = new JComboBox<String>(this.gui.getController().getAllShops());
		shop_combobox.addItemListener(this);
		shop_combobox.setSelectedIndex(0);
		
		selectorpanel.add(select_shop_label);
		selectorpanel.add(shop_combobox);
		
		verticalBox.add(selectorpanel);
		
		/*  Scrollable list with the products  */
		listpanel = new JPanel();
		listpanel.setLayout(new GridLayout(0, 2));
		
		product_scrollable_list = new JScrollPane(listpanel);
		verticalBox.add(product_scrollable_list);
		
		add(verticalBox);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	          String item = String.valueOf(e.getItem());
	          String parts[] = item.split("  |  ");
	          selectedShop_address = parts[0];
	          selectedShop_name = parts[2];

	          String shopid = gui.getController().getShopIDFromAddressAndName(selectedShop_address, selectedShop_name);
	          	          
	          listpanel.removeAll();
	          HashMap<Book, Integer> set = gui.getController().getBooksFromShop(shopid);
	          for (Map.Entry<Book, Integer> entry : set.entrySet())
	          {	        	  
	              //System.out.println(entry.getKey().getTitle() + "/" + entry.getValue());
	              listpanel.add(gui.displayProductInList(entry.getKey()));
	              listpanel.add(new JLabel(Labels.SHOP_AMOUNT + String.valueOf(entry.getValue())));
	          }
	          listpanel.revalidate();
	          verticalBox.revalidate();
	       }
	}
}
