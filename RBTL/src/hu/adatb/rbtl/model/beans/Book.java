package hu.adatb.rbtl.model.beans;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.view.Labels;

public class Book extends Product{

	private String isbn, size, title, kotesNev, publisher, author;
	private int numOfPages, price, publishYear, kotesID, kiadoID;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public JPanel displayInList(){
		JPanel ret, icon_panel, labels_panel, values_panel, button_panel;
		
		JLabel book_icon, label_title, label_author, label_publisher, label_price, label_publishYear;
		JLabel title, author, publisher, price, publishYear;
		JButton detailsButton;
		
		ret = new JPanel();
		ret.setLayout(new FlowLayout());
		
		/* -----------------BOOK ICON PANEL-------------  */
		icon_panel = new JPanel();
		book_icon = new JLabel(new ImageIcon(this.getClass().getResource("/images/book_icon_smaller.png")));
		icon_panel.add(book_icon);
		/* ---------------------------------------------- */
		
		/* ------------BOOK LABELS PANEL --------------- */
		labels_panel = new JPanel();
		labels_panel.setLayout(new GridLayout(4, 1));
		
		label_title = new JLabel(Labels.PRODUCT_RESULT_TITLE);
		label_author = new JLabel(Labels.PRODUCT_RESULT_AUTHOR);
		label_publisher = new JLabel(Labels.PRODUCT_RESULT_PUBLISHER);
		label_price = new JLabel(Labels.PRODUCT_RESULT_PRICE);
		
		labels_panel.add(label_title);		
		labels_panel.add(label_author);		
		labels_panel.add(label_publisher);		
		labels_panel.add(label_price);
		/* -------------------------------------------------- */
		
		/* ---------------------------- VALUES PANEL -------------------- */
		values_panel = new JPanel();
		values_panel.setLayout(new GridLayout(4, 1));
		
		title = new JLabel(this.title);
		author = new JLabel(this.author);
		publisher = new JLabel(this.publisher);
		price = new JLabel(String.valueOf(this.price));
		
		values_panel.add(title);
		values_panel.add(author);
		values_panel.add(publisher);
		values_panel.add(price);		
		/* ----------------------------------------------------- */
		
		/* --------------- BUTTON PANEL -------------------*/
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(3, 1));
		
		detailsButton = new JButton(Labels.PRODUCT_DETAILS_BUTTON);
		button_panel.add(new JLabel());	//üres hely az elsõ sorban
		button_panel.add(detailsButton);
		/* ------------------------------------------------ */
		
		ret.add(icon_panel);
		ret.add(labels_panel);
		ret.add(values_panel);
		ret.add(button_panel);
		
		return ret;
	}
	
	/**
	 * 
	 * @param isbn - ISBN number of the book
	 * @param title - Title of the book
	 */
	public Book(String isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getKotesNev() {
		return kotesNev;
	}

	public void setKotesNev(String kotesNev) {
		this.kotesNev = kotesNev;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getKotesID() {
		return kotesID;
	}

	public void setKotesID(int kotesID) {
		this.kotesID = kotesID;
	}

	public int getKiadoID() {
		return kiadoID;
	}

	public void setKiadoID(int kiadoID) {
		this.kiadoID = kiadoID;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
