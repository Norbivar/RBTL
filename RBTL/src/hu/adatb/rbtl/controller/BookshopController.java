package hu.adatb.rbtl.controller;

import java.util.HashMap;
import java.util.List;

import hu.adatb.rbtl.model.BookshopDAO;
import hu.adatb.rbtl.model.BookshopDAOImplementation;
import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

/**
 * This class controls the application.
 * It communicates with the Model layer in order to have database access
 * and it tells the View layer what to display
 */
public class BookshopController{

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
	
	public String[] getAllShops(){
		return dao.getAllShops();
	}
	
	public String[] getAllGenre(){
		return dao.getAllGenre();
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
	
	public Book getBookByID(String id){
		return dao.getBookByID(id);
	}
	
	public Film getFilmByID(String id){
		return dao.getFilmByID(id);
	}
	
	public Song getSongByID(String id){
		return dao.getSongByID(id);
	}
	
	public Ebook getEbookByID(String id){
		return dao.getEbookByID(id);
	}

	public boolean validateUserEditProfile(User user,  String password){
		return dao.validateUserEditProfile(user, password);
	}
	
	public boolean updateUserNameEditProfile(User user, String username){
		return dao.updateUserNameEditProfile(user, username);
	}
	
	public boolean updatePasswordEditProfile(User user, String password){
		return dao.updatePasswordEditProfile(user, password);
	}

	public HashMap<Book, Integer> getBooksFromShop(String shopID){
		return dao.getBooksFromShop(shopID);
	}
	
	public HashMap<Product, Integer> getUserCart(User user){
		return dao.getUserCart(user);
	}
	
	public boolean DeleteFromUserCart(User user, Product what) {
		return dao.DeleteFromUserCart(user, what);
	}
	
	public boolean AddProductToUsercart(User user, Product what, int howmany) {
		return dao.AddProductToUsercart(user, what, howmany);
	}
	
	public boolean ModifyProductInUserCart(User user, Product what,  int tohowmany) {
		return dao.ModifyProductInUserCart(user, what, tohowmany);
	}
	
	public String getShopIDFromAddressAndName(String shopAddress, String shopName) {
		return dao.getShopIDFromAddressAndName(shopAddress, shopName);
	}
	
	public List<Book> getBooksByPriceRange(int minprice, int maxprice) {
		return dao.getBooksByPriceRange(minprice, maxprice);
	}
	
	public List<Book> getBooksFromMonthlyTopList(){
		return dao.getBooksFromMonthlyTopList();
	}
	
	public List<Book> getBooksFromWeeklyTopList(){
		return dao.getBooksFromWeeklyTopList();
	}
	
	public List<String> getShopOfBook(Book book){
		return dao.getShopOfBook(book);
	}
	
	public String getShopAddressAndNameByID(int boltID){
		return dao.getShopAddressAndNameByID(boltID);
	}
	
	public List<String> getGenresOfBookByISBN(String ISBN){
		return dao.getBookGenresByISBN(ISBN);
	}
	
	public String getNameOfGenreByID(String ID){
		return dao.getGenreNameByID(ID);
	}
	
}
