package com.lsj_abst;

abstract class Animal {
	protected static String className = "=== 동물 클래스 ===";
	protected String animalName = "동물";
	protected String animalType = "품종";
	protected String animalSound = "울음소리";
	protected abstract void animalEat();
	protected abstract void animalSleep();
	
	protected void showInfo() {
		System.out.println("=========================");
		System.out.println("이름: " + this.animalName);
		System.out.println("품종: " + this.animalType);
		System.out.println("소리: " + this.animalSound);
		System.out.print("식성: ");
		this.animalEat();
		System.out.print("수면: ");
		this.animalSleep();
		System.out.println("=========================");
	}
}
