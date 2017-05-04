package hu.adatb.rbtl.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
		
		this.setLayout(new GridLayout(0, 1));
		
		/*  Panel where the user can select which shop's collection he/she wants to see  */
		selectorpanel = new JPanel();
		selectorpanel.setLayout(new FlowLayout());
		
		select_shop_label = new JLabel(Labels.SHOP_SELECTSHOP);
		shop_combobox = new JComboBox<String>(this.gui.getController().getAllShops());
		shop_combobox.addItemListener(this);
		shop_combobox.setSelectedIndex(0);
		
		selectorpanel.add(select_shop_label);
		selectorpanel.add(shop_combobox);
		
		add(selectorpanel);
		
		/*  Scrollable list with the products  */
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	          String item = String.valueOf(e.getItem());
	          String parts[] = item.split("  |  ");
	          selectedShop_address = parts[0];
	          selectedShop_name = parts[2];
	          
	          System.out.println(selectedShop_address);
	          System.out.println(selectedShop_name);
	          String shopid = gui.getController().getShopIDFromAddressAndName(selectedShop_address, selectedShop_name);
	          	          
	          HashMap<Book, Integer> set = gui.getController().getBooksFromShop(shopid);
	          Iterator it = set.entrySet().iterator();
	          /*while(it.hasNext()){
	        	  System.out.println(selectedShop_address + " " + selectedShop_name);
	        	  Map.Entry pair = (Map.Entry) it.next();
	              System.out.println(pair.getKey() + " = " + pair.getValue());
	              it.remove(); // avoids a ConcurrentModificationException
	          }*/
	          for (Map.Entry<Book, Integer> entry : set.entrySet())
	          {
	              System.out.println(entry.getKey() + "/" + entry.getValue());
	          }
	       }
	}
}
