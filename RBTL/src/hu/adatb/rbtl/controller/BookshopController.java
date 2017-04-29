package hu.adatb.rbtl.controller;

import hu.adatb.rbtl.model.BookshopDAO;
import hu.adatb.rbtl.model.BookshopDAOImplementation;
import hu.adatb.rbtl.model.beans.*;

/**
 * This class controls the application.
 * It communicates with the Model layer in order to have database access
 * and it tells the View layer what to display
 */
public class BookshopController {

	private BookshopDAO dao = new BookshopDAOImplementation();
	private boolean loggedin;
	
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

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	
}
