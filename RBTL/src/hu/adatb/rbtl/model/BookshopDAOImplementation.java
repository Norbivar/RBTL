package hu.adatb.rbtl.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

public class BookshopDAOImplementation implements BookshopDAO {
	private final String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:4000:kabinet";
	
	private final String USERNAME = "";
	private final String PASSWORD = "";
	
	/* Ide trigger kell a besz�r�shoz, hogy az id j� legyen. Pl ez j�:
	  	CREATE OR REPLACE TRIGGER db_ujfelhasznalo
		BEFORE INSERT ON felhasznalo
		FOR EACH ROW
		BEGIN
  			:NEW.FELHASZNALOID := FELHASZNALO_SEQ.nextval;
		END;
	*/
	private final String REGISTER_USER = "INSERT INTO felhasznalo (nev, torzsvasarlo, email, jelszo) VALUES (?, ?, ?, ?)";
	private final String VALIDATE_USER = "SELECT * FROM felhasznalo WHERE email LIKE ? AND jelszo LIKE ?";
	private final String GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM felhasznalo WHERE email LIKE ? AND jelszo LIKE ?";
	private final String VALIDATE_USER_EDIT_PROFILE ="SELECT jelszo FROM felhasznalo WHERE email LIKE ?";
	private final String UPDATE_USER_NAME_EDIT_PROFILE1 ="UPDATE felhasznalo  SET nev = ";
	private final String UPDATE_USER_NAME_EDIT_PROFILE2 = " WHERE email LIKE ";
	private final String UPDATE_USER_PASSWORD_EDIT_PROFILE1 ="UPDATE felhasznalo  SET jelszo = '";
	private final String UPDATE_USER_PASSWORD_EDIT_PROFILE2 ="' WHERE email LIKE '";
	
	private final String GET_ALL_BINDIGS = "SELECT megnevezes FROM kotes";
	private final String GET_ALL_AUTHORS = "SELECT nev FROM szerzo";
	private final String GET_ALL_SHOPS = "SELECT cim, nev FROM bolt";
	private final String GET_ALL_GENRE = "SELECT neve FROM mufaj";
	
	private final String GET_BOOKS_BY_GENRE ="SELECT konyv.cim, KONYV.AR, SZERZO.nev AS szerzo_nev, KIADO.nev AS kiado_nev"  
						+ "FROM KONYV,KIADO,SZERZO"
						+ "INNER JOIN szerzoje ON szerzoje.SZERZOID = SZERZO.SZERZOID,"
						+ "JOIN mufaj "
						+ "JOIN konyvmufajai ON mufaj.mufajid = konyvmufajai.MUFAJID"
						+ "WHERE szerzoje.ISBN = KONYV.ISBN AND mufaj.mufajid = ";
	
	/*private final String SEARCH_BOOK = "SELECT * FROM konyv "
			+ "WHERE isbn LIKE ? OR "
			+ "cim LIKE ? OR "
			+ "oldalszam = ? OR "
			+ "kotesid IN (SELECT kotesid FROM kotes WHERE megnevezes LIKE ?) OR "
			+ "meret LIKE ? OR "
			+ "ar = ? OR "
			+ "kiadoid IN (SELECT kiadoid FROM kiado WHERE nev LIKE ?) OR "
			+ "kiadaseve = ?";*/
	private final String SEARCH_FILM = "SELECT * FROM film WHERE filmcim LIKE ?";
	private final String SEARCH_SONG = "SELECT * FROM zene WHERE zenecim LIKE ?";
	private final String SEARCH_EBOOK = "SELECT * FROM ebook WHERE ebookcim LIKE ?";
	
	private final String GET_AUTHOR_BY_ID = "SELECT nev FROM szerzo WHERE szerzoid = ?";
	private final String GET_AUTHORID_BY_ISBN = "SELECT szerzoid FROM szerzoje WHERE isbn LIKE ?";
	
	private final String GET_PUBLISHER_BY_ID = "SELECT nev FROM kiado WHERE kiadoid = ?";
	
	private final String GET_KOTES_BY_ID = "SELECT megnevezes FROM kotes WHERE kotesID = ?";
	
	private final String GET_BOOK_BY_ID = "SELECT * FROM konyv WHERE isbn = ?";
	private final String GET_FILM_BY_ID = "SELECT * FROM film WHERE filmID = ?";
	private final String GET_SONG_BY_ID = "SELECT * FROM zene WHERE zeneID = ?";
	private final String GET_EBOOK_BY_ID = "SELECT * FROM ebook WHERE ebookID = ?";
	
	private final String GET_SHOPID_FROM_ADDRESS_AND_NAME = "SELECT boltID FROM bolt WHERE cim LIKE ? AND nev LIKE ?";
	private final String GET_BOOKS_FROM_SHOP = "SELECT isbn, darab FROM keszlet WHERE boltID = ?";
	
	private final String GET_USER_CART = "SELECT mibol, mennyit, tipus FROM kosar WHERE felhasznaloid = ?";
	private final String DELETE_PRODUCT_FROM_USER_CART = "DELETE FROM kosar WHERE felhasznaloid = ? AND mibol = ?";
	private final String UPDATE_PRODUCT_IN_USER_CART = "UPDATE mennyit WHERE felhasznaloid = ? AND mibol = ? SET mennyit = ?";
	private final String ADD_PRODUCT_TO_USER_CART = "INSERT INTO kosar(felhasznaloid, mibol, mennyit, tipus) VALUES (?, ?, ?, ?)";
	
	
	private final String GET_BOOKS_BY_PRICE_RANGE = "SELECT * FROM konyv WHERE ar >= ? AND ar <= ?";
	
	private final String GET_SHOPS_OF_BOOK = "SELECT boltID FROM keszlet WHERE ISBN LIKE ?";
	private final String GET_SHOP_ADDRESS_AND_NAME_BY_ID = "SELECT cim, nev FROM bolt WHERE boltID = ?"; 
	
	private final String GET_GENRES_OF_BOOK_ISBN = "SELECT mufajid FROM konyvmufajai WHERE ISBN LIKE ?";
	private final String GET_GENRE_NAME_BY_ID = "SELECT neve FROM mufaj WHERE mufajid = ?";
	
	private final String GET_BOOKS_BY_MONTHLY_TOP_LIST = "SELECT * FROM konyv INNER JOIN havitoplista ON havitoplista.ISBN = konyv.ISBN";
	private final String GET_BOOKS_BY_WEEKLY_TOP_LIST ="SELECT * FROM konyv INNER JOIN hetitoplista ON hetitoplista.ISBN = konyv.ISBN";
	
	public BookshopDAOImplementation() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Oracle JDBC drviver");
			e.printStackTrace();
		}
	}
 
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEbook(Ebook ebook) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSong(Song song) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		boolean success = false;
		
		/*Ide kell a portforwarding meg stb, mint sqldevelopern�l
		�s be kell �ll�tani a USERNAME, PASSWORD Stringeket tesztel�shez. 
		Nem tudtam jobb megold�st, otthon mindenki tesztel�skor be�ll�tja majd git-re felt�lt�skor kit�rlitek. */
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(REGISTER_USER);
			
			pst.setString(1, user.getName());
			pst.setInt(2, user.isTorzsvasarlo() ? 1 : 0);
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			
			success = pst.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return success;
	}

	@Override
	public boolean validateUser(User user) {
		boolean valid = false;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(VALIDATE_USER);

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				valid = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}		
		return valid;
	}
	
	@Override
	public User getUserByEmailAndPassWord(String email, String password){
		User usr = new User();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD);

			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				usr.setId(rs.getInt(1));
				usr.setName(rs.getString(2));
				usr.setTorzsvasarlo(rs.getInt(3) == 1 ? true : false);
				usr.setEmail(rs.getString(4));
				usr.setPassword(rs.getString(5));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}		
		return usr;
	}
	
	@Override
	public boolean validateUserEditProfile(User user, String password){
		boolean valid = false;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(VALIDATE_USER_EDIT_PROFILE);
			
			pst.setString(1, user.getEmail());
			
			ResultSet rs = pst.executeQuery();
			
			if(password.equals(rs.next())){
				valid = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return valid;
	}
	
	@Override
	public boolean updateUserNameEditProfile(User user, String username){
		boolean validate= false;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(UPDATE_USER_NAME_EDIT_PROFILE1 + username + UPDATE_USER_NAME_EDIT_PROFILE2 + user.getEmail());
			
			validate = pst.executeUpdate() == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return validate;
	}
	
	@Override
	public boolean updatePasswordEditProfile(User user, String password){
		boolean validate = false;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(UPDATE_USER_PASSWORD_EDIT_PROFILE1 + password + UPDATE_USER_PASSWORD_EDIT_PROFILE2 + user.getEmail()+ "'");
			
			validate = pst.executeUpdate() == 1;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return validate;
	}

	@Override
	public String[] getAllBindings() {		
		List<String> return_list = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_ALL_BINDIGS);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				return_list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}		
		return return_list.toArray(new String[0]);
	}

	@Override
	public String[] getAllPublishers() {
		List<String> return_list = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_ALL_AUTHORS);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				return_list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}		
		return return_list.toArray(new String[0]);
	}
	
	@Override
	public String[] getAllShops(){
		List<String> return_list = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_ALL_SHOPS);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				return_list.add(rs.getString(1) + "  |  " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}		
		return return_list.toArray(new String[0]);
	}
	
	@Override
	public String[] getAllGenre(){
		List<String> return_list = new ArrayList<String>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_ALL_GENRE);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				return_list.add(rs.getString(1));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
			
			
		return return_list.toArray(new String[0]);
	}

	@Override
	public String getAuthorByID(int id){
		String ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_AUTHOR_BY_ID);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ret = rs.getString(1);	
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	@Override
	public List<Product> searchBookByAttributes(Book book){
		List<Product> ret = new ArrayList<Product>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			//PreparedStatement pst = conn.prepareStatement(SEARCH_BOOK);
			String query = "SELECT * FROM konyv WHERE 1=1";
			
			if(!(book.getIsbn().equals(""))){
				query += " AND isbn LIKE '%" + book.getIsbn() + "%'";
				//pst.setString(1, "%" + book.getIsbn() + "%");
			}
			
			if(!(book.getTitle().equals(""))){
				query += " AND cim LIKE '%" + book.getTitle() + "%'";
				//pst.setString(2, "%" + book.getTitle() + "%");
			}
			
			if(book.getNumOfPages() > 0){
				query += " AND oldalszam = " + book.getNumOfPages();
				//pst.setInt(3, book.getNumOfPages());
			}
			
			if(!(book.getKotesNev().equals(""))){
				query += " AND kotesid IN (SELECT kotesid FROM kotes WHERE megnevezes LIKE '%" + book.getKotesNev() + "%')";
				//pst.setString(4, "%" + book.getKotesNev() + "%");
			}
			
			if(!(book.getSize().equals(""))){
				query += " AND meret LIKE '%" + book.getSize() + "%'";
				//pst.setString(5, "%" + book.getSize() + "%");
			}
			
			if(book.getPrice() > 0){
				query += " AND ar = " + book.getPrice();
				//pst.setInt(6, book.getPrice());
			}
			
			if(!(book.getPublisher().equals(""))){
				query += " AND kiadoid IN (SELECT kiadoid FROM kiado WHERE nev LIKE '%" + book.getPublisher() + "%')";
				//pst.setString(7, "%" + book.getPublisher() + "%");
			}
			
			if(book.getPublishYear() > 0){
				query += " AND kiadaseve = " + book.getPublishYear();
				//pst.setInt(8, book.getPublishYear());
			}
			
			Statement stmt = conn.createStatement();
			
			//System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Book tmp = new Book();
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setNumOfPages(rs.getInt(3));
				tmp.setKotesID(rs.getInt(4));
				tmp.setSize(rs.getString(5));
				tmp.setPrice(rs.getInt(6));
				tmp.setKiadoID(rs.getInt(7));
				tmp.setPublishYear(rs.getInt(8));
				
				tmp.setAuthor(getAuthorByID(getAuthorIDByISBN(tmp.getIsbn())));
				tmp.setKotesNev(getKotesByID(String.valueOf(tmp.getKotesID())));
				tmp.setPublisher(getPublisherNameByID(String.valueOf(tmp.getKiadoID())));
				
				List<String> mufajIDList = getBookGenresByISBN(tmp.getIsbn());
				List<String> mufajNevList = new ArrayList<String>();
				for(int i = 0; i<mufajIDList.size();i++){
					mufajNevList.add(getGenreNameByID(mufajIDList.get(i)));
				}
				tmp.setMufajok(mufajNevList);
				
				ret.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Product> searchFilmByAttributes(Film film) {
		List<Product> ret = new ArrayList<Product>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(SEARCH_FILM);

			pst.setString(1, "%" + film.getTitle() + "%");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Film tmp = new Film();
				tmp.setId(rs.getString(1));
				tmp.setPrice(rs.getInt(2));
				tmp.setTitle(rs.getString(3));
				ret.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public int getAuthorIDByISBN(String isbn) {
		int ret = 0;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_AUTHORID_BY_ISBN);
			pst.setString(1, isbn);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ret = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ret;
	}

	@Override
	public List<Product> searchSongByAttributes(Song song) {
		List<Product> ret = new ArrayList<Product>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(SEARCH_SONG);

			pst.setString(1, "%" + song.getTitle() + "%");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Song tmp = new Song();
				tmp.setId(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				ret.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Product> searchEbookByAttributes(Ebook ebook) {
		List<Product> ret = new ArrayList<Product>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(SEARCH_EBOOK);

			pst.setString(1, "%" + ebook.getTitle() + "%");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Ebook tmp = new Ebook();
				tmp.setId(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				ret.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Book getBookByID(String id){
		Book ret = null;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_BOOK_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ret = new Book();
			ret.setIsbn(rs.getString(1));
			ret.setTitle(rs.getString(2));
			ret.setNumOfPages(rs.getInt(3));
			ret.setKotesID(rs.getInt(4));
			ret.setSize(rs.getString(5));
			ret.setPrice(rs.getInt(6));
			ret.setKiadoID(rs.getInt(7));
			ret.setPublishYear(rs.getInt(8));
			
			ret.setAuthor(getAuthorByID(getAuthorIDByISBN(ret.getIsbn())));
			ret.setPublisher(getPublisherNameByID(String.valueOf(ret.getKiadoID())));
			ret.setKotesNev(getKotesByID(String.valueOf(ret.getKotesID())));
			
			List<String> mufajIDList = getBookGenresByISBN(ret.getIsbn());
			List<String> mufajNevList = new ArrayList<String>();
			for(int i = 0; i<mufajIDList.size();i++){
				mufajNevList.add(getGenreNameByID(mufajIDList.get(i)));
			}
			ret.setMufajok(mufajNevList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public String getPublisherNameByID(String id){
		String ret = null;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_PUBLISHER_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ret = rs.getString(1);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public String getKotesByID(String id){
		String ret = null;
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_KOTES_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			ret = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public Film getFilmByID(String id){
		Film ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_FILM_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ret = new Film();
			ret.setId(rs.getString(1));
			ret.setPrice(rs.getInt(2));
			ret.setTitle(rs.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	@Override
	public boolean DeleteFromUserCart(User user, Product what) {
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(DELETE_PRODUCT_FROM_USER_CART);

			pst.setInt(1, user.getId());
			pst.setString(2, what.getId());
			if(pst.execute())
				return true;		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean ModifyProductInUserCart(User user, Product what,  int tohowmany) {
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(UPDATE_PRODUCT_IN_USER_CART);

			pst.setInt(1, user.getId());
			pst.setString(2, what.getId());
			pst.setInt(3, tohowmany);
			if(pst.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public HashMap<Product, Integer> getUserCart(User user) {
		HashMap<Product, Integer> userCart = new HashMap<Product, Integer>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_USER_CART);

			pst.setInt(1, user.getId());
			
			ResultSet rs = pst.executeQuery();
			//asdasd
			while(rs.next()){
				switch(rs.getString(3)) 
				{
				case "k":
					Book b = getBookByID(rs.getString(1));
					userCart.put(b, rs.getInt(2));
					break;
				case "f":
					Film f = getFilmByID(rs.getString(1));
					userCart.put(f, rs.getInt(2));
					break;
				case "e":
					Ebook e = getEbookByID(rs.getString(1));
					userCart.put(e, rs.getInt(2));
					break;
				case "z":
					Song s = getSongByID(rs.getString(1));
					userCart.put(s, rs.getInt(2));
					break;
				default:
					System.out.println("ERROR: default reached in getUserCart!");
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCart;
	}

	@Override
	public Song getSongByID(String id) {
		Song ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_SONG_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ret = new Song();
			ret.setId(rs.getString(1));
			ret.setPrice(rs.getInt(2));
			ret.setTitle(rs.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public Ebook getEbookByID(String id) {
		Ebook ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_EBOOK_BY_ID);
			
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			ret = new Ebook();
			ret.setId(rs.getString(1));
			ret.setPrice(rs.getInt(2));
			ret.setTitle(rs.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public String getShopIDFromAddressAndName(String shopAddress, String shopName) {
		String ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_SHOPID_FROM_ADDRESS_AND_NAME);

			pst.setString(1, shopAddress);
			pst.setString(2, shopName);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			ret = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public HashMap<Book, Integer> getBooksFromShop(String shopID) {
		HashMap<Book, Integer> keszlet_konyv_db = new HashMap<Book, Integer>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_BOOKS_FROM_SHOP);

			pst.setInt(1, Integer.parseInt(shopID));
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Book book = getBookByID(rs.getString(1));
				int db = rs.getInt(2);
				keszlet_konyv_db.put(book, db);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keszlet_konyv_db;
	}

	@Override
	public List<Book> getBooksByPriceRange(int minprice, int maxprice) {
		List<Book> ret = new ArrayList<Book>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_BOOKS_BY_PRICE_RANGE);

			pst.setInt(1, minprice);
			pst.setInt(2, maxprice);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Book tmp = new Book();
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setNumOfPages(rs.getInt(3));
				tmp.setKotesID(rs.getInt(4));
				tmp.setSize(rs.getString(5));
				tmp.setPrice(rs.getInt(6));
				tmp.setKiadoID(rs.getInt(7));
				tmp.setPublishYear(rs.getInt(8));
				
				tmp.setAuthor(getAuthorByID(getAuthorIDByISBN(tmp.getIsbn())));
				tmp.setKotesNev(getKotesByID(String.valueOf(tmp.getKotesID())));
				tmp.setPublisher(getPublisherNameByID(String.valueOf(tmp.getKiadoID())));
				
				ret.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<Book> getBooksFromMonthlyTopList(){
		List<Book> ret = new ArrayList<Book>();
		int i = 10;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_BOOKS_BY_MONTHLY_TOP_LIST);
		
			ResultSet rs = pst.executeQuery();
			while(rs.next() || i > 0){
				Book tmp = new Book();
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setNumOfPages(rs.getInt(3));
				tmp.setKotesID(rs.getInt(4));
				tmp.setSize(rs.getString(5));
				tmp.setPrice(rs.getInt(6));
				tmp.setKiadoID(rs.getInt(7));
				tmp.setPublishYear(rs.getInt(8));
				
				tmp.setAuthor(getAuthorByID(getAuthorIDByISBN(tmp.getIsbn())));
				tmp.setKotesNev(getKotesByID(String.valueOf(tmp.getKotesID())));
				tmp.setPublisher(getPublisherNameByID(String.valueOf(tmp.getKiadoID())));
				
				ret.add(tmp);

				i--;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public List<Book> getBooksFromWeeklyTopList(){
		List<Book> ret = new ArrayList<Book>();
		int i = 2;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			
			PreparedStatement pst = conn.prepareStatement(GET_BOOKS_BY_WEEKLY_TOP_LIST);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Book tmp = new Book();
				
				tmp.setIsbn(rs.getString(1));
				tmp.setTitle(rs.getString(2));		
				tmp.setNumOfPages(rs.getInt(3));
				tmp.setKotesID(rs.getInt(4));
				tmp.setSize(rs.getString(5));
				tmp.setPrice(rs.getInt(6));
				tmp.setKiadoID(rs.getInt(7));
				tmp.setPublishYear(rs.getInt(8));
				
				tmp.setAuthor(getAuthorByID(getAuthorIDByISBN(tmp.getIsbn())));
				tmp.setKotesNev(getKotesByID(String.valueOf(tmp.getKotesID())));
				tmp.setPublisher(getPublisherNameByID(String.valueOf(tmp.getKiadoID())));
				
				ret.add(tmp);

				i--;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public List<String> getShopOfBook(Book book) {
		List<String> ret = new ArrayList<String>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_SHOPS_OF_BOOK);

			pst.setString(1, book.getIsbn());
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				ret.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public String getShopAddressAndNameByID(int boltID) {
		String ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_SHOP_ADDRESS_AND_NAME_BY_ID);

			pst.setInt(1, boltID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ret = rs.getString(1) + " | " + rs.getString(2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<String> getBookGenresByISBN(String ISBN) {
		List<String> ret = new ArrayList<String>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_GENRES_OF_BOOK_ISBN);

			pst.setString(1, ISBN);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				ret.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public String getGenreNameByID(String id) {
		String ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_GENRE_NAME_BY_ID);

			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				ret = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public boolean AddProductToUsercart(User user, Product what, int howmany)
	{
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(ADD_PRODUCT_TO_USER_CART);

			pst.setInt(1, user.getId());
			pst.setString(2, what.getId());
			pst.setInt(3, howmany);
			if(what instanceof Book)
				pst.setString(4, "k");
			else if(what instanceof Ebook)
				pst.setString(4, "e");
			else if(what instanceof Film)
				pst.setString(4, "f");
			else if(what instanceof Song)
				pst.setString(4, "z");
			
			boolean result = pst.execute();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}


