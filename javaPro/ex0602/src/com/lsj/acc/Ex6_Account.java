package com.lsj.acc;

public class Ex6_Account {

	public static void main(String[] args) {
		Account acc = new Account(
				"100-200", "홍길동", 100000);
	
		acc.deposit(50000);
		acc.withdraw(200000);
		acc.showInfo();
	};
}
