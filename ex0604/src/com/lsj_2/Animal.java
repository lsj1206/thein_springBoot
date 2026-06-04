package com.lsj_2;

abstract class Animal {
	protected static String className = "=== 동물 클래스 ===";
	protected String animalName = "동물";
	protected String animalType = "품종";
	protected String animalSound = "울음소리";
	protected abstract void animalEat();
	protected abstract void animalSleep();
}
