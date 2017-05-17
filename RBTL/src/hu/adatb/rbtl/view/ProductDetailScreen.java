package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.view.dialogs.AddToCartDialog;

public class ProductDetailScreen extends JPanel implements MouseListener{
	
	private BookshopGUI gui;
	
	private JPanel product_panel;
	
	private JPanel data_panel;
	private JLabel isbn_label, title_label, oldalszam_label, kotes_label, meret_label, ar_label, kiado_label, kiadaseve_label, szerzo_label, genre_label;
	private JLabel isbn, title, oldalszam, kotes, meret, ar, kiado, kiadaseve, szerzo, genre;
	
	private JPanel buy_panel;
	private JLabel buy_icon, back_arrow;
	
	private JPanel offers_panel, all_offers_flow, first_offer, second_offer, third_offer;
	private JLabel offers_title, first_title, second_title, third_title;
	private Product firstOffer, secondOffer, thirdOffer;
	private List<Product> offers;
	
	private Product daProduct;
	
	public ProductDetailScreen(BookshopGUI gui, Product product){
		super();
		this.gui = gui;
		this.setLayout(new GridLayout(0, 1));
		//this.setOpaque(true);
		
		product_panel = new JPanel();
		product_panel.setLayout(new FlowLayout());
		
		data_panel = new JPanel();
		data_panel.setLayout(new GridLayout(0, 2));
		daProduct = product;
		
		if(product instanceof Book){
			Book book = gui.getController().getBookByID(((Book) product).getIsbn());
			
			isbn_label = new JLabel(Labels.PRODUCT_ISBN);
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			oldalszam_label = new JLabel(Labels.PRODUCT_OLDALSZAM);
			kotes_label = new JLabel(Labels.PRODUCT_KOTES);
			meret_label = new JLabel(Labels.PRODUCT_MERET);
			ar_label = new JLabel(Labels.PRODUCT_AR);
			kiado_label = new JLabel(Labels.PRODUCT_KIADO);
			kiadaseve_label = new JLabel(Labels.PRODUCT_KIADASEVE);
			szerzo_label = new JLabel(Labels.PRODUCT_SZERZO);
			genre_label = new JLabel(Labels.PRODUCT_GENRE);
			
			isbn = new JLabel(book.getIsbn());
			title = new JLabel(book.getTitle());
			oldalszam = new JLabel(String.valueOf(book.getNumOfPages()));
			kotes = new JLabel(book.getKotesNev());
			meret = new JLabel(book.getSize());
			ar = new JLabel(String.valueOf(book.getPrice()));
			kiado = new JLabel(book.getPublisher());
			kiadaseve = new JLabel(String.valueOf(book.getPublishYear()));
			szerzo = new JLabel(book.getAuthor());
			genre = new JLabel();
			
			List<String> mufajok = book.getMufajok();
			if(mufajok.size() == 1) {
				genre.setText(mufajok.get(0));
			}
			else {
				for(int i = 0; i<mufajok.size(); i++){
					genre.setText(genre.getText() + ", "+ mufajok.get(i));
				}
			}
			
			data_panel.add(isbn_label);
			data_panel.add(isbn);
			
			data_panel.add(title_label);
			data_panel.add(title);
			
			data_panel.add(genre_label);
			data_panel.add(genre);
			
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
			ar_label = new JLabel(Labels.PRODUCT_AR);
			
			title = new JLabel(film.getTitle());
			ar = new JLabel(String.valueOf(product.getPrice()));
			
			data_panel.add(title_label);
			data_panel.add(title);
			
			data_panel.add(ar_label);
			data_panel.add(ar);
			
		} else if (product instanceof Song){
			Song song = gui.getController().getSongByID(product.getId());
			
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			ar_label = new JLabel(Labels.PRODUCT_AR);
			
			title = new JLabel(song.getTitle());
			ar = new JLabel(String.valueOf(product.getPrice()));
			
			data_panel.add(title_label);
			data_panel.add(title);
			
			data_panel.add(ar_label);
			data_panel.add(ar);
			
		} else {	//ebook
			Ebook ebook = gui.getController().getEbookByID(product.getId());
			
			title_label = new JLabel(Labels.PRODUCT_TITLE);
			ar_label = new JLabel(Labels.PRODUCT_AR);
			
			title = new JLabel(ebook.getTitle());
			ar = new JLabel(String.valueOf(product.getPrice()));
			
			data_panel.add(title_label);
			data_panel.add(title);
			
			data_panel.add(ar_label);
			data_panel.add(ar);
		}		
		
		buy_panel = new JPanel();
		buy_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/1493859883_finance-02.png")));
		buy_icon.addMouseListener(this);
		buy_panel.add(buy_icon);
		
		
		back_arrow = new JLabel(new ImageIcon(this.getClass().getResource("/images/back_arrow.png")));
		back_arrow.addMouseListener(this);
		
		product_panel.add(back_arrow);
		product_panel.add(data_panel);
		
		if(!(gui.getController().getLoggedinUser() == null)){
			product_panel.add(buy_panel);
		}
		
		
		add(product_panel);
		
		/* ------------------------------------- */
		//TODO Egy k�nyv adatlapj�n�l azon k�nyveket is kilist�zni, amelyeket megvettek azok a v�s�rl�k, 
		//amelyek az aktu�lis k�nyvet megvett�k.
		offers_panel = new JPanel();
		offers_panel.setLayout(new BorderLayout());
		
		offers_title = new JLabel(Labels.PRODUCT_OFFERS, SwingConstants.CENTER);
		offers_panel.add(offers_title, BorderLayout.NORTH);
		
		
		all_offers_flow = new JPanel();
		all_offers_flow.setLayout(new FlowLayout());
		
		
		first_offer = new JPanel();
		second_offer = new JPanel();
		third_offer = new JPanel();

		first_offer.setLayout(new GridLayout(2, 1));
		second_offer.setLayout(new GridLayout(2, 1));
		third_offer.setLayout(new GridLayout(2, 1));
		
		offers = gui.getController().getOffersForProduct(daProduct);
		
		System.out.println(offers.size());
		
		if(offers.size() == 1){
			first_title = new JLabel(offers.get(0).getTitle());
			first_offer.add(first_title);
			first_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
		} else if (offers.size() == 2){
			first_title = new JLabel(offers.get(0).getTitle());
			first_offer.add(first_title);
			first_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
			
			second_title = new JLabel(offers.get(1).getTitle());
			second_offer.add(second_title);
			second_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
		} else if (offers.size()>2){
			first_title = new JLabel(offers.get(0).getTitle());
			first_offer.add(first_title);
			first_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
			
			second_title = new JLabel(offers.get(1).getTitle());
			second_offer.add(second_title);
			second_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
			
			third_title = new JLabel(offers.get(2).getTitle());
			third_offer.add(third_title);
			third_offer.add(new ProductDetailsButton(Labels.PRODUCT_DETAILS_BUTTON, daProduct));
		}
		
		all_offers_flow.add(first_offer);
		all_offers_flow.add(second_offer);
		all_offers_flow.add(third_offer);
		
		
		/*offers_panel.add(first_offer);
		offers_panel.add(second_offer);
		offers_panel.add(third_offer);*/
		
		offers_panel.add(all_offers_flow, BorderLayout.CENTER);
		add(offers_panel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == buy_icon){
			new AddToCartDialog(gui, daProduct);
		} else if (e.getSource() == back_arrow){
			gui.getContentPane().remove(getComponentCount()-1);
			gui.getContentPane().getComponent(getComponentCount()-2).setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


}
