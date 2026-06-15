package com.lsj_abst;

class Bird extends Animal {
	
	Bird() {
		this.animalName = "새";
		this.animalType = "참새";
		this.animalSound = "짹쨱짹";
	}

	@Override
	protected void animalEat() {
		System.out.println("초식성");
	}

	@Override
	protected void animalSleep() {
		System.out.println("서서 잠");
	}
}
