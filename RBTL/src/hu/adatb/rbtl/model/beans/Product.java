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
	
    @Override
    public int hashCode() {
        return id.hashCode(); // I don't know what this does but found it on internet
    }

    @Override
    public boolean equals(Object obj) {
    	if(this == (Product) obj) { // dunno either
    		return true;
    	}
    	return false;
    }
}
