package com.lsj.operators;

public class Ex2_oper5 {

	public static void main(String[] args) {
		int x = 5;
		int y = 3;
		System.out.println("비트연산자\n----------");
		
		System.out.println("5의 비트는: 0000 0101");
		System.out.println("3의 비트는: 0000 0011");

		
		System.out.println("[ 두 비트가 둘 다 1이여야 1 ]");
		System.out.println("0000 0101 & 0000 0011 = 0000 0001 (1): " + (x & y));
		
		System.out.println("[ 두 비트중 하나만 1이여도 1 ]");
		System.out.println("0000 0101 | 0000 0011 = 0000 0111 (7): " + (x | y));
		
		System.out.println("[ 두 비트가 다른것만 1 ]");
		System.out.println("0000 0101 ^ 0000 0011 = 0000 0110 (6): " + (x ^ y));
		
		System.out.println("[ 5의 비트를 0->1로, 1->0으로 ]");
		System.out.println("0000 0101 ~ 1111 1010 (-6): " + (~x));
		
		System.out.println("[ 5의 비트를 3만큼 << 이동 ]");
		System.out.println("0000 0101 << 3 : 0010 1000 (40): " + (x << y));
		
		System.out.println("[ 5의 비트를 3만큼 >> 이동 ]");
		System.out.println("0000 0101 >> 3 : 0000 0000 (0): " + (x >> y));
		

	}

}
