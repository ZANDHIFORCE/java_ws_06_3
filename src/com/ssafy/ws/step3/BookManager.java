package com.ssafy.ws.step3;

import java.util.Arrays;


public class BookManager {
	private static final int MAX_SIZE;
	private int size;
	private Book[] books;
	
	static {
		MAX_SIZE = 100;
	}
	
	private static BookManager bM = new BookManager();
	
	private BookManager() {
		books=new Book[MAX_SIZE];
	}
	public static BookManager getInstance() {
		return bM;
	}
	public Book searchByIsbn(String isbn) {
		Book b=null;
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn))
				b = books[i];
		}
		return b;
	}
	public Book[] searchByTitle(String title) {
		Book[] b = new Book[MAX_SIZE];
		int len = 0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title))
			b[len++] = books[i];
		}
		return Arrays.copyOf(b,len);
	}
	public void add(Book book) {
		if(size<MAX_SIZE && searchByIsbn(book.getIsbn())==null)
			books[size++] = book;
	}
	public void remove(String isbn) {
		aa:for(int i=size-1;i>=0;i--) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[--size];
				books[size] = null;
				break aa;
			}
		}
	}
	public Book[] getBooks() {
		Book[] b = new Book[MAX_SIZE];
		int len = 0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				b[len++]=books[i];
			}
		}
		return Arrays.copyOf(b, len);
	}
	public Book[] getAll() {
		return Arrays.copyOf(books,size);
	}
	public Book[] getMagazines() {
		Book[] b = new Book[MAX_SIZE];
		int len = 0;
		for(int i=0;i<size;i++) {
			if((books[i] instanceof Magazine)) {
				b[len++]=books[i];
			}
		}
		return Arrays.copyOf(b, len);
	}
	public int getTotalPrice() {
		int total=0;
		for(int i=0;i<size;i++) {
			total+=books[i].getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return getTotalPrice()/(double)size;
	}
	
	
}