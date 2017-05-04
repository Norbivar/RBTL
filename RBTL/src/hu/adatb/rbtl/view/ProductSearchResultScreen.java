package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import hu.adatb.rbtl.model.beans.Product;

public class ProductSearchResultScreen extends JPanel {

	private BookshopGUI gui;
	private JScrollPane scrollpane;
	private JPanel productlist;
	private JLabel panel_title;
	
	public ProductSearchResultScreen(BookshopGUI gui, List<Product> list) {
		super();
		this.gui = gui;
		setLayout(new BorderLayout());
		
		productlist = new JPanel();
		productlist.setLayout(new GridLayout(0, 1));
		
		panel_title = new JLabel(Labels.PRODUCT_RESULT_PANE_TITLE + "   (number of results: " + list.size() + ")", SwingConstants.CENTER);
		add(panel_title, BorderLayout.NORTH);		
		
		for(int i = 0; i<list.size(); i++){
			productlist.add(gui.displayProductInList(list.get(i)));
		}
		
		scrollpane = new JScrollPane(productlist);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane, BorderLayout.CENTER);
	}
}
