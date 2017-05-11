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
		
		table = new JTable();
		DefaultTableModel dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new Object[] { Labels.CART_ID_AND_TITLE, Labels.CART_AMOUNT_OF_ITEM });
		
		int totalprice = 0;
		for(Product tmp : cart.keySet())
		{
			int amount = cart.get(tmp).intValue();
			JLabel a1 = new JLabel(tmp.getId() + " " + tmp.getTitle());
			JLabel a2 = new JLabel(amount + "");
			JLabel a3 = new JLabel("$" + tmp.getPrice() * amount);
			Object[] row = { a1, a2, a3 };
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
