package com.bet.springboot.crudrestfullwebservices.model;

import lombok.Getter;

/**
 * Enumeration to set the kind of sport of the match
 */
@Getter
public enum Sport{
	FOOTBALL("1"), BASKETBALL("2");

	private String sportId;
	
	private Sport(String sportId) {
		this.sportId = sportId;
	}

	public String getSportId() {
		return sportId;
	}
	
	

}
