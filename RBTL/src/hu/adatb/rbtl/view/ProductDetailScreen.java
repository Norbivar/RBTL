package hu.adatb.rbtl.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;

public class ProductDetailScreen extends JPanel{
	
	private BookshopGUI gui;
	
	private JPanel data_panel, buy_panel;
	
	public ProductDetailScreen(BookshopGUI gui, Product product){
		this.gui = gui;
		
		if(product instanceof Book){
			

		} else if (product instanceof Film){

		} else if (product instanceof Song){

		} else {	//ebook

		}
	}

}
