package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager {
	private int size;
	private Book[] books;  // is has dependency 
	// <----------
	// 18 static 생성자
	//private static final int MAX_SIZE=100;  // 초기화 하면 초기화 못한다.
	private static final int MAX_SIZE;
	static {
		MAX_SIZE=100;  //초기 안된  static final도 초기화 할정도로 가장 빠르다. 
	}
	//-->  19 single tone : 객체 생성 한번만 
	// 한곳으로 집중 시킬 수 있다.
	// static 과 private 생성자를 이용해서 만든다. 
	private static BookManager manager=new BookManager();
	
	private BookManager() {
		books=new Book[MAX_SIZE];
	}
	public static BookManager getInstance() {
		return manager;
	}
	
	// 14 final 
	// 상속금지 public final class String
	// 오버라이딩 금지 public Class getClass
	// 상수 Math.PI, Math.E Integer.MAX_VALUE
	// 13 static 
	// 객체 생성없이 사용하기 위한 용도
	// 설계도<---->건물   static --XXX--> non static 
	// non static  ---->  static 
	
	public Book seachByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn.trim())) {
				return books[i];
			}
		}
		return null;
	}
	public void add(Book book) {
		Book b= seachByIsbn(book.getIsbn());
		if(b==null) {
			books[size++]=book;
		}
	}
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn.trim())) {
				books[i]=books[--size];
				//books[size-1]=null;
				return ;  // void일 때 끝  => return
			}
		}
		/*  여러개
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn.trim())) {
				books[i]=books[--size];
				i--;
			}
		}
		 */
	}
	public Book[] getList() {
		return Arrays.copyOf(books, size);
	}
	public Book[] seachByTitle(String title) {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(books[i].getTitle().contains(title)) {
				Book temp=books[i];
				books[i]=books[cnt];
				books[cnt]=temp;
				cnt++;
			}
		}
		return Arrays.copyOf(books, cnt);
	}
	public Magazine[] getMagazines2() {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
		}
		Magazine[] magas=new Magazine[cnt];
		int t=0;
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				magas[t++]=(Magazine)books[i];
			}
		}
		return magas;
	}
	public Magazine[] getMagazines() {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if((books[i] instanceof Magazine)) {
				Book temp=books[i];
				books[i]=books[cnt];
				books[cnt]=temp;
				cnt++;
			}
		}
		// 모아서 타입을 변환시켜서 
		return Arrays.copyOf(books, cnt, Magazine[].class);
	}
	
	public Book[] getBooks() {
		int cnt=0;
		for (int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) {
				Book temp=books[i];
				books[i]=books[cnt];
				books[cnt]=temp;
				cnt++;
			}
		}
		return Arrays.copyOf(books, cnt);
	}
	
	
	
	
	
	
	
	
}
