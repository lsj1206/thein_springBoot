package com.lsj;

class Account {
	String accountNum;
	String owner;
	long balance;
	
	public Account(String accountNum, String owner, int balance) {
		this.accountNum = accountNum;
		this.owner = owner;
		this.balance = balance;
	}
	
	String deposit(int amount) {
		this.balance += amount;
		System.out.println(amount + "원 입금 완료.");
		return ("현재 잔액: " + this.balance + "원.");
	}
	
	String withdraw(int amount) {
		if (amount > this.balance) {
			System.out.println("[잔액 부족]");
			return ("현재 잔액: " + this.balance + "원.");
		}
		this.balance -= amount;
		System.out.println(amount + "원 출금 완료.");
		return ("현재 잔액: " + this.balance + "원.");
	}
	
	void showInfo() {
		System.out.println("==========");
		System.out.println("계좌 번호 : " + accountNum);
		System.out.println("예금주 : " + owner);
		System.out.println("잔액 : " + balance);
		System.out.println("==========");
	}
}
