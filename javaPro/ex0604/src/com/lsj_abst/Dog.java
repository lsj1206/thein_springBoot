package com.lsj_abst;

class Dog extends Animal  {
	
	Dog() {
		this.animalName = "개";
		this.animalType = "진돗개";
		this.animalSound = "멍";
	}

	@Override
	protected void animalEat() {
		System.out.println("잡식성 3");
	}

	@Override
	protected void animalSleep() {
		System.out.println("엎드려서 잠");
	}
}
