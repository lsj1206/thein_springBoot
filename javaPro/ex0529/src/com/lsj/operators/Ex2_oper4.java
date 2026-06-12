package com.lsj.operators;

import java.util.Scanner;

public class Ex2_oper4 {

	public static void main(String[] args) {
		int n = 0;
		int m = 0;
		
		System.out.println("논리연산자 \n ----------");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("n: ");
		n = sc.nextInt();
		
		if (!(n < 0))
			System.out.println("!(n < 0)이 true");
		else
			System.out.println("(n < 0) 이 true");
		
		m = -1;
		System.out.println("'m'은 -1 입니다.");
		
		if ((n > 0) || (m > 0)) {
			System.out.println("(n < 0) || (m < 0) 이 true");
		}
		else
			System.out.println("(n < 0) || (m < 0) 이 false");
		
		if ((n < 0) && (m < 0)) {
			System.out.println("(n < 0) && (m < 0) 이 true");
		}
		else
			System.out.println("(n < 0) && (m < 0) 이 false");
			
		System.out.print("m의 값을 변경해 보세요: ");
		m = sc.nextInt();
		
		if ((n < 0) && (m < 0)) {
			System.out.println("(n < 0) && (m < 0) 이 true");
		}
		else
			System.out.println("(n < 0) && (m < 0) 이 false");

	}

}
