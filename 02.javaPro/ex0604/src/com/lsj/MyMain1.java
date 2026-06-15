package com.lsj;

public class MyMain1 {

	public static void main(String[] args) {
		Account acc = new Account(
				"100-200", "홍길동", 100000);
	
		System.out.println(acc.deposit(50000));
		System.out.println(acc.withdraw(200000));
		acc.showInfo();
	};
}
