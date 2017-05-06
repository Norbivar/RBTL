package hu.adatb.rbtl.model.beans;

/**
 * Song bean, which represents a song from the database
 *
 */
public class Song extends Product{
	
	public Song(String id, String title){
		this.id = id;
		this.title = title;
	}

	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}	

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
}
