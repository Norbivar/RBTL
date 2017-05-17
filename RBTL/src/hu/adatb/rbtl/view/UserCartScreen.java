package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
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
	JButton checkout;
	//private JLabel a;
	HashMap<Product, Integer> cart;
	public void Refresh()
	{
		this.removeAll();
		int rows = cart.keySet().size();
		setLayout(new BorderLayout());
		//layout();.
		JPanel centerpanel = new JPanel();
		centerpanel.setLayout(new GridLayout(3, rows+1));
		add(centerpanel, BorderLayout.CENTER);
		add(new JLabel(Labels.CART_ID_AND_TITLE));
		add(new JLabel(Labels.CART_AMOUNT_OF_ITEM));
		add(new JLabel(Labels.CART_DELETE));
		
		for(Product tmp : cart.keySet())
		{
				//System.out.println("DEBUG: talaltam cuccot a cartodban!");
				JLabel a1 = new JLabel(tmp.getId() + " " + tmp.getTitle());
				JTextField a2 = new JTextField();
				a2.setText(cart.get(tmp).intValue() +"");
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
				add(a1);
				add(a2);
				add(tmp2);
		}
		
		checkout = new JButton(Labels.CART_CHECKOUT_MENUITEM);
		add(checkout);
		checkout.addActionListener(this);
	}
	
	public UserCartScreen(BookshopGUI gui){
		super();
		this.cart = gui.getController().getUserCart(gui.getController().getLoggedinUser());
		this.gui = gui;

		Refresh();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof SpecialJButton)
		{
			Product asd = ((SpecialJButton) e.getSource()).getP();
			if(cart.remove(asd) != null)
			{
				if(gui.getController().DeleteFromUserCart(gui.getController().getLoggedinUser(), asd))
					Refresh();
				else System.out.println("DEBUG: No item to delete IN CART found!");
			}
			else System.out.println("DEBUG: No item to delete was found!");
			this.revalidate();
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