package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import hu.adatb.rbtl.model.beans.Product;
//TODO: updating
public class UserCartScreen extends JPanel  implements ActionListener { // I seriously doubt this will work but hey...

	private BookshopGUI gui;
	JButton checkout;
	//private JLabel a;
	HashMap<Product, Integer> cart;
	public void Refresh()
	{
		cart = gui.getController().getUserCart(gui.getController().getLoggedinUser());
		this.removeAll();
		int rows = cart.keySet().size();
		if(rows == 0) {
			add(new JLabel(Labels.CART_EMPTY), BorderLayout.CENTER);
			return;
		}
		setLayout(new BorderLayout());
	
		JPanel listpanel = new JPanel();
		GridLayout gl = new GridLayout(rows+1, 3);
		listpanel.setMinimumSize(new Dimension(10,10));
		listpanel.setPreferredSize(new Dimension(10,10));
		listpanel.setMaximumSize(new Dimension(10,10));
		gl.setHgap(10);
		gl.setVgap(10);
		listpanel.setLayout(gl);
		
		JScrollPane scrollpane = new JScrollPane(listpanel);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scrollpane, BorderLayout.CENTER);
		listpanel.add(new JLabel(Labels.CART_ID_AND_TITLE));
		listpanel.add(new JLabel(Labels.CART_AMOUNT_OF_ITEM));
		listpanel.add(new JLabel(Labels.CART_DELETE));
		
		for(Product tmp : cart.keySet())
		{
				//System.out.println("DEBUG: talaltam cuccot a cartodban!");
				JLabel a1 = new JLabel(tmp.getId() + "  |  " + tmp.getTitle());
				JSpinner a2 = new JSpinner();
				a2.setValue(cart.get(tmp).intValue());
				SpecialJButton tmp2 = new SpecialJButton(Labels.CART_DELETE, tmp);
				tmp2.addActionListener(this);
				
				   a2.addChangeListener(new ChangeListener() {
				        @Override
				        public void stateChanged(ChangeEvent e) {
				        	if(!gui.getController().ModifyProductInUserCart(gui.getController().getLoggedinUser(), tmp2.getP(), (int)a2.getValue()))
				        		Refresh(); // if not successful -> revert back
				        }
				    });			   
				   listpanel.add(a1);
				   listpanel.add(a2);
				   listpanel.add(tmp2);
		}
		
		checkout = new JButton(Labels.CART_CHECKOUT_MENUITEM);
		add(checkout, BorderLayout.SOUTH);
		checkout.addActionListener(this);
	}
	
	public UserCartScreen(BookshopGUI gui){
		super();
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
				//else System.out.println("DEBUG: No item to delete IN CART found!");
			}
			//else System.out.println("DEBUG: No item to delete was found!");
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