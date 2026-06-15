package com.lsj_abst;

public class MyMain2 {

	public static void main(String[] args) {
		
		Pig pig1 = new Pig();
		System.out.println(pig1.animalName);
		System.out.println("=========================");
		Cat cat1 = new Cat();
		System.out.println(cat1.animalName);
		System.out.println(cat1.animalType);
		System.out.println(cat1.animalSound);
		System.out.println("=========================");
		Dog dog1 = new Dog();
		System.out.println(dog1.animalName);
		dog1.animalEat();
		dog1.animalSleep();
		System.out.println("=========================");
		Bird bird1 = new Bird();
		System.out.println(bird1.animalName);
		bird1.showInfo();
	}
}
