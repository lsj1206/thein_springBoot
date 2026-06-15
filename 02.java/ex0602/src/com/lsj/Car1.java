package com.lsj;

public class Car1 {
	int carYear;
	String model;
	
	
	public Car1(String model) {
		this(2020, model);
	}
	
	public Car1(int carYear, String model) {
		this.carYear = carYear;
		this.model = model;
	}
	
	public void printInfo() {
		System.out.println(carYear + " " + model);
	}
}
