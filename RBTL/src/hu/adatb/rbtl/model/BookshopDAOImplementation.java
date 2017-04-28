package hu.adatb.rbtl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Ebook;
import hu.adatb.rbtl.model.beans.Film;
import hu.adatb.rbtl.model.beans.Song;
import hu.adatb.rbtl.model.beans.User;

public class BookshopDAOImplementation implements BookshopDAO{

	private final String USERNAME = "";
	private final String PASSWORD = "";
	//TODO ezt majd át kell írni, hogy a felhasznaloID-t ne szúrja be fixen 1 értékkel, hanem trigger lesz rá de teszteléshez jó
	private final String REGISTER_USER = "INSERT INTO felhasznalo (felhasznaloID, nev, torzsvasarlo, email, jelszo) VALUES (1, ?, ?, ?, ?)";
	
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
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:4000:kabinet", USERNAME, PASSWORD)){
			PreparedStatement pst = conn.prepareStatement(REGISTER_USER);
			
			pst.setString(1, user.getName().toString());
			pst.setInt(2, user.isTorzsvasarlo() ? 1 : 0);
			pst.setString(3, user.getEmail().toString());
			pst.setString(4, user.getPassword().toString());
			
			success = pst.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return success;
	}

	@Override
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
