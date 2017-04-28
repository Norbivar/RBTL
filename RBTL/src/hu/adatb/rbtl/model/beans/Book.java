package hu.adatb.rbtl.model.beans;

public class Book {

	private char[] isbn, size;
	private String title;
	private int numOfPages, kotesID, price, publisherID, publishYear;
	
	public Book(char[] isbn, String title){
		this.isbn = isbn;
		size = new char[7];
		this.title = title;
	}

	public char[] getIsbn() {
		return isbn;
	}

	public void setIsbn(char[] isbn) {
		this.isbn = isbn;
	}

	public char[] getSize() {
		return size;
	}

	public void setSize(char[] size) {
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

	public int getKotesID() {
		return kotesID;
	}

	public void setKotesID(int kotesID) {
		this.kotesID = kotesID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPublisherID() {
		return publisherID;
	}

	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
}
