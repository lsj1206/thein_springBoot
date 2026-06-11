package com.lsj_abst;

class Cat extends Animal  {

	Cat() {
		this.animalName = "고양이";
		this.animalType = "러시안 블루";
		this.animalSound = "냐옹";
	}

	@Override
	protected void animalEat() {
		System.out.println("잡식성 2");
	}

	@Override
	protected void animalSleep() {
		System.out.println("웅크려서 잠");
	}

}
