package hu.adatb.rbtl.model;

import java.util.List;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
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
	
	/**
	 * This method is for searching a book in the database by matching any of it's attributes
	 * @param book
	 * @return
	 */
	List<Product> searchBookByAttributes(Book book);
	
	/**
	 * This method is for searching a film in the database by matching any of it's attributes
	 * @param film
	 * @return
	 */
	List<Product> searchFilmByAttributes(Film film);
	
	/**
	 * This method is for searching a song in the database by matching any of it's attributes
	 * @param song
	 * @return
	 */
	List<Product> searchSongByAttributes(Song song);
	
	/**
	 * This method is for searching an ebook in the database by matching any of it's attributes
	 * @param ebook
	 * @return
	 */
	List<Product> searchEbookByAttributes(Ebook ebook);
	
	/**
	 * This method returns the author's name as a String, whose ID is the parameter
	 * @param id - the ID of the author
	 * @return
	 */
	String getAuthorByID(int id);
	
	/**
	 * This method returns the author's ID, who wrote the Book with the given ISBN
	 * @param isbn
	 * @return
	 */
	int getAuthorIDByISBN(String isbn);
	
	/**
	 * Returns the specified user's cart in a List that can be displayed on the screen.
	 * @param user
	 * @return List of Products in the user's cart.
	 */
	List<Product> getUserCart(User user);
	
	public Book getBookByID(String id);
}
