package hu.adatb.rbtl.model.beans;

public class Film extends Product{

	private char[] id, title;
	
	public Film(char[] id, char[] title){
		this.id = id;
		this.title = title;
	}

	public char[] getId() {
		return id;
	}

	public void setId(char[] id) {
		this.id = id;
	}

	public char[] getTitle() {
		return title;
	}

	public void setTitle(char[] title) {
		this.title = title;
	}
}
