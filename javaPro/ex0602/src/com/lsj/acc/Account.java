package com.lsj.acc;

public class Account {
	String accountNum;
	String owner;
	int balance;
	
	public Account(String accountNum, String owner, int balance) {
		this.accountNum = accountNum;
		this.owner = owner;
		this.balance = balance;
	}
	
	void deposit(int amount) {
		this.balance += amount;
		System.out.println(amount + "원 입금 완료.");
	}
	
	void withdraw(int amount) {
		if (amount > this.balance) {
			System.out.println("잔액 부족");
			return;
		}
		this.balance -= amount;
		System.out.println(amount + "원 출금 완료.");
	}
	
	void showInfo() {
		System.out.println("계좌 번호 : " + accountNum);
		System.out.println("예금주 : " + owner);
		System.out.println("잔액 : " + balance);
	}
}
