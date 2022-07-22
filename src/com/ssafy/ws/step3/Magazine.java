package com.ssafy.ws.step3;

public class Magazine extends Book {
	
	private int year;
	private int month;
	public Magazine() {
		this("","","","",0,"",0,0);
	}
	public Magazine(String isbn, String title, String author, 
			String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine ["+ super.toString() +"year=" + year + ", month=" + month + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	
}
