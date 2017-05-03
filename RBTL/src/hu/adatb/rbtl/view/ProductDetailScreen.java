package hu.adatb.rbtl.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;

public class ProductDetailScreen extends JPanel{
	
	private BookshopGUI gui;
	
	private JPanel data_panel, buy_panel;
	private JLabel isbn_label, title_label, oldalszam_label, kotes_label, meret_label, ar_label, kiado_label, kiadaseve_label, szerzo_label;
	private JLabel isbn, title, oldalszam, kotes, meret, ar, kiado, kiadaseve, szerzo;
	
	public ProductDetailScreen(BookshopGUI gui, Product product){
		this.gui = gui;
		
		data_panel = new JPanel();
		data_panel.setLayout(new GridLayout(0, 1));
		
		if(product instanceof Book){
			Book book = gui.getController().getBookByID(product.getId());
			
			isbn_label = new JLabel(Labels.PRODUCT_ISBN);
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			oldalszam_label = new JLabel(Labels.PRODUCT_OLDALSZAM);
			kotes_label = new JLabel(Labels.PRODUCT_KOTES);
			meret_label = new JLabel(Labels.PRODUCT_MERET);
			ar_label = new JLabel(Labels.PRODUCT_AR);
			kiado_label = new JLabel(Labels.PRODUCT_KIADO);
			kiadaseve_label = new JLabel(Labels.PRODUCT_KIADASEVE);
			szerzo_label = new JLabel(Labels.PRODUCT_SZERZO);
			
			isbn = new JLabel(book.getIsbn());
			title = new JLabel(book.getTitle());
			oldalszam = new JLabel(String.valueOf(book.getNumOfPages()));
			kotes = new JLabel(book.getKotesNev());
			meret = new JLabel(book.getSize());
			ar = new JLabel(String.valueOf(book.getPrice()));
			//TODO kiado
			kiadaseve = new JLabel(String.valueOf(book.getPublishYear()));
			//TODO szerzo
			
			data_panel.add(isbn_label);
			data_panel.add(isbn);
			
			data_panel.add(title_label);
			data_panel.add(title);

		} else if (product instanceof Film){

		} else if (product instanceof Song){

		} else {	//ebook

		}
		add(data_panel);
	}

}
