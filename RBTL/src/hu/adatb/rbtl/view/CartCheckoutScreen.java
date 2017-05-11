package hu.adatb.rbtl.view;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import hu.adatb.rbtl.model.beans.Product;

//TODO * K�nyv v�s�rl�sa, ahol megadhat�, hogy kisz�ll�t�ssal vagy �zletben k�v�nja �tvenni a v�s�rl� a k�nyvet.
//TODO * K�nyv v�s�rl�sa (kisz�ll�t�ssal).
//TODO * Sz�mla k�sz�t�se a v�s�rl�sr�l.
public class CartCheckoutScreen extends JPanel{
	private BookshopGUI gui;
	
	private JTable table; 
	private HashMap<Product, Integer> cart;
	public CartCheckoutScreen(BookshopGUI gui) {
		super();
		this.gui = gui;
		this.cart = gui.getController().getUserCart(gui.getController().getLoggedinUser());
		
		table = new JTable();
		DefaultTableModel dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new Object[] { Labels.CART_ID_AND_TITLE, Labels.CART_AMOUNT_OF_ITEM, Labels.CART_COST_OF_SAME_ITEMS });
		
		int totalprice = 0;
		for(Product tmp : cart.keySet())
		{
			int amount = cart.get(tmp).intValue();
			String[] row = { tmp.getId() + " " + tmp.getTitle(), amount + "", "$" + tmp.getPrice() * amount}; // error prone
			dm.insertRow(dm.getRowCount(), row);
			
			totalprice += (amount * tmp.getPrice());
			
		}
		String[] lastLine = { Labels.CART_CHECKOUT_TOTAL, " ", "$" + totalprice}; 
		dm.insertRow(dm.getRowCount(), lastLine);
		
		table.setModel(dm);
		add(table);
		add(new JLabel("TODO: select address to ship to/shop to shipto xd"));
	}
	
}
