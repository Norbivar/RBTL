package hu.adatb.rbtl.model.beans;

import javax.swing.JPanel;

public class Ebook extends Product{

	private char[] id, title;
	
	public Ebook(char[] id, char[] title){
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

	@Override
	public JPanel display() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
