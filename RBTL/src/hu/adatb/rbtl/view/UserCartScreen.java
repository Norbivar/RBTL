package hu.adatb.rbtl.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Product;
//TODO: updating
public class UserCartScreen extends JPanel  implements ActionListener { // I seriously doubt this will work but hey...

	private BookshopGUI gui;
	private JTable table; 
	JButton checkout;
	//private JLabel a;
	HashMap<Product, Integer> cart;
	public UserCartScreen(BookshopGUI gui){
		super();
		this.cart = gui.getController().getUserCart(gui.getController().getLoggedinUser());
		this.gui = gui;

		table = new JTable();
		DefaultTableModel dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new Object[] { Labels.CART_ID_AND_TITLE, Labels.CART_AMOUNT_OF_ITEM, Labels.CART_DELETE });
		for(Product tmp : cart.keySet())
		{
				System.out.println("DEBUG: talaltam cuccot a cartodban!");
				JLabel a1 = new JLabel(tmp.getId() + " " + tmp.getTitle());
				JTextField a2 = new JTextField(cart.get(tmp).intValue());
				SpecialJButton tmp2 = new SpecialJButton(Labels.CART_DELETE, tmp);
				tmp2.addActionListener(this);
				
				// Medzsik
				a2.getDocument().addDocumentListener(new DocumentListener() {
					  public void changedUpdate(DocumentEvent e) {
						  doIt();
					  }
					  public void removeUpdate(DocumentEvent e) {
						  doIt();
					  }
					  public void insertUpdate(DocumentEvent e) {
						  doIt();
					  }

					  public void doIt() {
					     if (Integer.parseInt(a2.getText())<=0){
					    	 a2.setText("1");
					     }
					     gui.getController().ModifyProductInUserCart(gui.getController().getLoggedinUser(), tmp2.getP(), Integer.parseInt(a2.getText()));
					  }
					});
				Vector v = new Vector();
				v.add(a1);
				v.add(a2);
				v.add(tmp2);

				dm.insertRow(dm.getRowCount(), v);
		}
		table.setModel(dm);
		add(table);
		checkout = new JButton(Labels.CART_CHECKOUT_MENUITEM);
		add(checkout);
		checkout.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof SpecialJButton)
		{
			int counter = -1;
			Product asd = ((SpecialJButton) e.getSource()).getP();
			for(Product tmp : cart.keySet())
			{
				counter++;
				if(tmp.getId() == asd.getId()) {
					((DefaultTableModel)table.getModel()).removeRow(counter);
					if(gui.getController().DeleteFromUserCart(gui.getController().getLoggedinUser(), asd))
						break;
					else
						System.out.println("ERROR: Could not delete item from cart!");
				}
			}
			table.updateUI();
		}
		else if(e.getSource() == checkout)
		{
			gui.HandleCheckout();
		}
	}
}
class SpecialJButton extends JButton
{
	private Product p;
	SpecialJButton(String title, Product which) 
	{
		super(title);
		p = which;
	}
	public Product getP() {
		return p;
	}
}