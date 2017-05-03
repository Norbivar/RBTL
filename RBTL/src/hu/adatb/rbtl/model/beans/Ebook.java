package hu.adatb.rbtl.model.beans;

import javax.swing.JPanel;

public class Ebook extends Product{

	public Ebook(String id, String title){
		this.id = id;
		this.title = title;
	}

	public Ebook() {
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

	public JPanel displayInList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
