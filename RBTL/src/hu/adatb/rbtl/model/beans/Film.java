package hu.adatb.rbtl.model.beans;

/**
 * Film bean, which represents a film from the database
 *
 */
public class Film extends Product{

	public Film(String id, String title){
		this.id = id;
		this.title = title;
	}

	public Film() {
		// TODO Auto-generated constructor stub
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
