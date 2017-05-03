package hu.adatb.rbtl.controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.model.BookshopDAO;
import hu.adatb.rbtl.model.BookshopDAOImplementation;
import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;
import hu.adatb.rbtl.view.Labels;

/**
 * This class controls the application.
 * It communicates with the Model layer in order to have database access
 * and it tells the View layer what to display
 */
public class BookshopController {

	private BookshopDAO dao = new BookshopDAOImplementation();
	private User loggedInUser = null;
	
	public boolean addBook(Book book){
		return dao.addBook(book);
	}
	
	public boolean addEbook(Ebook ebook){
		return dao.addEbook(ebook);
	}
	
	public boolean addFilm(Film film){
		return dao.addFilm(film);
	}
	
	public boolean addSong(Song song){
		return dao.addSong(song);
	}
	
	public boolean registerUser(User user){
		return dao.registerUser(user);
	}
	
	public String[] getAllBindings(){
		return dao.getAllBindings();
	}

	public String[] getAllPublishers() {
		return dao.getAllPublishers();
	}
	
	public boolean validateUser(User user){
		return dao.validateUser(user);
	}

	public User getLoggedinUser() {
		return loggedInUser;
	}

	public void setLoggedinUser(User loggedin) {
		this.loggedInUser = loggedin;
	}

	public List<Product> searchBook(Book book){
		return dao.searchBookByAttributes(book);
	}

	public List<Product> searchFilm(Film film) {
		return dao.searchFilmByAttributes(film);
	}
	
	public List<Product> searchSong(Song song){
		return dao.searchSongByAttributes(song);
	}
	
	public List<Product> searchEbook(Ebook ebook){
		return dao.searchEbookByAttributes(ebook);
	}
	
	public JPanel displayProductInList(Product product){
		if(product instanceof Book){
			JPanel ret, icon_panel, labels_panel, values_panel, button_panel;
			
			JLabel book_icon, label_title, label_author, label_publisher, label_price, label_publishYear;
			JLabel title, author, publisher, price, publishYear;
			JButton detailsButton;
			
			ret = new JPanel();
			ret.setLayout(new FlowLayout());
			
			/* -----------------BOOK ICON PANEL-------------  */
			icon_panel = new JPanel();
			book_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/book_icon_smaller.png")));
			icon_panel.add(book_icon);
			/* ---------------------------------------------- */
			
			/* ------------BOOK LABELS PANEL --------------- */
			labels_panel = new JPanel();
			labels_panel.setLayout(new GridLayout(4, 1));
			
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			label_author = new JLabel(Labels.PRODUCT_RESULT_AUTHOR);
			label_publisher = new JLabel(Labels.PRODUCT_RESULT_PUBLISHER);
			label_price = new JLabel(Labels.PRODUCT_RESULT_PRICE);
			
			labels_panel.add(label_title);		
			labels_panel.add(label_author);		
			labels_panel.add(label_publisher);		
			labels_panel.add(label_price);
			/* -------------------------------------------------- */
			
			/* ---------------------------- VALUES PANEL -------------------- */
			values_panel = new JPanel();
			values_panel.setLayout(new GridLayout(4, 1));
			
			title = new JLabel(((Book) product).getTitle());
			author = new JLabel(((Book) product).getAuthor());
			publisher = new JLabel(((Book) product).getPublisher());
			price = new JLabel(String.valueOf(((Book) product).getPrice()));
			
			values_panel.add(title);
			values_panel.add(author);
			values_panel.add(publisher);
			values_panel.add(price);		
			/* ----------------------------------------------------- */
			
			/* --------------- BUTTON PANEL -------------------*/
			button_panel = new JPanel();
			button_panel.setLayout(new GridLayout(3, 1));
			
			detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
			button_panel.add(new JLabel());	//üres hely az elsõ sorban
			button_panel.add(detailsButton);
			/* ------------------------------------------------ */
			
			
			
			ret.add(icon_panel);
			ret.add(labels_panel);
			ret.add(values_panel);
			ret.add(button_panel);
			
			return ret;
		} else if (product instanceof Film){
			JPanel p;
			JLabel film_icon, label_title, title;
			JButton detailsButton;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			film_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/film_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Film) product).getTitle());
			detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
			
						
			p.add(film_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		} else if (product instanceof Song){
			JPanel p;
			JLabel song_icon, label_title, title;
			JButton detailsButton;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			song_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/song_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Song) product).getTitle());
			detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
			
			p.add(song_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		} else {	//ebook
			JPanel p;
			JLabel ebook_icon, label_title, title;
			JButton detailsButton;
			
			p = new JPanel();
			p.setLayout(new FlowLayout());
			
			ebook_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/ebook_icon_smaller.png")));
			label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
			title = new JLabel(((Ebook) product).getTitle());
			detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
			
			p.add(ebook_icon);
			p.add(label_title);
			p.add(title);
			p.add(detailsButton);
			
			return p;
		}
	}
	
	
}
