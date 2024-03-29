package hu.adatb.rbtl.model.beans;

import java.util.List;

/**
 * Book bean, which represents a book from the database
 *
 */
public class Book extends Product{

	private String size, kotesNev, publisher, author;
	private int numOfPages, publishYear, kotesID, kiadoID;
	private List<String> mufajok;
	
	public Book() {
		
	}
	
	/**
	 * 
	 * @param isbn - ISBN number of the book
	 * @param title - Title of the book
	 */
	public Book(String isbn, String title){
		this.id = isbn;
		this.title = title;
	}

	public Book(String isbn) {
		this.id = isbn;
		this.title = "TODO";
	}

	public String getIsbn() {
		return id;
	}

	public void setIsbn(String isbn) {
		this.id = isbn;
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

	public List<String> getMufajok() {
		return mufajok;
	}

	public void setMufajok(List<String> mufajok) {
		this.mufajok = mufajok;
	}
	
}
