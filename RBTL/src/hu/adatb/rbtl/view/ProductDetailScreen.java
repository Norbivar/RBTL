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
	private JLabel isbn_label, title_label, oldalszam_label, kotes_label, meret_label, ar_label, kiado_label, kiadaseve_label;
	private JLabel isbn, title, oldalszam, kotes, meret, ar, kiado, kiadaseve;
	
	public ProductDetailScreen(BookshopGUI gui, Product product){
		this.gui = gui;
		
		data_panel = new JPanel();
		data_panel.setLayout(new GridLayout(0, 1));
		
		if(product instanceof Book){
			Book book = null;
			
			isbn_label = new JLabel(Labels.PRODUCT_ISBN);
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			oldalszam_label = new JLabel(Labels.PRODUCT_OLDALSZAM);
			kotes_label = new JLabel(Labels.PRODUCT_KOTES);
			meret_label = new JLabel(Labels.PRODUCT_MERET);
			ar_label = new JLabel(Labels.PRODUCT_AR);
			kiado_label = new JLabel(Labels.PRODUCT_KIADO);
			kiadaseve_label = new JLabel(Labels.PRODUCT_KIADASEVE);

		} else if (product instanceof Film){

		} else if (product instanceof Song){

		} else {	//ebook

		}
	}

}
