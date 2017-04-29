package hu.adatb.rbtl.model.beans;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Film extends Product{

	private String id, title;
	
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

	@Override
	public JPanel display() {
		JPanel p = new JPanel();
		JLabel label_title, title;
		
		p.setLayout(new BorderLayout());
		title = new JLabel(this.title);
		p.add(title, BorderLayout.CENTER);
		return p;
	}
}
