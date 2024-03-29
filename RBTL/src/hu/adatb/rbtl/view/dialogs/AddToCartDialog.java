package hu.adatb.rbtl.view.dialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.view.BookshopGUI;
import hu.adatb.rbtl.view.Labels;

public class AddToCartDialog extends JDialog implements ActionListener{

	private BookshopGUI gui;
	
	private JPanel productpanel, buttonpanel;
	private JLabel productname_label, quantity_label;
	private JLabel productname;
	private JSpinner quantity_spinner;
	private JButton okButton, cancelButton;
	private Product daProduct;
	
	public AddToCartDialog(BookshopGUI gui, Product product){
		super();
		this.gui = gui;
		daProduct = product;
		
		setLayout(new BorderLayout());
		setTitle(Labels.ADD_TO_CART_TITLE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		
		/* ---------------------------------- */
		
		productpanel = new JPanel();
		productpanel.setLayout(new GridLayout(2, 2));
		
		productname_label = new JLabel(Labels.ADD_TO_CART_NAME);
		quantity_label = new JLabel(Labels.ADD_TO_CART_QUANTITY);
		
		productname = new JLabel(product.getTitle());
		quantity_spinner = new JSpinner();
		
		productpanel.add(productname_label);
		productpanel.add(productname);
		
		productpanel.add(quantity_label);
		productpanel.add(quantity_spinner);
		
		/* ---------------------------------- */
		
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(1, 2));
		
		okButton = new JButton(Labels.ADD_TO_CART_OK);
		cancelButton = new JButton(Labels.ADD_TO_CART_CANCEL);
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		buttonpanel.add(okButton);
		buttonpanel.add(cancelButton);
				
		/* ---------------------------------- */
		add(productpanel, BorderLayout.CENTER);
		add(buttonpanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton){
			if (gui.getController().AddProductToUsercart(gui.getController().getLoggedinUser(), daProduct, (int) quantity_spinner.getValue())){
				//siker�lt
				JOptionPane.showMessageDialog(this, 
						Labels.ADD_TO_CART_SUCCESSFUL, 
						Labels.ADD_TO_CART_TITLE, 
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else {
				//nem siker�lt
				JOptionPane.showMessageDialog(this, 
						Labels.ADD_TO_CART_FAIL, 
						Labels.ADD_TO_CART_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (e.getSource() == cancelButton){
			dispose();
		}
	}

}
