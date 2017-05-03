package hu.adatb.rbtl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Product;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

public class BookshopDAOImplementation implements BookshopDAO{
	private final String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:4000:kabinet";
	
	
	private final String USERNAME = "";
	private final String PASSWORD = "";
	
	/* Ide trigger kell a beszúráshoz, hogy az id jó legyen. Pl ez jó:
	  	CREATE OR REPLACE TRIGGER db_ujfelhasznalo
		BEFORE INSERT ON felhasznalo
		FOR EACH ROW
		BEGIN
  			:NEW.FELHASZNALOID := FELHASZNALO_SEQ.nextval;
		END;
	*/
	private final String REGISTER_USER = "INSERT INTO felhasznalo (nev, torzsvasarlo, email, jelszo) VALUES (?, ?, ?, ?)";
	private final String GET_ALL_BINDIGS = "SELECT megnevezes FROM kotes";
	private final String GET_ALL_AUTHORS = "SELECT nev FROM szerzo";
	private final String VALIDATE_USER = "SELECT * FROM felhasznalo WHERE email LIKE ? AND jelszo LIKE ?";
	private final String SEARCH_BOOK = "SELECT * FROM konyv "
			+ "WHERE isbn LIKE ? OR "
			+ "cim LIKE ? OR "
			+ "oldalszam = ? OR "
			+ "kotesid IN (SELECT kotesid FROM kotes WHERE megnevezes LIKE ?) OR "
			+ "meret LIKE ? OR "
			+ "ar = ? OR "
			+ "kiadoid IN (SELECT kiadoid FROM kiado WHERE nev LIKE ?) OR "
			+ "kiadaseve = ?";
	private final String SEARCH_FILM = "SELECT * FROM film WHERE filmcim LIKE ?";
	private final String GET_AUTHOR_BY_ID = "SELECT nev FROM szerzo WHERE szerzoid = ?";
	private final String GET_AUTHORID_BY_ISBN = "SELECT szerzoid FROM szerzoje WHERE isbn LIKE ?";
	private final String GET_PUBLISHER_BY_ID = "SELECT kiadoid FROM kiado WHERE nev LIKE ?";
	private final String SEARCH_SONG = "SELECT * FROM zene WHERE zenecim LIKE ?";
	private final String SEARCH_EBOOK = "SELECT * FROM ebook WHERE ebookcim LIKE ?";
	//VN
	private final String GET_USER_CART = "SELECT * FROM kosar WHERE felhasznaloid = ?";
	
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
		//TODO Trigger on inserting a new user, for setting the userID
		
		/*Ide kell a portforwarding meg stb, mint sqldevelopernél
		És be kell állítani a USERNAME, PASSWORD Stringeket teszteléshez. 
		Nem tudtam jobb megoldást, otthon mindenki teszteléskor beállítja majd git-re feltöltéskor kitörlitek. */
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

	public String getAuthorByID(int id){
		String ret = null;
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(GET_AUTHOR_BY_ID);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			ret = rs.getString(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public List<Product> searchBookByAttributes(Book book){
		List<Product> ret = new ArrayList<Product>();
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(SEARCH_BOOK);

			pst.setString(1, "%" + book.getIsbn() + "%");
			pst.setString(2, "%" + book.getTitle() + "%");
			pst.setInt(3, book.getNumOfPages());
			pst.setString(4, "%" + book.getKotesNev() + "%");
			pst.setString(5, "%" + book.getSize() + "%");
			pst.setInt(6, book.getPrice());
			pst.setString(7, "%" + book.getPublisher() + "%");
			pst.setInt(8, book.getPublishYear());
			
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
				tmp.setTitle(rs.getString(2));
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
			rs.next();
			ret = rs.getInt(1);			
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
	public List<Product> getUserCart(User user) {
		List<Product> ret = new ArrayList<Product>();
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(SEARCH_EBOOK);

			pst.setInt(1, user.getId());
			
			ResultSet rs = pst.executeQuery();
			/*
			 * kosar.tipus:
			 * k - könyv
			 * f - film
			 * e - ebook
			 * f - film
			 */
			while(rs.next())
			{
				if(rs.getString(4).equals("k"))
				{
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
