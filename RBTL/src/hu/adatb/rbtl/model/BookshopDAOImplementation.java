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
	//TODO ezt majd �t kell �rni, hogy a felhasznaloID-t ne sz�rja be fixen 1 �rt�kkel, hanem trigger lesz r� de tesztel�shez j�
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
		
		/*Ide kell a portforwarding meg stb, mint sqldevelopern�l
		�s be kell �ll�tani a USERNAME, PASSWORD Stringeket tesztel�shez. 
		Nem tudtam jobb megold�st, otthon mindenki tesztel�skor be�ll�tja majd git-re felt�lt�skor kit�rlitek. */
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
