package com.lsj_1;

enum Level2 {
	LOW("Low Level"),
	MEDIUM("Medium Level"),
	HIGH("High Level");
	
	// enum 생성자
	private String description;

	private Level2(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
