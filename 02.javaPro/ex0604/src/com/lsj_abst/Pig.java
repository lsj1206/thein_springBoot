package com.lsj_abst;

class Pig extends Animal {
	
	Pig() {
		this.animalName = "돼지";
		this.animalType = "흑돼지";
		this.animalSound = "꿀꿀";
	};

	@Override
	protected void animalEat() {
		System.out.println("잡식성");
	}

	@Override
	protected void animalSleep() {
		System.out.println("누워서 잠");
	}
}
