package hu.adatb.rbtl.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;

public class ProductDetailScreen extends JPanel implements MouseListener{
	
	private BookshopGUI gui;
	
	private JPanel product_panel;
	
	private JPanel data_panel;
	private JLabel isbn_label, title_label, oldalszam_label, kotes_label, meret_label, ar_label, kiado_label, kiadaseve_label, szerzo_label;
	private JLabel isbn, title, oldalszam, kotes, meret, ar, kiado, kiadaseve, szerzo;
	
	private JPanel buy_panel;
	private JLabel buy_icon;
	
	private JPanel offers_panel;
	
	public ProductDetailScreen(BookshopGUI gui, Product product){
		this.gui = gui;
		this.setLayout(new GridLayout(0, 1));
		
		product_panel = new JPanel();
		product_panel.setLayout(new FlowLayout());
		
		data_panel = new JPanel();
		data_panel.setLayout(new GridLayout(0, 2));
		
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
			kiado = new JLabel(book.getPublisher());
			kiadaseve = new JLabel(String.valueOf(book.getPublishYear()));
			szerzo = new JLabel(book.getAuthor());			
			
			data_panel.add(isbn_label);
			data_panel.add(isbn);
			
			data_panel.add(title_label);
			data_panel.add(title);
			
			data_panel.add(szerzo_label);
			data_panel.add(szerzo);
			
			data_panel.add(kiado_label);
			data_panel.add(kiado);
			
			data_panel.add(kiadaseve_label);
			data_panel.add(kiadaseve);
			
			data_panel.add(oldalszam_label);
			data_panel.add(oldalszam);
			
			data_panel.add(kotes_label);
			data_panel.add(kotes);
			
			data_panel.add(meret_label);
			data_panel.add(meret);
			
			data_panel.add(ar_label);
			data_panel.add(ar);

		} else if (product instanceof Film){
			Film film = gui.getController().getFilmByID(product.getId());
			
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			title = new JLabel(film.getTitle());
			
			data_panel.add(title_label);
			data_panel.add(title);
			
		} else if (product instanceof Song){
			Song song = gui.getController().getSongByID(product.getId());
			
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			title = new JLabel(song.getTitle());
			
			data_panel.add(title_label);
			data_panel.add(title);
			
		} else {	//ebook
			Ebook ebook = gui.getController().getEbookByID(product.getId());
			
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			title = new JLabel(ebook.getTitle());
			
			data_panel.add(title_label);
			data_panel.add(title);
		}		
		
		buy_panel = new JPanel();
		buy_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/1493859883_finance-02.png")));
		buy_icon.addMouseListener(this);
		buy_panel.add(buy_icon);
		
		
		product_panel.add(data_panel);
		product_panel.add(buy_panel);
		
		add(product_panel);
		
		/* ------------------------------------- */
		offers_panel = new JPanel();
		//TODO Egy könyv adatlapjánál azon könyveket is kilistázni, amelyeket megvettek azok a vásárlók, amelyek az aktuális könyvet megvették.
		add(offers_panel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == buy_icon){
			//TODO kosárba helyezés
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
