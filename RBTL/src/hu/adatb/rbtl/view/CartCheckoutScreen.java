package hu.adatb.rbtl.view;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class CartCheckoutScreen extends JPanel implements ActionListener{
	private BookshopGUI gui;
	
	private JTable table; 
	private HashMap<Product, Integer> cart;
	private JCheckBox szemelyesatvetel;
	private JComboBox dropdown;
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
		dm.setColumnIdentifiers(new String[] { Labels.CART_ID_AND_TITLE, Labels.CART_AMOUNT_OF_ITEM, Labels.CART_COST_OF_SAME_ITEMS });
		
		int totalprice = 0;
		for(Product tmp : cart.keySet())
		{
			int amount = cart.get(tmp).intValue();
			String[] row = { "ID: " + tmp.getId() + "    " + tmp.getTitle(), amount + "", "$" + tmp.getPrice() * amount}; 
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
		
		table.setModel(dm);

		table.getColumnModel().getColumn(0).setMinWidth(350);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		
		add(BorderLayout.CENTER, table);
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,2));
		
		dropdown = new JComboBox<String>();
		szemelyesatvetel = new JCheckBox(Labels.CART_CHECKOUT_NO_SHIPPING);
		szemelyesatvetel.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	            	RefreshComboBox(dropdown, e.getStateChange() == ItemEvent.SELECTED ? true : false);
	            }
	        });
		
		south.add(szemelyesatvetel);
		south.add(dropdown);
		JButton rendelo = new JButton(Labels.CART_CHECKOUT_GO_CHECKOUT);
		rendelo.addActionListener(this);
		south.add(rendelo);
		add(BorderLayout.SOUTH, south);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(dropdown.getSelectedItem() != null) {
        	if(gui.getController().HandleFinalCheckout(gui.getController().getLoggedinUser(), szemelyesatvetel.isSelected(), (String)dropdown.getSelectedItem())) {
				JOptionPane.showMessageDialog(this, 
						Labels.CHECKOUT_DESC, 
						Labels.CHECKOUT_TITLE, 
						JOptionPane.INFORMATION_MESSAGE);
        	} 
        	gui.handleWelcomeScreen();
    	}
    	else
			JOptionPane.showMessageDialog(this, 
					"We are sorry but we cannot ship to the Space!", 
					"No address!", 
					JOptionPane.INFORMATION_MESSAGE);
    }
	private void RefreshComboBox(JComboBox<String> whut, boolean boltban) {
		whut.removeAllItems();
		if(boltban) {
			for(String asd : gui.getController().getAllShops()) {
				whut.addItem(asd);
			}
		}
		else {
			for(String asd : gui.getController().getAllAddressesForUser(gui.getController().getLoggedinUser())) {
				whut.addItem(asd);
			}
		}
	}
}
