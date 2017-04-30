package hu.adatb.rbtl.model.beans;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.view.Labels;

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

	public JPanel displayInList() {
		JPanel p;
		JLabel film_icon, label_title, title;
		JButton detailsButton;
		
		p = new JPanel();
		p.setLayout(new FlowLayout());
		
		film_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/film_icon_smaller.png")));
		label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
		title = new JLabel(this.title);
		detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
		
		p.add(film_icon);
		p.add(label_title);
		p.add(title);
		p.add(detailsButton);
		
		return p;
	}
}
