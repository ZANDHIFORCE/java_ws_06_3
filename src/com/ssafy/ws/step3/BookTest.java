package com.ssafy.ws.step3;

import java.util.Date;
import java.util.Scanner;

public class BookTest {

	static BookManager bmBookManager=BookManager.getInstance();
	
	public static void main(String[] args) {
		
		while(true) {
			int c=init();
			switch (c) {
				case 1:
					add();
					break;
				case 3:
					bookList();
					break;
				case 9:
					endBookManager();
					break;
				default:
					break;
			}
			
		}
		
		
		//Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        //Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
        //Book b3 = new Book("35356", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델2");
        //Book b4 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);

	}

	private static void bookList() {
		System.out.println("SSAFY BookManager입니다. 책 목록입니다. ");
		System.out.println("----------------------->>");
		for (Book b : bmBookManager.getList()) {
			System.out.println(b);
		}
		System.out.println("<<--------------"+new Date());
	}

	private static void add() {
		System.out.println("SSAFY BookManager입니다. 책을 추가합니다. ");
		Scanner scann=new Scanner(System.in);
		System.out.println("isbn을 입력하세요");
		String isbn=scann.nextLine();
		System.out.println("titile을 입력하세요");
		String title=scann.nextLine();
		System.out.println("author을 입력하세요");
		String author=scann.nextLine();
		System.out.println("publisher을 입력하세요");
		String publisher=scann.nextLine();
		System.out.println("price을 입력하세요");
		String price=scann.nextLine();
		System.out.println("desc을 입력하세요");
		String desc=scann.nextLine();
		bmBookManager.add(new Book(isbn, title, author, publisher,
				Integer.parseInt(price.trim()) , desc));
		System.out.println("SSAFY BookManager입니다. 책을 추가하였습니다. ");
	}

	private static void endBookManager() {
		System.out.println("SSAFY BookManager입니다. 안녕히 가십시오. ");
		System.exit(0);
	}

	private static int init() {
		System.out.println("안녕하세요. SSAFY BookManager입니다. ");
		System.out.println("아래 보기에서 원하는 번호를 입력하세요. ");
		System.out.println("1. 책입력 ");
		System.out.println("2. 잡지입력 ");
		System.out.println("3. 모든 책 목록보기");
		System.out.println("4. 책만 보기");
		System.out.println("5. 잡지만 보기");
		System.out.println("9. 끝");
		Scanner scann=new Scanner(System.in);
		System.out.println("<====번호를 입력하세요====>");
		return scann.nextInt();
	}

	
}
