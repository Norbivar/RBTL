package hu.adatb.rbtl.model;

import java.util.HashMap;
import java.util.List;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

public interface BookshopDAO {

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
	
	/**
	 * This method returns all the available bindings in the database
	 */
	boolean validateUserEditProfile(User user,  String password);
	/*
	 * This method returns if the user has the correct password in the database
	 * */
	
	boolean updateUserNameEditProfile(User user, String username);
	/*
	 * This method updates the user's name
	 * */
	 
	boolean updatePasswordEditProfile(User user, String password);
	/*
	 * This method updates the user's password
	 * */
	
	String[] getAllBindings();
	
	/**
	 * This method returns all the available publishers in the database
	 */
	String[] getAllPublishers();
	
	/**
	 * This method returns all the shops from the database
	 */
	String[] getAllShops();
	
	/**
	 * This method is for searching a book in the database by matching any of it's attributes
	 * @param book
	 * @return
	 */
	
	String[] getAllGenre();
	
	
	
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
	 * @return List of Products in the user's cart. ONLY id's are filled up.
	 */
	HashMap<Product, Integer> getUserCart(User user);
	
	/**
	 * Returns the Book identified by the parameter
	 * @param id - ID of the book
	 * @return {@link Book} object with the attributes of the book in the database
	 */
	public Book getBookByID(String id);
	
	/**
	 * Returns the {@link Film} identified by the parameter
	 * @param id - ID of the film
	 * @return {@link Film} object with the attributes of the film in the database
	 */
	public Film getFilmByID(String id);
	
	/**
	 * Returns the {@link Song} indentified by the parameter
	 * @param id - ID of the song
	 * @return {@link Song} object with the attributes of the song in the database
	 */
	public Song getSongByID(String id);
	
	/**
	 * Returns the {@link Ebook} indentified by the parameter
	 * @param id - ID of the ebook
	 * @return {@link Ebook} object with the attributes of the ebook in the database
	 */

	public Ebook getEbookByID(String id);
	/**
	 * Returns the id of the shop with the given address and name
	 * @param shopAddress - the address of the shop
	 * @param shopName - name of the shop
	 * @return id of the shop
	 */
	public String getShopIDFromAddressAndName(String shopAddress, String shopName);
	
	/**
	 * Return the available {@link Book} from the specific shop 
	 * @param shopAddress - the address of the shop
	 * @param shopName - name of the shop
	 * @return List of {@link Book}s
	 */
	public HashMap<Book, Integer> getBooksFromShop(String shopID);

	/**
	 * This method returns the publisher associated with the id given in the parameter
	 * @param id - id of the author
	 * @return
	 */
	String getPublisherNameByID(String id);

	/**
	 * This method returns the name of the binding with the given id
	 * @param id - id of the binding
	 * @return
	 */
	String getKotesByID(String id);

	/**
	 * This method returns a list of {@link Book}s which costs at least minprice, and maximum maxprice
	 * @param minprice - minimum price of the {@link Book}
	 * @param maxprice - maximum price of the {@link Book}
	 * @return - list of {@link Book}s
	 */

	List<Book> getBooksByPriceRange(int minprice, int maxprice);

	
	/**
	 * This method returns the top 10 result of purchased books in the current month
	 * */
	List<Book> getBooksFromMonthlyTopList();
	
	/**
	 * This method returns the top 10 result of purchased books in the current month
	 * */
	List<Book> getBooksFromWeeklyTopList();
	
	/**
	 * This method returns the books by genre...
	 * */
	List<Book> getBooksByGenreTopList(String genre);
	
	/**
	 * This method returns the shop where you can find the given {@link Book}
	 * @param book - the book to find
	 * @return - a {@link List} of {@link String}s, which contains the shops' data
	 */
	List<String> getShopOfBook(Book book);

	
	/**
	 * This method returns the address and name of the book with the given ID
	 * @param boltID - ID of the shop
	 * @return A String, which contains the address, then a ' | ' separator then the name
	 */
	String getShopAddressAndNameByID(int boltID);
	
	/**
	 * This method returns all the genres of the book with the given ISBN
	 * @param ISBN - ISBN of the book
	 * @return A List of Strings with the genre ID-s
	 */
	List<String> getBookGenresByISBN(String ISBN);
	
	/**
	 * This method returns the name of the genre with the given ID
	 * @param id - ID of the genre
	 * @return String, name of the genre
	 */
	String getGenreNameByID(String id);
	
	boolean AddProductToUsercart(User user, Product what, int howmany);
	
	boolean DeleteFromUserCart(User user, Product what);

	boolean ModifyProductInUserCart(User user, Product what, int tohowmany);

	/**
	 * The method returns the user identified by the given email and password
	 * @param email
	 * @param password
	 * @return
	 */
	User getUserByEmailAndPassWord(String email, String password);
	
	/**
	 * This method returns a list of products, which contains offers for the given one.
	 * @param product
	 * @return
	 */
	List<Product> getOffersForProduct(Product product);

	List<Book> listNewestBooks();
}
