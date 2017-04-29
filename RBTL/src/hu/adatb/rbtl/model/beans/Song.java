package hu.adatb.rbtl.model.beans;

public class Song extends Product{

	private char[] id, title;
	
	public Song(char[] id, char[] title){
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
