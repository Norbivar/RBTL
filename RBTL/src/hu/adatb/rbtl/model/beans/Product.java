package hu.adatb.rbtl.model.beans;

/**
 * This class is a "wrapper" for all the products in our application.
 *
 */
public abstract class Product {
	protected String id, title;

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

	//public abstract JPanel displayInList();	
}
