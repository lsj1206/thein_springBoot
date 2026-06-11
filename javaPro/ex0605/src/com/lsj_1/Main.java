package com.lsj_1;

public class Main {

	public static void main(String[] args) {
		
		Level myVar = Level.Medium;
		System.out.println(myVar);
		
		switch (myVar) {
		case Low: 
			System.out.println("Low 커피 로스팅 주문");
			break;
		case Medium: 
			System.out.println("Medium 커피 로스팅 주문");
			break;
		case High: 
			System.out.println("High 커피 로스팅 주문");
			break;
		}
		System.out.println("====================");		
		for(Level v : Level.values()) {
			System.out.println(v);
		}
		System.out.println("== Lv.2 ============");
		
		Level2 myVar2 = Level2.MEDIUM;
		
		System.out.println(myVar2.getDescription());
	}
}
