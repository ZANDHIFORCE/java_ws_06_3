package com.ssafy.ws.step3;

import com.ssafy.ws.step3.Book;
import com.ssafy.ws.step3.Magazine;

public class Test1 {

	public static void main(String[] args) {
		//16
		Object obj=new Object();
		Object str=new String();
		System.out.println(obj instanceof Object);
		System.out.println(obj instanceof String);//false
		System.out.println(str instanceof Object);
		System.out.println(str instanceof String);
		
		// 17 instanceof  힙에 그 타입이 있는가를 확인
		Book b=new Book();
		Book m=new Magazine();
		System.out.println(b instanceof Book);
		System.out.println(b instanceof Magazine);//false
		System.out.println(m instanceof Book);
		System.out.println(m instanceof Magazine);
		
		
		
	}

}
