package com.lsj.operators;

import java.util.Scanner;

public class Ex2_oper3 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		
		System.out.println("비교연산자 \n ----------");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("x: ");
		x = sc.nextInt();
		System.out.print("y: ");	
		y = sc.nextInt();
		
		System.out.println(x + " == " + y + ": " + (x == y));
		System.out.println(x + " != " + y + ": " + (x != y));
		System.out.println(x + " >= " + y + ": " + (x >= y));
		System.out.println(x + " > " + y + ": " + (x > y));
		System.out.println(x + " <= " + y + ": " + (x <= y));
		System.out.println(x + " < " + y + ": " + (x < y));
	}

}
