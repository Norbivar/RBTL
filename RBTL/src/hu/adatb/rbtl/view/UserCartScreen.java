package hu.adatb.rbtl.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
	public UserCartScreen(BookshopGUI gui, HashMap<Product, Integer> cart){
		super();
		this.cart = cart;
		this.gui = gui;
		//TODO here: when you cann getUserCart, you get a map with <Product, Integer>. Product ONLY HAS id, every Title will show "TODO"!!!
		
		table = new JTable();
		DefaultTableModel dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new Object[] { "Code", "Title", "Amount","Delete" });
		for(Product tmp : cart.keySet())
		{
			if(/*tmp instanceof Book*/ true)
			{
				JLabel a1 = new JLabel(tmp.getId() + " " + tmp.getTitle());
				JTextField a2 = new JTextField(cart.get(tmp).intValue());
				SpecialJButton tmp2 = new SpecialJButton("Remove", tmp);
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
				
				//
				
				Object[] row = { a1, a2, tmp2 };
				
				dm.insertRow(dm.getRowCount(), row);
			}
		}
		table.setModel(dm);
		checkout = new JButton("Checkout!");
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
						System.out.println("VALAMI error!");
				}
			}
			table.updateUI();
		}
		else if(e.getSource() == checkout)
		{
			//TODO trigger controller checkout
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