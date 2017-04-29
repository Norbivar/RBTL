package hu.adatb.rbtl.model.beans;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Book extends Product{

	private String isbn, size, title, kotesNev, publisher;
	private int numOfPages, price, publishYear, kotesID, kiadoID;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public JPanel display(){
		JPanel ret = new JPanel();
		JLabel label_isbn, label_title, label_kotesNev, label_publisher, label_numOfPages, label_price, label_publishYear;
		JLabel isbn, title, kotesNev, publisher, numOfPages, price, publishYear;
		
		ret.setLayout(new BorderLayout());
		isbn = new JLabel(this.isbn);
		ret.add(isbn, BorderLayout.CENTER);
		
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
}
