package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import hu.adatb.rbtl.model.beans.Product;

//TODO * Könyv vásárlása, ahol megadható, hogy kiszállítással vagy üzletben kívánja átvenni a vásárló a könyvet.
//TODO * Könyv vásárlása (kiszállítással).
//TODO * Számla készítése a vásárlásról.
public class CartCheckoutScreen extends JPanel{
	private BookshopGUI gui;
	
	private JTable table; 
	private HashMap<Product, Integer> cart;
	public CartCheckoutScreen(BookshopGUI gui) {
		super();
		this.gui = gui;
		this.cart = gui.getController().getUserCart(gui.getController().getLoggedinUser());
		setLayout(new BorderLayout());
		table = new JTable();
		DefaultTableModel dm = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		dm.setColumnIdentifiers(new Object[] { Labels.CART_ID_AND_TITLE, Labels.CART_AMOUNT_OF_ITEM, Labels.CART_COST_OF_SAME_ITEMS });
		
		int totalprice = 0;
		for(Product tmp : cart.keySet())
		{
			int amount = cart.get(tmp).intValue();
			String[] row = { tmp.getId() + " " + tmp.getTitle(), amount + "", "$" + tmp.getPrice() * amount}; // error prone
			dm.insertRow(dm.getRowCount(), row);
			
			totalprice += (amount * tmp.getPrice());
			
		}
		if(gui.getController().getLoggedinUser().isTorzsvasarlo() == true) {
			int discount = totalprice / 10;
			String[] DiscountLine = { Labels.CART_CHECKOUT_DISCOUT, " ", "- $" + discount}; 
			dm.insertRow(dm.getRowCount(), DiscountLine);
			totalprice -= discount;
		}		
		String[] lastLine = { Labels.CART_CHECKOUT_TOTAL, " ", "$" + totalprice}; 
		dm.insertRow(dm.getRowCount(), lastLine);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		
		table.setModel(dm);
		add(BorderLayout.CENTER, table);
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,1));

		add(BorderLayout.SOUTH, south);
	}
	
}
