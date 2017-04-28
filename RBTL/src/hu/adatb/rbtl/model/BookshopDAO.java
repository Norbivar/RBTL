package hu.adatb.rbtl.model;

import hu.adatb.rbtl.model.beans.*;

public interface BookshopDAO {

	boolean addBook(Book book);
	boolean addEbook(Ebook ebook);
	boolean addFilm(Film film);
	boolean addSong(Song song);
	boolean registerUser(User user);
	boolean userLogin(User user);
}
