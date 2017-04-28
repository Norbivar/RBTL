package hu.adatb.rbtl.controller;

import hu.adatb.rbtl.model.BookshopDAO;
import hu.adatb.rbtl.model.BookshopDAOImplementation;
import hu.adatb.rbtl.model.beans.*;

public class BookshopController {

	BookshopDAO dao = new BookshopDAOImplementation();
	User loggedInUser = null;
	
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
}
