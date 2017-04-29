package hu.adatb.rbtl.model;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

public interface BookshopDAO {

	/**
	 * This method is for adding a new {@link Book} to the database
	 * @param book - The {@link Book} which we want to add
	 * @return true if it was successful, otherwise false
	 */
	boolean addBook(Book book);
	
	/**
	 * This method is for adding a new {@link Ebook} to the database
	 * @param ebook - The {@link Ebook} which we want to add
	 * @return true if it was successful, otherwise false
	 */
	boolean addEbook(Ebook ebook);
	
	/**
	 * This method is for adding a new {@link Film} to the database
	 * @param film - The {@link Film} which we want to add
	 * @return true if it was successful, otherwise false
	 */
	boolean addFilm(Film film);
	
	/**
	 * This method is for adding a new {@link Song} to the database
	 * @param song - The {@link Song} which we want to add
	 * @return true if it was successful, otherwise false
	 */
	boolean addSong(Song song);
	
	/**
	 * This method is for adding a new {@link User} to the database
	 * @param user - The {@link User} which we want to add
	 * @return true if it was successful, otherwise false
	 */
	boolean registerUser(User user);
	
	/**
	 * This method is for checking if the {@link User} given in the parameter is a valid one according to the database
	 * @param user - The {@link User} which we want to check if it exists/is valid.
	 * @return true if it is a valid {@link User}, otherwise false
	 */
	boolean validateUser(User user);
	
	//List<Product> searchProducts();
	
	/**
	 * This method returns all the available bindings in the database
	 */
	String[] getAllBindings();
	
	/**
	 * This method returns all the available publishers in the database
	 */
	String[] getAllPublishers();
}
