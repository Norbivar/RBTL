package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.adatb.rbtl.model.beans.Book;

public class NewestBooksScreen extends JPanel{

	private BookshopGUI gui;
	private JScrollPane scrollpane;
	private JPanel p;
	
	public NewestBooksScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		this.setLayout(new BorderLayout());
		p = new JPanel();
		p.setLayout(new GridLayout(0, 1));
		
		List<Book> newestBooks = gui.getController().getNewestBooks();
		for(int i = 0; i<newestBooks.size(); i++){
			p.add(gui.displayProductInList(newestBooks.get(i)));
		}
		scrollpane = new JScrollPane(p);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane);
	}
}
